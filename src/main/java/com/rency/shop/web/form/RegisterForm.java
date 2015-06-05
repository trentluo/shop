package com.rency.shop.web.form;

import java.io.Serializable;

public class RegisterForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//email
	private String manageUser;
	private String username;
	private String captchaValue;
	private String passwd;
	private String payPasswd;
	private String mobile;
	private int userType;
	private int userStatus;
		
	public String getManageUser() {
		return manageUser;
	}
	public void setManageUser(String manageUser) {
		this.manageUser = manageUser;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCaptchaValue() {
		return captchaValue;
	}
	public void setCaptchaValue(String captchaValue) {
		this.captchaValue = captchaValue;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getPayPasswd() {
		return payPasswd;
	}
	public void setPayPasswd(String payPasswd) {
		this.payPasswd = payPasswd;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public int getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}
	
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		builder.append("managerUser:").append(manageUser).append(", ");
		builder.append("username:").append(username).append(", ");
		builder.append("captchaValue:").append(captchaValue).append(", ");
		builder.append("mobile:").append(mobile).append(", ");
		builder.append("userType:").append(userType).append(", ");
		builder.append("userStatus:").append(userStatus).append(", ");
		builder.append("}");
		return builder.toString();
	}
}
