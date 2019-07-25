package com.kzw.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kzw.service.UserService;

public class Test1 {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		UserService service = (UserService) ctx.getBean("userService");
		service.save();

		UserService service2 = ctx.getBean(UserService.class);
		System.out.println(service == service2);

		ctx.close();
	}
}
