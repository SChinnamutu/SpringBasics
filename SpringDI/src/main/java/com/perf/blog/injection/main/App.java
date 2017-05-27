package com.perf.blog.injection.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.perf.blog.service.SimpleService;

public class App {

	public static void main(String[] args) {
			ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			SimpleService simpleService = (SimpleService) context.getBean("simpleServiceBean");
			simpleService.printNameId();
			context.close();
	}
}
