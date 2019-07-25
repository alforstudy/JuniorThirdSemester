package com.kzw;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Spring MVC的配置文件：只扫描@Controller注解
 * */
@Configuration
@EnableWebMvc
@ComponentScan(includeFilters = @Filter(type = FilterType.ANNOTATION, value = Controller.class))
public class WebConfig extends WebMvcConfigurerAdapter {

	/**
	 * 配置视图解析器
	 * */
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		super.configureViewResolvers(registry);
		
		registry.jsp("/WEB-INF/jsp/", ".jsp");
	}

	/**
	 * 静态资源访问
	 * */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		super.addResourceHandlers(registry);
		
		registry.addResourceHandler("/css/**").addResourceLocations("/static/css/");
		registry.addResourceHandler("/img/**").addResourceLocations("/static/image/");
		
		// 本地文件
		registry.addResourceHandler("/upload/**").addResourceLocations("file:///E:/bak/");		
	}

	/**
	 * 请求直接映射到视图
	 * */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		super.addViewControllers(registry);
		
		// 请求重定向
		registry.addRedirectViewController("/", "/user/test1");
		// 请求映射到视图名
		registry.addViewController("/hello2").setViewName("hello");
	}

	
}
