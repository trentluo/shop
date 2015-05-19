package com.rency.shop.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.code.kaptcha.Producer;
import com.rency.shop.web.entity.User;

@Controller
@RequestMapping("/")
public class LoginAction {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginAction.class);

	@Autowired
	@Qualifier("kaptchaProducer")
	private Producer kaptchaProducer = null;
	
	/**
	 * 创建验证码图片
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/login.htm")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response,User user) throws Exception{
        return null;
	}
	
}
