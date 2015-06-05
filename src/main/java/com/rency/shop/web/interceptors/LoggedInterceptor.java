package com.rency.shop.web.interceptors;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.rency.common.utils.domain.SYSDICT;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.rency.shop.web.entity.RespBody;

public class LoggedInterceptor extends HandlerInterceptorAdapter {

	/**
	 * 在业务处理之前调用
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		return true;
	}

	/**
	 * 在业务处理器处理请求执行完成后,生成视图之前执行的动作
	 */
	@Override
	public void postHandle(HttpServletRequest request,HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
    	String fromUrl = request.getParameter(SYSDICT.URL_PARAM_CALLBACK_KEY);
    	fromUrl = StringUtils.isBlank(fromUrl) ? request.getHeader("referer") : fromUrl;
    	if(modelAndView == null){
    		return;
    	}    	
    	Map<String, Object> model = modelAndView.getModel();
    	RespBody resp = (RespBody) model.get("resp");
    	resp.setCallback(fromUrl);
	}

	/**
	 * 在DispatcherServlet完全处理完请求后被调用
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,HttpServletResponse response, Object handler, Exception ex)throws Exception {
	}

}
