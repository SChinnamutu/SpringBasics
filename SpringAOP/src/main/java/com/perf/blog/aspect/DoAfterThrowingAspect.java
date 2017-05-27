package com.perf.blog.aspect;

	import org.aspectj.lang.JoinPoint;
	import org.aspectj.lang.annotation.Aspect;
	import org.aspectj.lang.annotation.AfterThrowing;
	 
	@Aspect
	public class DoAfterThrowingAspect {
	 
	   @AfterThrowing(pointcut = "execution(* com.perf.blog.aspect.main.SimpleService.checkName(..))",
	      throwing= "error")
	    public void doAfterThrowing(JoinPoint joinPoint, Throwable error) {
		   System.out.println("***AspectJ*** DoAfterThrowing() is running!! intercepted : " + joinPoint.getSignature().getName());
		   System.out.println("Exception : " + error);
		   System.out.println("******");
	    }
	}
