package com.rency.shop.web.filter;

import java.io.IOException;
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import com.rency.shop.web.tools.Const;

public class UnSecurityFilter implements Filter, InitializingBean{
	
	private static final Logger logger = LoggerFactory.getLogger(UnSecurityFilter.class);
	
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
	        HttpServletResponse response = (HttpServletResponse) servletResponse;
	        String url = request.getRequestURI().toString();
	        logger.info("filter url:"+url);
	        if(urls != null && urls.size() > 0){
	        	for(String u : urls){
	        		if(url.indexOf(u) != -1){
	        			chain.doFilter(request, response);
	        			return;
	        		}
	        	}
	        }
	        if(session.getAttribute(Const.SESSION_USER_KEY) != null){
	        	
	        }
	        chain.doFilter(request, response);
		}catch(Exception e){
			
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("init unsecurity url filter configuration."+urls.size());
		
	}

	public List<String> getUrls() {
		return urls;
	}

	public void setUrls(List<String> urls) {
		this.urls = urls;
	}

}
