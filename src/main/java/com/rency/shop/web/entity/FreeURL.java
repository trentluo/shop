package com.rency.shop.web.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 免登录URL
 * @author rencaiyu
 *
 */
public class FreeURL implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4469369996517617253L;
	
	private List<String> freeUrls = new ArrayList<String>();

	public List<String> getFreeUrls() {
		return freeUrls;
	}

	public void setFreeUrls(List<String> freeUrls) {
		this.freeUrls = freeUrls;
	}

}
