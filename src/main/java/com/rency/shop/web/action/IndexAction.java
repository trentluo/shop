package com.rency.shop.web.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rency.shop.web.entity.User;
import com.rency.shop.web.tools.Const;

@Controller
@RequestMapping("")
public class IndexAction extends BaseAction{
	
	/** 
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = 254228777507409441L;
	private static final Logger logger = LoggerFactory.getLogger(IndexAction.class);

	@RequestMapping("/home.htm")
	public ModelAndView home(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		logger.info("into index/home page");
		User user = super.getUser(req);
		Map<String, Object> respMap = new HashMap<String, Object>();
		respMap.put("username", user.getUsername());
		ModelAndView mv = new ModelAndView(Const.VIEW_SUFFIX_MAIN+"index","resp",respMap);
		return mv;
	}
	
}
