package com.jdbc.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
/**
 * 定义切面类
 * @Aspect 是定义一个切面类的注解
 * @Component 是定义一个组件的注解
 * 
 * 
 * @author Male
 *
 */
public class MyAspect {

	/**
	 * 设置公共切入点:
	 * 	1. 定义一个私有的方法
	 *  2. 在方法上使用@Around(value=私有方法()), value 可以省略
	 * 
	 * 不设置公共切入点:
	 * 	直接在方法上使用@PointCut("execute(xxxxxx)")
	 * 
	 * 环绕通知必须：方法名随便写
	 * 	public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
	 * 		// 方法前
	 * 		Object obj = proceedingJoinPoint.proceed();
	 * 		// 方法后
	 * 		return obj;
	 * }
	 */
	@Pointcut("execution(* com.jdbc.*.impl.*.transfer(..))")
	private void myPointCut(){}
	
	// aop
	@Around(value="myPointCut()")
	public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		before();
		Object obj = proceedingJoinPoint.proceed();
		after();
		return obj;
	}
	
	public void before() {
		System.out.println("=====转账前====");
	}
	
	public void after() {
		System.out.println("====转账后====");
	}
}
