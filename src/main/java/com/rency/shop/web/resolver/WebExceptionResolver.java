package com.rency.shop.web.resolver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class WebExceptionResolver extends SimpleMappingExceptionResolver{

	private static final Logger logger = LoggerFactory.getLogger(WebExceptionResolver.class);
	@Override
	protected String buildLogMessage(Exception ex, HttpServletRequest request) {
		StringBuffer message = new StringBuffer("页面操作异常");
        message.append("页面路径").append(request.getRequestURI());
        logger.error(message.toString(),ex);
        request.setAttribute("error", ex);
        return message.toString();
	}

	@Override
	protected void logException(Exception ex, HttpServletRequest request) {
		logger.error(buildLogMessage(ex, request), ex);
	}

}
