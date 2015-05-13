package com.rency.shop.web.entity;

import java.io.Serializable;

public class Environment implements Serializable {

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
     * 服务器IP
     */
    private String serverIp;
    /**
     * 服务器名称
     */
    private String serverName;
    
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
    
}
