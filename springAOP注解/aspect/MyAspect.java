package com.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
/**
 * 切面类
 * @author Male
 *
 */
public class MyAspect {
	// 声明公共切入点
	@Pointcut("execution(* com.aop.dao.*.*(..))")
	private void myPointCut() {}

	// 环绕通知
	@Around(value = "myPointCut()")
	public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		System.out.println("环绕方法1");
		// 手动执行目标方法
		Object obj = proceedingJoinPoint.proceed();
		System.out.println("环绕方法2");
		return obj;
	}
}
