package com.kzw;

import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 该类会被Servler自动检测到
 * 可以在该类上注册servlet, filter, listener
 * */
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * 指定Spring的配置文件
	 * */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { AppConfig.class };
	}

	/**
	 * 指定Spring MVC的配置文件
	 * */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfig.class };
	}

	/**
	 * Spring MVC拦截的url
	 * */
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	/**
	 * 注册servlet, filter, listener
	 * */
	@Override
	public void onStartup(ServletContext sc) throws ServletException {
		super.onStartup(sc);
		
		// 注册listener
		sc.addListener(RequestContextListener.class);
		
		// 注册filter
		Dynamic filter = sc.addFilter("CharacterEncodingFilter", CharacterEncodingFilter.class);
		filter.setInitParameter("encoding", "UTF-8");
		filter.addMappingForUrlPatterns(null, false, "/*");
	}

}
