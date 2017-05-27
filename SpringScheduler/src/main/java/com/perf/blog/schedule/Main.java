package com.perf.blog.schedule;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    @SuppressWarnings("resource")
	public static void main(String[] args) {
        new ClassPathXmlApplicationContext("spring.xml");
    }
}
