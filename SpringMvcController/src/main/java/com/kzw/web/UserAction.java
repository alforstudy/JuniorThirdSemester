package com.kzw.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import com.kzw.entity.User;

@Controller
@RequestMapping("/user")
@SessionAttributes({"name"})
public class UserAction {

	@RequestMapping("test1")
	public String test1(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println(req.getContextPath());
		return "hello";
	}
	
	@RequestMapping("test2")
	public String test2(WebRequest req) {
		System.out.println(req.getContextPath() + ", " + req.getParameter("name"));
		return "hello";
	}
	
	@RequestMapping("test3")
	public String test3(String name, @RequestParam(defaultValue="1") Integer age) {
		System.out.println(name + ", " + age);
		return "hello";
	}

	@RequestMapping("test4")
	public String test4(User user) {
		System.out.println(user.getName() + ", " + user.getAge());
		System.out.println(user.getCtime());
		return "hello";
	}
	
	@RequestMapping("get")
	public String get(Integer id) {
		System.out.println(id);
		return "hello";
	}
	
	@RequestMapping("get/{id}")
	public String get2(@PathVariable Integer id) {
		System.out.println(id);
		return "hello";
	}	
	
	@RequestMapping("test5")
	public String test5(@RequestHeader("User-Agent") String agent, @CookieValue("JSESSIONID") String sessionId) {
		System.out.println(agent);
		System.out.println(sessionId);
		return "hello";
	}
	
	@RequestMapping("test6")
	public String test6(Model model) {
		// Model, Map, ModelMap
		model.addAttribute("name", "张三");
		return "hello";
	}
	
	// 从session中获得值
	@RequestMapping("test6_2")
	public String test6_1(@ModelAttribute("name") String name) {
		System.out.println(name);
		return "hello";
	}
	
	@RequestMapping("logout")
	public String test6_2(HttpSession session) {
		session.invalidate(); //无法清空session中的数据
		return "hello";
	}
	
	@RequestMapping("logout_2")
	public String test6_3(SessionStatus status) {
		status.setComplete(); //清空session中的数据
		return "hello";
	}
	
	

	@RequestMapping("test7")
	public String test7(User user, Errors errs) {
		System.out.println(user.getName() + ", " + user.getAge());
		System.out.println(user.getCtime());
		
		if(errs.hasErrors()) {
			List<ObjectError> list = errs.getAllErrors();
			for(ObjectError err : list) {
				System.out.println(err.getDefaultMessage());
			}
		}
		
		return "hello";
	}
	
	/**
	 * 绑定初始化（每次方法调用都会执行）
	 * 只对当前Controller类的方法有效
	 * */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, true));
	}
	
	
	
}
