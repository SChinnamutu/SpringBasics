package com.perf.blog.aspect;

	import org.aspectj.lang.JoinPoint;
	import org.aspectj.lang.annotation.Aspect;
	import org.aspectj.lang.annotation.After;
	 
	@Aspect
	public class DoAfterAspect {
	 
		@After("execution(* com.perf.blog.aspect.main.SimpleService.sayHello(..))")
		public void doAfter(JoinPoint joinPoint) {
			System.out.println("***AspectJ*** DoAfter() is running!! intercepted : " + joinPoint.getSignature().getName());
		}
	 
	}
