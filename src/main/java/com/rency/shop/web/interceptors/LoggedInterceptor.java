package com.rency.shop.web.interceptors;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.rency.commons.toolbox.common.SYSDICT;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoggedInterceptor extends HandlerInterceptorAdapter {

	/**
	 * 在业务处理之前调用
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		return super.preHandle(request, response, handler);
	}

	/**
	 * 在业务处理器处理请求执行完成后,生成视图之前执行的动作
	 */
	@Override
	public void postHandle(HttpServletRequest request,HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
		Enumeration en = request.getHeaderNames();
    	while(en.hasMoreElements()){
    		System.out.println(en.nextElement());
    	}
    	String fromUrl = request.getParameter(SYSDICT.URL_PARAM_CALLBACK_KEY);
	}

	/**
	 * 在DispatcherServlet完全处理完请求后被调用
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,HttpServletResponse response, Object handler, Exception ex)throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}

}
