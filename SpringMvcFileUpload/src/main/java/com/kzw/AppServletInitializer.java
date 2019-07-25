package com.kzw;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;

import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 启动器
 */
public class AppServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { AppConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	/**
	 * 文件上传的配置
	 */
	@Override
	protected void customizeRegistration(javax.servlet.ServletRegistration.Dynamic registration) {
		super.customizeRegistration(registration);

		String location = System.getProperty("java.io.tmpdir"); // 上传临时目录
		long maxFileSize = 10 * 1024 * 1024; // 单个文件的最大字节数
		long maxRequestSize = 30 * 1024 * 1024; // 一次请求的最大字节数
		MultipartConfigElement config = new MultipartConfigElement(location, maxFileSize, maxRequestSize, 0);
		registration.setMultipartConfig(config);
	}

	@Override
	protected Filter[] getServletFilters() {
		return new Filter[] {
			new CharacterEncodingFilter("UTF-8", true),
			new OpenEntityManagerInViewFilter()
		};
	}

}
