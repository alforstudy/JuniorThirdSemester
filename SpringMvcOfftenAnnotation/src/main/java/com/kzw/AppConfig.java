package com.kzw;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * Spring的配置文件
 */
@Configuration
@ComponentScan(excludeFilters = @Filter(type = FilterType.ANNOTATION, value = Controller.class))
public class AppConfig {

}
