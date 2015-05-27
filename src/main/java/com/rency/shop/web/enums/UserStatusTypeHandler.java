package com.rency.shop.web.enums;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

/**
 * 自定义UserStatus转换类
 * @author rencaiyu
 *
 */
public class UserStatusTypeHandler extends BaseTypeHandler<UserStatus>{
	
	private Class<UserStatus> type;
	private final UserStatus[] enums;
	
	public UserStatusTypeHandler(Class<UserStatus> type) throws IllegalAccessException{
		if(type == null){
			throw new IllegalAccessException("Type argument cannot be null");
		}
		this.type = type;
		this.enums = type.getEnumConstants();
		if(this.enums == null){
			throw new IllegalArgumentException(type.getSimpleName()+" does not represent an enum type.");
		}
	}

	@Override
	public UserStatus getNullableResult(ResultSet rs, String columnName)throws SQLException {
		// 根据数据库存储类型决定获取类型，本例子中数据库中存放INT类型
		int i = rs.getInt(columnName);
		if(rs.wasNull()){
			return null;
		}else{
			return locateUserStatus(i);
		}
	}

	@Override
	public UserStatus getNullableResult(ResultSet rs, int columnIndex)throws SQLException {
		// 根据数据库存储类型决定获取类型，本例子中数据库中存放INT类型
		int i = rs.getInt(columnIndex);
		if(rs.wasNull()){
			return null;
		}else{
			return locateUserStatus(i);
		}
	}

	@Override
	public UserStatus getNullableResult(CallableStatement cs, int columnIndex)throws SQLException {
		// 根据数据库存储类型决定获取类型，本例子中数据库中存放INT类型
		int i = cs.getInt(columnIndex);
		if(cs.wasNull()){
			return null;
		}else{
			return locateUserStatus(i);
		}
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int columnIndex,UserStatus enums, JdbcType jdbcType) throws SQLException {
		ps.setInt(columnIndex, enums.getCode());
		
	}
	
	private UserStatus locateUserStatus(int code){
		for (UserStatus value : UserStatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
		throw new IllegalArgumentException("未知的枚举类型：" + code + ",请核对" + type.getSimpleName());
	}

}
