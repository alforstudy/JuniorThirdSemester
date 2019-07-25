package com.kzw;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
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
	 * 指定文件上传解析器，使用servlet文件上传时，还需要进行配置
	 * */
	@Bean
	public MultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}
	
	/**
	 * 静态资源映射
	 * */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		super.addResourceHandlers(registry);
		
		registry.addResourceHandler("/upload/**").addResourceLocations("/WEB-INF/upload/");
	}

	/**
	 * 重定向或者请求映射到视图名
	 * */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		super.addViewControllers(registry);
		
		registry.addViewController("/file1").setViewName("file1");
		registry.addViewController("/file2").setViewName("file2");
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
