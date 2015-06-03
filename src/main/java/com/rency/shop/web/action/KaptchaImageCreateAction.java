package com.rency.shop.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.rency.commons.toolbox.utils.KaptchaUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class KaptchaImageCreateAction {
	
	private static final Logger logger = LoggerFactory.getLogger(KaptchaImageCreateAction.class);
	
	/**
	 * 创建验证码图片
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("captcha-image.htm")
	public ModelAndView creater(HttpServletRequest request,HttpServletResponse response) throws Exception{
		logger.debug("创建验证码图片");
		KaptchaUtils.generator(request, response);
        return null;
	}
	
}
