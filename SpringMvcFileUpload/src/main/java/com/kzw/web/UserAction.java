package com.kzw.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kzw.entity.User;
import com.kzw.service.UserService;
import com.kzw.utils.Jackson;
import com.kzw.utils.ResponseUtils;

@Controller
@RequestMapping("/user")
public class UserAction {
	
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("save")
	public String save(User user, BindingResult br) {
		userService.save(user);
		return "redirect:/user/list";
	}
	
	@RequestMapping("list")
	public void list(HttpServletResponse resp) {
		List<User> list = userService.findAll();
		String json = Jackson.me().without(User.class, "card").toJson(list);
		ResponseUtils.renderJson(resp, json);
	}
	

	/**
	 * 当前类中所有方法的参数绑定，都会调用
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, true));
	}

}
