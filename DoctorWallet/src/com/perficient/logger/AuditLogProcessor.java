package com.perficient.logger;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class AuditLogProcessor {

	private static Logger log = Logger.getLogger(AuditLogProcessor.class);

    @After("execution(* com.perficient..*(..))")
    public void after() {
        log.info("==> after ooh dybala");
    }

    @Before("execution(* com.perficient..*(..))")
    public void before() {
        log.info("==> before ooh dybala");
    }
    
    @AfterThrowing(
			pointcut="execution(* com.perficient..*(..))",
			throwing="excep")
	public void afterThrowing(JoinPoint joinPoint, Throwable excep) throws Throwable {
			/*System.out.println("Inside CatchThrowException.afterThrowing() method...");
			System.out.println("Running after throwing exception...");
			System.out.println("Exception : " + excep);
			System.out.println("Exception : " + excep.getClass());
*/		
    	Logger.getLogger("Excepion occured in class " +excep.getMessage());
    }
    
}
