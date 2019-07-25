package com.kzw.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kzw.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
