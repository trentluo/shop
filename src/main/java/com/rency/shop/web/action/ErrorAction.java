package com.rency.shop.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rency.shop.web.tools.Const;

/**
 * error handler
 * @author rencaiyu
 *
 */
@Controller
public class ErrorAction extends BaseAction {

	/** 
	* @Fields serialVersionUID : TODO
	*/ 
	
	private static final long serialVersionUID = -1256090001584305517L;

	/**
	 * 进入错误页面
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/error.htm", method = { RequestMethod.POST,RequestMethod.GET })
	public ModelAndView error(HttpServletRequest req, HttpServletResponse resp,ModelMap model) {
		return new ModelAndView(Const.VIEW_SUFFIX_COMMON+"exception/error", "response", "obj");
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
		return new ModelAndView(Const.VIEW_SUFFIX_COMMON+"error/404", "response", "obj");
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
		return new ModelAndView(Const.VIEW_SUFFIX_COMMON+"error/500", "response", "obj");
	}

}
