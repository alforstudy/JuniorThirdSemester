package com.kzw;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kzw.annotation.Bean;
import com.kzw.annotation.Inject;

/**
 * 容器类
 * */
public class MyApplicationContext {

	private String basePackage;
	private String basePath;
	// 存放bean实例的容器
	private Map<String, Object> map = new HashMap<>();
	
	/**
	 * 解析注解：
	 * 	1、扫描指定包及其子包下面的类，找出标注了@Bean注解的类
	 * 	2、通过@Bean注解进行bean的装配
	 * 	3、通过@Inject注解进行依赖对象注入
	 * 
	 *  @param basePackage 包名，如 com.kzw
	 * */
	public MyApplicationContext(String basePackage) {
		this.basePackage = basePackage;
		try {
			String path = basePackage.replace(".", "/");
			path = this.getClass().getResource("/" + path).toURI().getPath();
			File dir = new File(path);
			// 获得文件的规范路径
			basePath = dir.getCanonicalPath();
			
			//1、扫描指定包及其子包下面的类，找出标注了@Bean注解的类
			List<Class<?>> list = new ArrayList<>();
			scanFile(list, dir);
			
			//2、通过@Bean注解进行bean的装配（单例模式）
			for(Class<?> cls : list) {
				Bean bean = cls.getAnnotation(Bean.class);
				String id = bean.value();
				if(id.equals("")) {
					id = cls.getSimpleName();
					id = id.substring(0, 1).toLowerCase() + id.substring(1);
				}
				// 创建bean的实例：使用无参的构造方法
				Object object = cls.newInstance();
				map.put(id, object);
			}
			
			//3、通过@Inject注解进行依赖对象注入
			for(Class<?> cls : list) {
				// 获得当前类对应的bean实例
				Bean bean = cls.getAnnotation(Bean.class);
				String id = bean.value();
				if(id.equals("")) {
					id = cls.getSimpleName();
					id = id.substring(0, 1).toLowerCase() + id.substring(1);
				}
				Object object = map.get(id);
				
				// 获得当前类中所有标注了@Inject注解的属性
				Field[] fields = cls.getDeclaredFields();
				for(Field fd : fields) {
					if(fd.isAnnotationPresent(Inject.class)) {
						Inject inject = fd.getAnnotation(Inject.class);
						String refid = inject.value();
						if(refid.equals("")) {
							refid = fd.getName();
							// 获得依赖对象的bean实例
							Object obj = map.get(refid);
							if(obj != null) {
								// 进行依赖注入, 属性赋值
								fd.setAccessible(true);
								fd.set(object, obj);
								fd.setAccessible(false);
							}
						}
					}
				}				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 递归访问目录
	 * */
	private void scanFile(List<Class<?>> list, File file) throws Exception {
		// 递归的结束条件
		if(file.isFile()) {
			String fname = file.getName();
			if(fname.endsWith(".class")) {
				// 根据物理路径获得类的全限定名
				String path = file.getCanonicalPath();
				path = basePackage + path.substring(basePath.length());
				String cname = path.substring(0, path.length()-6).replace(File.separator, ".");
				
				// 创建Class类型，并扫描是否有@Bean
				Class<?> cls = Class.forName(cname);
				if(cls.isAnnotationPresent(Bean.class)) {
					list.add(cls);
				}
			}			
			return;
		}
		// 递归公式
		File[] files = file.listFiles();
		for(File f : files) {
			scanFile(list, f);
		}
	}

	/**
	 * 根据bean的ID获得实例对象
	 * */
	public Object getBean(String id) {
		return map.get(id);
	}
}
