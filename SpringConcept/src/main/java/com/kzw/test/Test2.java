package com.kzw.test;

import com.kzw.MyApplicationContext;
import com.kzw.service.UserService;

public class Test2 {

	public static void main(String[] args) {

		MyApplicationContext ctx = new MyApplicationContext("com.kzw");
		UserService service = (UserService)ctx.getBean("userService");
		service.save();
		
		UserService service2 = (UserService)ctx.getBean("userService");
		System.out.println(service == service2);
		
		// 自己new创建的对象的属性，是不会注入的
		UserService service3 = new UserService();
		service3.save();
	}
}
