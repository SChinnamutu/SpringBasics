package com.perf.blog.service.impl;

import com.perf.blog.service.SimpleService;

public class SimpleServiceImpl implements SimpleService {

	private String name;

	private int id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void printNameId() {
		System.out.println("SimpleService : Method printNameId() : My name is " + name
			 + " and my id is " + id);
	}

	
}