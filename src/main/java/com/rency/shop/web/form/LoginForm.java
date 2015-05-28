package com.rency.shop.web.form;

import java.io.Serializable;

/**
 * 登录表单
 * @author rencaiyu
 *
 */
public class LoginForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String manageUser;
	private String passwd;
	private String captchaValue;
	public String getManageUser() {
		return manageUser;
	}
	public void setManageUser(String manageUser) {
		this.manageUser = manageUser;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getCaptchaValue() {
		return captchaValue;
	}
	public void setCaptchaValue(String captchaValue) {
		this.captchaValue = captchaValue;
	}

}
