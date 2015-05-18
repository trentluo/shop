package com.rency.shop.web.listener;

import javax.servlet.ServletContext;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.WebApplicationContext;

import com.rency.shop.web.WebDynamicResource;
import com.rency.shop.web.tools.Const;

public class ServletContextInitListener implements ApplicationContextAware {
	
	private WebDynamicResource webResource;

	public void setWebResource(WebDynamicResource webResource) {
		this.webResource = webResource;
	}

	@Override
	public void setApplicationContext(ApplicationContext ctx)throws BeansException {
		WebApplicationContext wc = (WebApplicationContext) ctx;
		ServletContext sc = (ServletContext) wc.getBean(WebApplicationContext.SERVLET_CONTEXT_BEAN_NAME);
		sc.setAttribute(Const.SYS_WEB_RESOURCE_KEY, webResource);
	}

}
