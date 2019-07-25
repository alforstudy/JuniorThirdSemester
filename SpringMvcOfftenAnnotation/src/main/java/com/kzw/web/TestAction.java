package com.kzw.web;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.kzw.entity.User;
import com.kzw.utils.Jackson;
import com.kzw.utils.ResponseUtils;

@RestController
@RequestMapping("/test")
public class TestAction {

	/**
	 * AJAX请求，没有页面跳转，输出JSON文本
	 * */
	@RequestMapping("t1")
	public User t1() {
		User user = new User();
		user.setName("王五");
		user.setAge(20);
		user.setCtime(new Date());
		return user;
	}

	/**
	 * AJAX请求，没有页面跳转，输出JSON文本 手动渲染JSON，非常灵活
	 * */
	@RequestMapping("t2")
	public void t2(HttpServletResponse resp) {
		User user = new User();
		user.setName("王五");
		user.setAge(20);
		user.setCtime(new Date());

		String json = Jackson.me().setDateFormate("yyyy-MM-dd HH:mm").without(User.class, "id").toJson(user);
		ResponseUtils.renderJson(resp, json);
	}

	/**
	 * 进行页面跳转，必须返回ModelAndView
	 * */
	@RequestMapping("t3")
	public ModelAndView t3() {
		ModelAndView mv = new ModelAndView("hello");
		mv.addObject("name", "张三");
		return mv;
	}
}
