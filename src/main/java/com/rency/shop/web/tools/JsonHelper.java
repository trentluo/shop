package com.rency.shop.web.tools;

import org.codehaus.jackson.map.ObjectMapper;

public class JsonHelper {
	
	private static ObjectMapper objectMapper;
	
	/**
	 * 对象转json字符串
	 * @param obj
	 * @return
	 */
	public static String toJson(Object obj){
		try{
			return objectMapper.writeValueAsString(obj);
		} catch (Exception e) {
			throw new IllegalArgumentException("转换为JSON字符串时异常", e);
		}
	}
	
	/**
	 * json字符串转对象
	 * @param json
	 * @param clazz
	 * @return
	 */
	 public static <T> T parse(String json, Class<T> clazz){
		try{
			 return objectMapper.readValue(json, clazz);
		}catch (Exception e) {
			throw new IllegalArgumentException("由JSON字符串时转换为对象时异常", e);
		}
	}
	
}
