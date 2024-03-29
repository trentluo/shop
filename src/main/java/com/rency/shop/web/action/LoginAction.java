package com.rency.shop.web.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.rency.common.utils.domain.SYSDICT;
import org.rency.common.utils.exception.CoreException;
import org.rency.common.utils.tool.DateUtils;
import org.rency.common.utils.tool.KaptchaUtils;
import org.rency.common.utils.tool.UUIDUtils;
import org.rency.dal.sequence.service.SequenceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.rency.shop.web.entity.RespBody;
import com.rency.shop.web.entity.User;
import com.rency.shop.web.enums.UserStatus;
import com.rency.shop.web.form.LoginForm;
import com.rency.shop.web.form.RegisterForm;
import com.rency.shop.web.service.UserService;
import com.rency.shop.web.tools.Const;

@Controller
@RequestMapping("")
public class LoginAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(LoginAction.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SequenceRepository sequenceRepository;
	
	/**
	 * 进入登录页面
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/loginInput.htm")
	public ModelAndView loginInput(HttpServletRequest request,HttpServletResponse response) throws Exception{
		logger.info("请求进入登录页面");
        return view(Const.VIEW_SUFFIX_LOGIN+"login");
	}
	
	/**
	 * 登录
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/login.htm")
	@ResponseBody
	public RespBody login(HttpServletRequest request,HttpServletResponse response,@Validated LoginForm form) throws Exception{
		logger.info(form.getManageUser()+" login at "+DateUtils.getNowDateTime());
		
		if(!KaptchaUtils.validateRandCode(request, form.getCaptchaValue())){
			super.failed("验证码错误");
			respData.put("email", form.getManageUser());
			return respBody;
		}
		
		User user = userService.queryByEmail(form.getManageUser());
		if(user == null){
			super.failed("用户不存在");
			respData.put("email", form.getManageUser());
			return respBody;
		}
		
		if(!form.getPasswd().equals(user.getPasswd())){
			super.failed("密码不正确");
			respData.put("email", form.getManageUser());
			return respBody;
		}
		
		//设置登录用户
		setUser(request,user);
		respBody.setCallback(request.getContextPath() + "/home.htm");
        return respBody;
	}
	
	@RequestMapping("/regInput.htm")
	public ModelAndView regInput(HttpServletRequest request,HttpServletResponse response) throws Exception{
		logger.info("请求进入注册页面");
		String fromUrl = request.getParameter(SYSDICT.URL_PARAM_CALLBACK_KEY);
		respBody.setCallback(fromUrl);
		respData.put("userType", 1);
        return view(Const.VIEW_SUFFIX_LOGIN+"register");
	}
	
	@RequestMapping("/reg.htm")
	public ModelAndView register(HttpServletRequest request,HttpServletResponse response,@Validated RegisterForm form) throws Exception{
		try{
			logger.info("注册会员:"+form.toString());
			if(!KaptchaUtils.validateRandCode(request, form.getCaptchaValue())){
				super.failed("验证码错误");
				return view(Const.VIEW_SUFFIX_LOGIN+"register");
			}
			User origUser = userService.queryByEmail(form.getManageUser());
			if(origUser != null){
				super.failed("账户已存在");
				return view(Const.VIEW_SUFFIX_LOGIN+"register");
			}
			String uuid = UUIDUtils.genetator() + sequenceRepository.next(Const.SEQ_NAME_USER);
			User user = new User();
			user.setUuid(uuid);
			user.setEmail(form.getManageUser());
			user.setCreateDate(new Date());
			user.setUserStatus(UserStatus.INIT);
			user.setUserType(form.getUserType());
			boolean isCreate = userService.save(user);
			if(isCreate){
				super.success();
				return view(Const.VIEW_SUFFIX_MAIN+"home");
			}else{
				super.failed("注册失败");
				return view(Const.VIEW_SUFFIX_LOGIN+"register");
			}
		}catch(CoreException e){
			logger.error("注册会员时发生异常.{}",form.toString(),e);
			return view(Const.VIEW_SUFFIX_LOGIN+"register");
		}
	}
	
	@RequestMapping("/regActive.htm")
	public ModelAndView registerActive(HttpServletRequest request,HttpServletResponse response,@Validated RegisterForm form) throws Exception{
		logger.info("会员激活:"+form.toString());
		User user = userService.queryByEmail(form.getManageUser());
		if(user == null){
			
		}
        return view(Const.VIEW_SUFFIX_MAIN+"home");
	}
	
	@RequestMapping("/logout.htm")
	public ModelAndView logout(HttpServletRequest request,HttpServletResponse response) throws Exception{
		logger.info("会员退出登录");
		String fromUrl = request.getParameter(SYSDICT.URL_PARAM_CALLBACK_KEY);
		respBody.setCallback(fromUrl);
        return view(Const.VIEW_SUFFIX_MAIN+"home");
	}
	
}
