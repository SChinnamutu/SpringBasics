package com.perf.blog.services.impl;

import org.springframework.stereotype.Component;

import com.perf.blog.services.MessageService;

@Component
public class MessageServiceImpl implements MessageService {

	public boolean sendMessage(String msg, String rec) {
		System.out.println(msg+ " "+rec);
		return true;
	}
	
}
