package com.perf.blog.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.perf.blog.services.MessageService;

@Component
public class MyApplication {
	
	private MessageService service;
	
	
	public boolean processMessage(String msg, String rec){
		return this.service.sendMessage(msg, rec);
	}
	
	@Autowired
	public void setService(MessageService svc){
		this.service=svc;
	}
}
