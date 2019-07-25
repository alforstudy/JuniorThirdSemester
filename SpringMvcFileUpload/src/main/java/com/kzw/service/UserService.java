package com.kzw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kzw.dao.UserDao;
import com.kzw.entity.User;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserDao userDao;

	public void save(User user) {
		userDao.save(user);
	}
	
	public List<User> findAll() {
		return userDao.findAll();
	}
}
