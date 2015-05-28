package com.rency.shop.web;



/**
 * <p>资源枚举</p>
 * @author eric
 * @version $Id: FunctionEnum.java, v 0.1 2013-7-16 下午1:59:23  Exp $
 */
public enum URLS {
    INDEX("首页", "/index"),

    HOME("主页", "/home.htm"),

    LONGIN("登录页面", "/loginInput.htm"),

    ERROR("错误页面", "/common/exception/error"),
    
    LOGOUT("注销页面", "/logout.htm"),

    ;

    /** 资源名称 */
    private final String                     name;
    /** 请求地址 */
    private final String                     url;

    /**
     * 构造
     * @param name
     * @param url
     */
    URLS(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

}
