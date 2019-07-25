package com.kzw.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.kzw.entity.Card;
import com.kzw.entity.User;

@Controller
@RequestMapping("/user")
@SessionAttributes({"name"})
public class UserAction {

	@RequestMapping(method=RequestMethod.POST)
	public String t1() {
		System.out.println("t1...");
		return "hello";
	}
	
	@RequestMapping("t2")
	public String t2(@RequestParam(defaultValue="hello") String name, Model model) {
		System.out.println(name);
		model.addAttribute("name", name); // request作用域
		return "hello";
	}
	
	@RequestMapping("t3")
	public String t3(@RequestHeader("User-Agent") String agent, @CookieValue("JSESSIONID") String sessionId) {
		System.out.println(agent);
		System.out.println(sessionId);
		return "hello";
	}
	
	@RequestMapping("t4/{id}")
	public String t4(@PathVariable Integer id) {
		System.out.println(id);
		return "hello";
	}
	
	@RequestMapping("t5")
	public String t5(User user, BindingResult br) {
		System.out.println(user);
		System.out.println(user.getCtime());
		
		if(br.hasErrors()) {
			List<FieldError> list = br.getFieldErrors();
			for(FieldError err : list) {
				System.out.println(err.getField() + ": " + err.getDefaultMessage());
			}
		}
		
		return "hello";
	}
	
	
	@RequestMapping("t6")
	public String t6(User user, BindingResult br) {
		System.out.println(user);
		System.out.println(user.getCtime());
		System.out.println(user.getCard());
		
		if(br.hasErrors()) {
			List<FieldError> list = br.getFieldErrors();
			for(FieldError err : list) {
				System.out.println(err.getField() + ": " + err.getDefaultMessage());
			}
		}
		
		return "hello";
	}
	
	/**
	 * 请求参数带前缀，区分对象
	 * */
	@RequestMapping("t7")
	public String t7(User user2, Card card2) {
		System.out.println(user2);
		System.out.println(card2);		
		return "hello";
	}
	
	@InitBinder("user") //针对User类型变量
	public void binder1(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("user.");
	}
	@InitBinder("card") //针对card类型变量
	public void binder2(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("card.");
	}
	
	/**
	 * @ModelAttribute：
	 * 	1、从model中获得key=name的值（通常从SessionAttribute中获得）
	 * 	2、如果model中没有该对应值，自动将方法参数放入model中
	 * 
	 * 	如果name不在@SessionAttributes中，@ModelAttribute意义不大
	 * 	如果name在@SessionAttributes中，那么@ModelAttribute("name")必须有值
	 * */
	@RequestMapping("t8")
	public String t8(@ModelAttribute("name") String name) {
		System.out.println("==============");
		System.out.println(name);
		System.out.println("==============");
		return "hello";
	}
	
	// 清空@SessionAttribute指定的值
	@RequestMapping("t8_2")
	public String t8_2(HttpSession session) {
		session.invalidate();  //无效，不能清空@SessionAttributes指定的值
		return "hello";
	}
	
	@RequestMapping("t8_3")
	public String t8_3(SessionStatus status) {
		status.setComplete();  //有效，清空@SessionAttributes指定的值
		return "hello";
	}
	
	
	@RequestMapping("t9")
	public String t9(@Valid User user, BindingResult br) {
		System.out.println(user);
		System.out.println(user.getCtime());
		
		if(br.hasErrors()) {
			List<FieldError> list = br.getFieldErrors();
			for(FieldError err : list) {
				System.out.println(err.getField() + ": " + err.getDefaultMessage());
			}
		}
		
		return "hello";
	}
	
	
	
	/**
	 * 当前类中所有方法的参数绑定，都会调用
	 * */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		System.out.println("--- binder ---");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, true));
	}
	
}

