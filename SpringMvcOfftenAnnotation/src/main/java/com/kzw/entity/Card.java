package com.kzw.entity;

public class Card {

	private Integer id;
	private String name;
	private String sno;

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

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	@Override
	public String toString() {
		return String.format("Card: id=%d, name=%s, sno=%s",  id, name, sno);
	}
}
