package com.kzw.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kzw.service.UserService;

@Controller
@RequestMapping("/user")
public class UserAction {
	
	@Autowired
	private UserService userService;

	/**
	 * 请求映射：/user/test1 映射到该方法
	 * 	当方法返回值为void时，默认的视图名为当前的请求路径（user/test1）
	 * 		跳转路径：前缀 + 视图名 + 后缀
	 * 		/jsp/user/test1.jsp
	 * */
	@RequestMapping("test1")
	public void test1() {
		System.out.println("hello, test1");
	}
	
	@RequestMapping("test2")
	public String test2(HttpServletRequest request) {
		System.out.println(request.getContextPath());
		System.out.println("hello, test2");
		return "test2";
	}
	
	@RequestMapping("test3")
	public String test3(int x, int y, Map<String, Object> map) {
		int result = userService.add(x, y);
		map.put("total", result);
		
		return "user/test1";
	}
}
