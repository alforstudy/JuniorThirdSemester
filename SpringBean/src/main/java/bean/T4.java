package bean;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T4 {

	public static void main(String[] args) throws Exception {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans2.xml");
		
		MyCollect collect = ctx.getBean(MyCollect.class);
		System.out.println(Arrays.toString(collect.getArray()));
		System.out.println(collect.getList());
		System.out.println(collect.getSet());
		System.out.println(collect.getMap());
		System.out.println(collect.getProp());
		System.out.println(collect.getProp2());
		
		ctx.close();
	}
}
