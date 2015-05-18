package com.rency.shop.web;

import java.io.Serializable;

import org.springframework.beans.factory.InitializingBean;

public class WebDynamicResource implements InitializingBean,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3750363672075249310L;
	
	/**
	 * 系统版本号
	 */
	private String version;
	
	private String staticAddress;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getStaticAddress() {
		return staticAddress;
	}

	public void setStaticAddress(String staticAddress) {
		this.staticAddress = staticAddress;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		
	}

}
