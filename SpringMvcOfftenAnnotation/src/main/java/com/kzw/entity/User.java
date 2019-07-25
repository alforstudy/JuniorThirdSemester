package com.kzw.entity;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

public class User {

	private Integer id;

	@Pattern(regexp = "[a-zA-Z]{5,}", message = "至少5个英文字母")
	private String name;

	@Range(min = 18, max = 60)
	private int age;

	@Future
	private Date ctime;

	private Card card;

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	@Override
	public String toString() {
		return String.format("User: id=%d, name=%s, age=%d", id, name, age);
	}

}
