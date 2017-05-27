package com.perf.blog.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.perf.blog.services.MessageService;
import com.perf.blog.services.impl.MessageServiceImpl;

@Configuration
@ComponentScan(value={"com.perf.blog.consumer"})
public class DIConfiguration {

	@Bean
	public MessageService getMessageService(){
		return new MessageServiceImpl();
	}
}
