package com.rency.shop.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rency.shop.web.entity.RespBody;
import com.rency.shop.web.entity.User;
import com.rency.shop.web.form.RegisterForm;
import com.rency.shop.web.service.UserService;

@Controller
@RequestMapping("/user")
public class UserAction extends BaseAction{
	
	private static final Logger logger = LoggerFactory.getLogger(UserAction.class);
	
	@Autowired
	private UserService userService;
	
	/**
	 * 用户注册email验证
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/valid.htm")
	@ResponseBody
	public RespBody query(HttpServletRequest request,HttpServletResponse response,@Validated RegisterForm form) throws Exception{
		logger.info("用户查询."+form.toString());
		User u = userService.queryByEmail(form.getManageUser());
		if(u == null){
			respBody.setSuccess(true);
		}else{
			respBody.setSuccess(false);
			respBody.setMessage("用户已存在");
		}
        return respBody;
	}
	
}
