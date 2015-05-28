package com.rency.shop.web.entity;

import java.io.Serializable;
import java.util.Date;

import com.rency.shop.web.enums.UserStatus;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1979856132863673585L;
	
	private String uuid;
	private String username;
	private String passwd;
	private String email;
	private String mobile;
	private int userType;
	private UserStatus userStatus;
	private Date currLogin;
	private Date lastLogin;
	private Date createDate;
	private Date updateDate;
	private String extention;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public UserStatus getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
	}

	public Date getCurrLogin() {
		return currLogin;
	}

	public void setCurrLogin(Date currLogin) {
		this.currLogin = currLogin;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getExtention() {
		return extention;
	}

	public void setExtention(String extention) {
		this.extention = extention;
	}
	
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		builder.append("uuid:"+uuid).append(",");
		builder.append("username:"+username).append(",");
		builder.append("email:"+email).append(",");
		builder.append("mobile:"+mobile).append(",");
		builder.append("userType:"+userType).append(",");
		builder.append("userStatus:"+userStatus.getValue()).append(",");
		builder.append("currLogin:"+currLogin).append(",");
		builder.append("lastLogin:"+lastLogin).append(",");
		builder.append("createDate:"+createDate).append(",");
		builder.append("updateDate:"+updateDate).append(",");
		builder.append("extention:"+extention).append(",");
		builder.append("}");
		return builder.toString();
	}
}