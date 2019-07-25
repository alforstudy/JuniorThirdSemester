package com.kzw.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

public class Jackson {

	private ObjectMapper objectMapper;
	private SimpleFilterProvider filterProvider = new SimpleFilterProvider();
	private int index = 0;

	public static Jackson me() {
		return new Jackson();
	}

	private Jackson() {
		objectMapper = new ObjectMapper();
		// 设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
	}

	/**
	 * 过滤
	 */
	public Jackson filter(String filterName, String... properties) {
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter(filterName,
				SimpleBeanPropertyFilter.serializeAllExcept(properties));
		objectMapper.setFilterProvider(filterProvider);
		return this;
	}

	/**
	 * 只输出指定属性
	 */
	public Jackson with(Class<?> target, String... properties) {
		objectMapper.addMixIn(target, Mixin.all.get(index));
		filterProvider.addFilter("filter" + index, SimpleBeanPropertyFilter.filterOutAllExcept(properties));
		index++;

		objectMapper.setFilterProvider(filterProvider);
		return this;
	}

	/**
	 * 不输出指定属性
	 */
	public Jackson without(Class<?> target, String... properties) {
		objectMapper.addMixIn(target, Mixin.all.get(index));
		filterProvider.addFilter("filter" + index, SimpleBeanPropertyFilter.serializeAllExcept(properties));
		index++;

		objectMapper.setFilterProvider(filterProvider);
		return this;
	}

	public Jackson setDateFormate(String dateFormat) {
		objectMapper.setDateFormat(new SimpleDateFormat(dateFormat));
		return this;
	}

	public <T> T fromJson(String json, Class<T> clazz) {
		try {
			return objectMapper.readValue(json, clazz);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("解析json错误");
		}
	}

	public String toJson(Object obj) {
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("解析对象错误");
		}
	}

	public ObjectMapper getMapper() {
		return objectMapper;
	}

}

class Mixin {

	public static List<Class<?>> all = new ArrayList<Class<?>>();
	static {
		all.add(Mixin0.class);
		all.add(Mixin1.class);
		all.add(Mixin2.class);
		all.add(Mixin3.class);
		all.add(Mixin4.class);
		all.add(Mixin5.class);
		all.add(Mixin6.class);
		all.add(Mixin7.class);
		all.add(Mixin8.class);
		all.add(Mixin9.class);
		all.add(Mixin10.class);
		all.add(Mixin11.class);
		all.add(Mixin12.class);
		all.add(Mixin13.class);
		all.add(Mixin14.class);
		all.add(Mixin15.class);
		all.add(Mixin16.class);
		all.add(Mixin17.class);
		all.add(Mixin18.class);
		all.add(Mixin19.class);
	}

	@JsonFilter("filter0")
	public static interface Mixin0 {
	}

	@JsonFilter("filter1")
	public static interface Mixin1 {
	}

	@JsonFilter("filter2")
	public static interface Mixin2 {
	}

	@JsonFilter("filter3")
	public static interface Mixin3 {
	}

	@JsonFilter("filter4")
	public static interface Mixin4 {
	}

	@JsonFilter("filter5")
	public static interface Mixin5 {
	}

	@JsonFilter("filter6")
	public static interface Mixin6 {
	}

	@JsonFilter("filter7")
	public static interface Mixin7 {
	}

	@JsonFilter("filter8")
	public static interface Mixin8 {
	}

	@JsonFilter("filter9")
	public static interface Mixin9 {
	}

	@JsonFilter("filter10")
	public static interface Mixin10 {
	}

	@JsonFilter("filter11")
	public static interface Mixin11 {
	}

	@JsonFilter("filter12")
	public static interface Mixin12 {
	}

	@JsonFilter("filter13")
	public static interface Mixin13 {
	}

	@JsonFilter("filter14")
	public static interface Mixin14 {
	}

	@JsonFilter("filter15")
	public static interface Mixin15 {
	}

	@JsonFilter("filter16")
	public static interface Mixin16 {
	}

	@JsonFilter("filter17")
	public static interface Mixin17 {
	}

	@JsonFilter("filter18")
	public static interface Mixin18 {
	}

	@JsonFilter("filter19")
	public static interface Mixin19 {
	}

}
