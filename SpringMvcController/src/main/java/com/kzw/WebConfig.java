package com.kzw;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Controller;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Spring MVC的配置文件
 */
@Configuration
@EnableWebMvc
@ComponentScan(includeFilters = @Filter(type = FilterType.ANNOTATION, value = Controller.class))
public class WebConfig extends WebMvcConfigurerAdapter {

	/**
	 * 静态资源映射
	 * */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		super.addResourceHandlers(registry);
	}

	/**
	 * 重定向或者请求映射到视图名
	 * */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		super.addViewControllers(registry);
	}

	/**
	 * 视图解析器
	 * */
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		super.configureViewResolvers(registry);
		
		registry.jsp("/WEB-INF/jsp/", ".jsp");
	}

	
}
