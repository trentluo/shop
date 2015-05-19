package com.rency.shop.web.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jasig.cas.client.util.CommonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.netfinworks.service.exception.ServiceException;
import com.netfinworks.site.core.common.RestResponse;
import com.netfinworks.site.core.common.constants.CommonConstant;
import com.netfinworks.site.domain.domain.member.EnterpriseMember;
import com.netfinworks.site.domain.enums.ResourceInfo;
import com.netfinworks.site.web.action.common.BaseAction;

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
		String msg = (String) session.getAttribute(CommonConstant.ERROR);
		RestResponse restP = new RestResponse();
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("member", user);
		restP.setData(data);
		model.put("response", user);
		model.put("error", msg);
		restP.setLogoutUrl(CommonUtils.getUcLogoutUrl(req, resp, ""));
		return new ModelAndView(ResourceInfo.ERROR.getUrl(), "response", restP);
	}

	/**
	 * 404处理
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/error/404.htm", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView error404(HttpServletRequest req,
			HttpServletResponse resp, ModelMap model) {
		HttpSession session = req.getSession();
		EnterpriseMember user = (EnterpriseMember) session
				.getAttribute(CommonConstant.SESSION_ATTR_NAME_CURRENT_USER);
		String msg = (String) session.getAttribute(CommonConstant.ERROR);
		RestResponse restP = new RestResponse();
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("member", user);
		restP.setData(data);
		model.put("response", user);
		model.put("error", msg);
		restP.setLogoutUrl(CommonUtils.getUcLogoutUrl(req, resp, ""));
		return new ModelAndView("common/error/404", "response", restP);
	}

	/**
	 * 500处理
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/error/500.htm", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView error500(HttpServletRequest req,
			HttpServletResponse resp, ModelMap model) {
		HttpSession session = req.getSession();
		EnterpriseMember user = (EnterpriseMember) session
				.getAttribute(CommonConstant.SESSION_ATTR_NAME_CURRENT_USER);
		String msg = (String) session.getAttribute(CommonConstant.ERROR);
		RestResponse restP = new RestResponse();
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("member", user);
		restP.setData(data);
		model.put("response", user);
		model.put("error", msg);
		restP.setLogoutUrl(CommonUtils.getUcLogoutUrl(req, resp, ""));
		return new ModelAndView("common/error/500", "response", restP);
	}

	/**
	 * 进入公司ID查询错误页面
	 * 
	 * @param model
	 * @param request
	 * @return
	 */

	@RequestMapping(value = "/my/noCorpError.htm", method = {
			RequestMethod.POST, RequestMethod.GET })
	public ModelAndView noCorpError(HttpServletRequest req,
			HttpServletResponse resp) throws ServiceException {
		String userName = String.valueOf(req
				.getAttribute(CommonConstant.SESSION_ATTR_NAME_CURRENT_USER));
		req.setAttribute("message", "对不起：[" + userName + "] 不是商户，无法进入企业钱包");
		req.setAttribute("errorType", "1");
		RestResponse restP = new RestResponse();
		Map<String, Object> data = new HashMap<String, Object>();
		EnterpriseMember user = new EnterpriseMember();
		user.setMemberName(userName);
		data.put("member", user);
		restP.setData(data);
		restP.setLogoutUrl(CommonUtils.getUcLogoutUrl(req, resp, ""));
		return new ModelAndView("/common/exception/loginError", "response",
				restP);
	}

	/**
	 * 进入错误页面
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/my/toPersonWallet.htm", method = {
			RequestMethod.POST, RequestMethod.GET })
	public ModelAndView toPersonWallet(HttpServletRequest req,
			HttpServletResponse resp) {
		HttpSession session = req.getSession();
		EnterpriseMember user = (EnterpriseMember) session
				.getAttribute(CommonConstant.SESSION_ATTR_NAME_CURRENT_USER);
		RestResponse restP = new RestResponse();
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("member", user);
		restP.setData(data);
		restP.setLogoutUrl(CommonUtils.getUcLogoutUrl(req, resp, ""));
		return new ModelAndView("toPersonWallet", "response", restP);
	}
}
