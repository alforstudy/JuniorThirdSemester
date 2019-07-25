package com.kzw.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kzw.entity.Card;

public interface CardDao extends JpaRepository<Card, Integer> {

}
