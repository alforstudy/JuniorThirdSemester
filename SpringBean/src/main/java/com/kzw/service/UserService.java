package com.kzw.service;

import com.kzw.dao.UserDao;

public class UserService {

	private UserDao userDao;

	// 使用setter方法进行注入
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void save() {
		userDao.save();
	}
}
