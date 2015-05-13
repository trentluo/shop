package com.rency.shop.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class IndexAction {
	
	private static final Logger logger = LoggerFactory.getLogger(IndexAction.class);

	@RequestMapping("/my/home.htm")
	public ModelAndView home(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		
	}
	
}
