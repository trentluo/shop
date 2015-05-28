package com.rency.shop.web.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 返回
* @ClassName: RespBody 
* @Description: TODO
* @Author user_rcy@163.com
* @Date 2015年5月24日 下午12:31:50 
*
 */
public class RespBody implements Serializable {
	
	/** 
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = 1L;
	
	private String callback;
	private boolean success;
	private String message;
	private Map<String, Object> data = new HashMap<String, Object>();
	public String getCallback() {
		return callback;
	}
	public void setCallback(String callback) {
		this.callback = callback;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Map<String, Object> getData() {
		return data;
	}
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
}
