package com.kzw.test;

import com.kzw.service.UserService;

public class Test1 {

	public static void main(String[] args) {
		
		UserService userService = new UserService();
		userService.save();
	}
}
