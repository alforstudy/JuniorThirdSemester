package com.kzw.test;

import java.io.InputStream;
import java.util.Properties;

public class Test2 {

	public static void main(String[] args) throws Exception {
		
		InputStream is = Test2.class.getResourceAsStream("/jdbc2.properties");
		Properties prop = new Properties();
		prop.load(is);
		
		String name = prop.getProperty("name");
		System.out.println(name);
	}
}
