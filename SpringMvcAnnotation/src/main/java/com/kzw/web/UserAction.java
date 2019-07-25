package com.kzw.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kzw.service.UserService;

@Controller
@RequestMapping("/user")
public class UserAction {

	@Autowired
	private UserService userService;
	
	@RequestMapping("test1")
	public String test1() {
		System.out.println("hello world");
		return "hello";
	}
	
	@RequestMapping("test2")
	public String test2(@RequestParam(defaultValue="0") int x, @RequestParam(defaultValue="1")int y, Model model) {
		int total = userService.add(x, y);
		model.addAttribute("total", total);
		
		return "user/test1";
	}
	
	/**
	 * 简单将/user/hello映射到某一个页面
	 * */
	@RequestMapping("hello")
	public String hello() {
		return "hello";
	}
}
