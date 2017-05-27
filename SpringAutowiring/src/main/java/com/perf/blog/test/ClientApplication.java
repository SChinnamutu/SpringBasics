package com.perf.blog.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.perf.blog.configuration.DIConfiguration;
import com.perf.blog.consumer.MyApplication;

public class ClientApplication {

	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DIConfiguration.class);
		MyApplication app = context.getBean(MyApplication.class);
		app.processMessage("Messi is the best player", "on the planet");
		context.close();
	}

}
