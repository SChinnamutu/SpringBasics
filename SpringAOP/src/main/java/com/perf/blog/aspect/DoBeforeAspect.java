package com.perf.blog.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class DoBeforeAspect {

	@Before("execution(* com.perf.blog.aspect.main.SimpleService.sayHello(..))")
	public void doBefore(JoinPoint joinPoint) {
		System.out.println("***AspectJ*** DoBefore() is running!! intercepted : "
						+ joinPoint.getSignature().getName());
	}

}
