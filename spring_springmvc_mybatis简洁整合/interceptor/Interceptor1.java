package com.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 拦截器实现HandlerInterceptor接口
 * @author Male
 *
 */
public class Interceptor1 implements HandlerInterceptor {

	/**
	 * 在处理器映射器之前执行
	 * 
	 * return false表示拦截
	 * return true 表示放行
	 * 
	 * 通常使用这个方法
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("一个拦截器preHandle");
		response.sendRedirect("/springmvc/index.jsp");
		return false;
	}

	/**
	 * 还没有调用controller，还没有返回modelAndView执行
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("一个拦截器postHandle");
	}

	/**
	 * 返回modelAndView之后执行
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("一个拦截器afterCompletion");
	}

}
