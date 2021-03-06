package com.perf.blog.aspect;

	import org.aspectj.lang.JoinPoint;
	import org.aspectj.lang.annotation.Aspect;
	import org.aspectj.lang.annotation.AfterReturning;
	 
	@Aspect
	public class DoAfterReturningAspect {
	 
	   @AfterReturning(pointcut = "execution(* com.perf.blog.aspect.main.SimpleService.sayHello(..))", returning= "result")
	   public void doAfterReturning(JoinPoint joinPoint, Object result) {
		System.out.println("***AspectJ*** DoAfterReturning() is running!! intercepted : " + joinPoint.getSignature().getName());
		System.out.println("Method returned value is : " + result);
	 
	   }
	 
	}
