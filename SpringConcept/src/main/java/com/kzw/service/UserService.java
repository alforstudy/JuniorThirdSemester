package com.kzw.service;

import com.kzw.annotation.Bean;
import com.kzw.annotation.Inject;
import com.kzw.dao.UserDao;

@Bean
public class UserService {

	@Inject
	private UserDao userDao;

	public void save() {
		userDao.save();
	}
}
