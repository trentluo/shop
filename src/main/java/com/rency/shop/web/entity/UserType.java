package com.rency.shop.web.entity;

import java.io.Serializable;
import java.util.Date;

public class UserType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int typeId;
	private String typeName;
	private Date createDate;
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
