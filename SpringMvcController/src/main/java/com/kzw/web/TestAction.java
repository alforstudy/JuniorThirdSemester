package com.kzw.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kzw.entity.User;
import com.kzw.utils.Jackson;
import com.kzw.utils.ResponseUtils;

@Controller
@RequestMapping("/test")
public class TestAction {

	@RequestMapping("test1")
	public void test1() {
		System.out.println("test1...");
	}
	
	@RequestMapping("test1_2")
	public void test1_2(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.getRequestDispatcher("/user/test1").forward(req, resp);
	}
	
	@RequestMapping("test2")
	public String test2() {
		return "hello";
	}
	
	@RequestMapping("test3")
	public ModelAndView test3() {
		ModelAndView mv = new ModelAndView("hello");
		mv.addObject("name", "李四");
		return mv;
	}
	
	@RequestMapping("hello")
	public ModelMap test4() {
		ModelMap mm = new ModelMap();
		mm.addAttribute("name", "李四");
		return mm;
	}
	
	@RequestMapping("hello2")
	public User test5() {
		User user = new User();
		user.setName("王五");
		user.setAge(20);
		return user;
	}
	
	/**
	 * AJAX请求，没有页面跳转，输出JSON文本
	 * @ResponseBody：自动渲染JSON，不灵活
	 * */
	@ResponseBody
	@RequestMapping("hello3")
	public User test6() {
		User user = new User();
		user.setName("王五");
		user.setAge(20);
		user.setCtime(new Date());
		return user;
	}

	/**
	 * AJAX请求，没有页面跳转，输出JSON文本
	 * 手动渲染JSON，非常灵活
	 * */
	@RequestMapping("hello4")
	public void test7(HttpServletResponse resp) {
		User user = new User();
		user.setName("王五");
		user.setAge(20);
		user.setCtime(new Date());
		
		String json = Jackson.me().setDateFormate("yyyy-MM-dd HH:mm").without(User.class, "id").toJson(user);
		ResponseUtils.renderJson(resp, json);
	}
	
}
