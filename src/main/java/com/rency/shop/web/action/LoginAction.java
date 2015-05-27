package com.rency.shop.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.rency.commons.toolbox.common.SYSDICT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rency.shop.web.entity.User;
import com.rency.shop.web.tools.Const;

@Controller
@RequestMapping("/")
public class LoginAction extends BaseAction{
	
	private static final Logger logger = LoggerFactory.getLogger(LoginAction.class);
	
	/**
	 * 进入登录页面
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("loginInput.htm")
	public ModelAndView loginInput(HttpServletRequest request,HttpServletResponse response) throws Exception{
		logger.info("请求进入登录页面");
		String fromUrl = request.getParameter(SYSDICT.URL_PARAM_CALLBACK_KEY);
		respData.put(SYSDICT.URL_PARAM_CALLBACK_KEY, fromUrl);
        return view("login");
	}
	
	/**
	 * 登录
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("login.htm")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response,User user) throws Exception{
		System.out.println("login");
        return view(Const.VIEW_SUFFIX_MAIN+"/home.htm");
	}
	
	@RequestMapping("regInput.htm")
	public ModelAndView regInput(HttpServletRequest request,HttpServletResponse response) throws Exception{
		logger.info("请求进入注册页面");
		String fromUrl = request.getParameter(SYSDICT.URL_PARAM_CALLBACK_KEY);
		respData.put(SYSDICT.URL_PARAM_CALLBACK_KEY, fromUrl);
        return view(Const.VIEW_SUFFIX_MAIN+"register");
	}
	
	@RequestMapping("userReg.htm")
	public ModelAndView register(HttpServletRequest request,HttpServletResponse response) throws Exception{
		logger.info("会员注册");
		String fromUrl = request.getParameter(SYSDICT.URL_PARAM_CALLBACK_KEY);
		respData.put(SYSDICT.URL_PARAM_CALLBACK_KEY, fromUrl);
        return view(Const.VIEW_SUFFIX_MAIN+"home");
	}
	
}
