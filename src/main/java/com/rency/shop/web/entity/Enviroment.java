package com.rency.shop.web.entity;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Enviroment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2394025036568636452L;
	
	/**
	 * 客户端IP
	 */
    private String clientIp;
    /**
     * 客户端MAC
     */
    private String clientMac;
    /**
     * 客户端的唯一标识
     */
    private String clientId;
    /**
     * 浏览器类型
     */
    private String browser;
    /**
     * 浏览器版本号
     */
	private String browserVersion;
	
	/**
	 * 客户端cookie
	 */
	private String cookie;
    /**
     * 服务器IP
     */
    private String serverIp;
    /**
     * 服务器名称
     */
    private String serverName;
    
    /**
     * 请求来源
     */
    private String referUrl;
    
    /**
     * 请求用户
     */
    private String user;
    
    /**
     * 请求时间
     */
    private Date reqDate;
    
	public String getClientIp() {
		return clientIp;
	}
	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}
	public String getClientMac() {
		return clientMac;
	}
	public void setClientMac(String clientMac) {
		this.clientMac = clientMac;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	public String getBrowserVersion() {
		return browserVersion;
	}
	public void setBrowserVersion(String browserVersion) {
		this.browserVersion = browserVersion;
	}
	public String getCookie() {
		return cookie;
	}
	public void setCookie(String cookie) {
		this.cookie = cookie;
	}
	public String getServerIp() {
		return serverIp;
	}
	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	
	public String getReferUrl() {
		return referUrl;
	}
	public void setReferUrl(String referUrl) {
		this.referUrl = referUrl;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Date getReqDate() {
		return reqDate;
	}
	public void setReqDate(Date reqDate) {
		this.reqDate = reqDate;
	}
	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
    
}
