package com.rency.shop.web.action;

import java.io.IOException;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.rency.common.utils.domain.SYSDICT;
import org.rency.common.utils.enums.Errors;
import org.rency.common.utils.exception.CoreException;
import org.rency.common.utils.exception.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

import com.rency.shop.web.entity.RespBody;
import com.rency.shop.web.entity.User;
import com.rency.shop.web.tools.Const;

/**
 * 
 * @author rencaiyu
 *
 */
public class BaseAction implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected static final Logger logger = LoggerFactory.getLogger(BaseAction.class);
    
    protected final RespBody respBody = new RespBody();
    protected final Map<String, Object> respData = new HashMap<String, Object>();
    
    public BaseAction(){
    	respBody.setSuccess(true);
    	respBody.setMessage("");
    	respBody.setData(respData);
    	respBody.setCallback("");
    }
    
    protected ModelAndView view(String url){
    	ModelAndView mv = new ModelAndView(url,"resp",respBody);
    	return mv;
    }
    
    /**
     * 返回成功
    * @Title: success 
    * @Description: TODO
    * @Date: 2015年6月4日 下午9:57:23
     */
    protected void success(){
    	respBody.setSuccess(true);
    }
    
    /**
     * 返回失败
    * @Title: failed 
    * @Description: TODO
    * @Date: 2015年6月4日 下午9:58:01
    * @param errorMessage
     */
    protected void failed(String errorMessage){
    	respBody.setSuccess(false);
    	respBody.setMessage(errorMessage);
    }
    
    /**
     * 获取当前登录用户
     * @param request
     * @return
     * @throws UserException
     */
    protected User getUser(HttpServletRequest request) throws UserException {
    	User user = (User) request.getSession().getAttribute(Const.SESSION_USER_KEY);
    	if(user == null){
    		logger.error("用户不存在");
    		throw new UserException(Errors.USER_NOT_EXISTS);
    	}
		return user;
	}
    
    /**
     * 设置当前登录用户
     * @param request
     * @return
     * @throws UserException
     */
    protected void setUser(HttpServletRequest request,User user) throws UserException {
    	request.getSession().setAttribute(Const.SESSION_USER_KEY,user);
	}
    
    /**
     * 转发请求
     * @param request
     * @param response
     * @param toUrl 待转发地址
     * @param fromUrl 请求来源地址
     * @throws CoreException
     */
    public static void forward(HttpServletRequest request,HttpServletResponse response,String toUrl,String fromUrl) throws CoreException{
    	logger.info("转发请求至:"+toUrl);
    	String url = "";
        try {
        	if(StringUtils.isNotBlank(fromUrl)){
        		url = toUrl+SYSDICT.URL_PARAM_CALLBACK_KEY+URLEncoder.encode(fromUrl,SYSDICT.CHARSET);
        	}
        	RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			logger.error("转发请求异常：地址{},{}",url,e);
			throw new CoreException(e);
		} catch (IOException e) {
			logger.error("转发请求异常：地址{},{}",url,e);
			throw new CoreException(e);
		}
    }
}
