package com.rency.shop.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * 错误处理
 * </p>
 * 
 * @author eric
 * @version $Id: LoginAction.java, v 0.1 2013-7-18 下午6:07:43 Exp $
 */
@Controller
public class ErrorAction extends BaseAction {

	/**
	 * 进入错误页面
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/error.htm", method = { RequestMethod.POST,RequestMethod.GET })
	public ModelAndView error(HttpServletRequest req, HttpServletResponse resp,ModelMap model) {
		HttpSession session = req.getSession();
		return new ModelAndView("url", "response", "obj");
	}

	/**
	 * 404处理
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/error/404.htm", method = { RequestMethod.POST,RequestMethod.GET })
	public ModelAndView error404(HttpServletRequest req,HttpServletResponse resp, ModelMap model) {
		HttpSession session = req.getSession();
		return new ModelAndView("common/error/404", "response", "obj");
	}

	/**
	 * 500处理
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/error/500.htm", method = { RequestMethod.POST,RequestMethod.GET })
	public ModelAndView error500(HttpServletRequest req,HttpServletResponse resp, ModelMap model) {
		HttpSession session = req.getSession();
		return new ModelAndView("common/error/500", "response", "obj");
	}

}
