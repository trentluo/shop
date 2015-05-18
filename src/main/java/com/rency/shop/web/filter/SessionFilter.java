package com.rency.shop.web.filter;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.rency.toolbox.common.SYSDICT;
import org.rency.toolbox.exception.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.rency.shop.web.entity.FreeURL;
import com.rency.shop.web.entity.User;
import com.rency.shop.web.tools.Const;

public class SessionFilter implements Filter, InitializingBean{
	
	private static final Logger logger = LoggerFactory.getLogger(SessionFilter.class);
	
	@Autowired
	@Qualifier("freeUrls")
	private FreeURL freeUrls;
	private List<String> urls = new ArrayList<String>();

	@Override
	public void afterPropertiesSet() throws Exception {
		
	}

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,FilterChain chain) throws IOException, ServletException {
		try{
			HttpServletRequest request = (HttpServletRequest) servletRequest;
	        HttpSession session = request.getSession();
	        User user = (User) session.getAttribute(Const.SESSION_USER_KEY);
	        HttpServletResponse response = (HttpServletResponse) servletResponse;
	        
	        String url = request.getRequestURI().toString();
	        logger.info("进入用户过滤器，过滤地址："+url);
	        
	        //判断用户是否需要登录
	        if(isInclude(url)){
	        	logger.debug("无需登录 | "+url);
	        	chain.doFilter(request, response);
	        	return;
	        }
	        
	        if(user == null){
	        	logger.info("用户session不存在，跳转至登录页面");
	        	String loginUrl = "/login/loginInput.htm?"+SYSDICT.URL_PARAM_CALLBACK_KEY+URLEncoder.encode(url,SYSDICT.CHARSET);
	        	response.sendRedirect(loginUrl);
	        	return;
	        }
	        chain.doFilter(request, response);
		}catch(Exception e){
			
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("init session filter configuration."+freeUrls.getFreeUrls().size());
		if(freeUrls.getFreeUrls() != null && freeUrls.getFreeUrls().size() > 0){
			urls.addAll(freeUrls.getFreeUrls());
		}
	}
	
	/**
	 * 判断是否为需要登陆地址
	 * @param uri
	 * @return false：需要；true不需要
	 * @throws BizException
	 */
	private boolean isInclude(String uri)throws BizException{
		//判断请求地址是否包含参数，过滤掉参数中的URL地址
		String url = uri.indexOf("?") != -1 ? uri.substring(0, uri.indexOf("?")):uri;
		for(String u : urls){
    		if(url.indexOf(u) != -1){
    			return true;
    		}
    	}
		return false;
	}

}
