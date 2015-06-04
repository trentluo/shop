package com.rency.shop.web.enums;

public enum UserStatus {
	INIT(1,"创建"),
	ACTIVED(2,"激活"),
	LOCK(3,"锁定"),
	;
	
	private int code;
	private String value;
	
	UserStatus(int code,String value){
		this.code = code;
		this.value = value;
	}
	
	public int getCode(){
		return this.code;
	}
	
	public String getValue(){
		return this.value;
	}
	
	public static UserStatus getByCode(int code) {
        for (UserStatus value : UserStatus.values()) {
            if (value.code == code) {
                return value;
            }
        }
        return null;
    }
}
