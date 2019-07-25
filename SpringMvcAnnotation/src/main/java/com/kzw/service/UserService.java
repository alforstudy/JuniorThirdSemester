package com.kzw.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	public int add(int x, int y) {
		System.out.println(String.format("%d + %d = %d", x, y, x + y));
		return x + y;
	}
}
