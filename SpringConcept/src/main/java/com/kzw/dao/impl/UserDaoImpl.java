package com.kzw.dao.impl;

import com.kzw.annotation.Bean;
import com.kzw.dao.UserDao;

@Bean("userDao")
public class UserDaoImpl implements UserDao {

	@Override
	public void save() {
		System.out.println("保存了用户……");
	}

}
