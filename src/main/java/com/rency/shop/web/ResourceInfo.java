package com.rency.shop.web;

import java.util.HashMap;
import java.util.Map;


/**
 * <p>资源枚举</p>
 * @author eric
 * @version $Id: FunctionEnum.java, v 0.1 2013-7-16 下午1:59:23  Exp $
 */
public enum ResourceInfo {
    INDEX("首页", "/index", null),

    HOME("主页", "/home", null),

    LONGIN("登录页面", "/login", null),

    ERROR("错误页面", "/common/exception/error", null),

    ;

    /** 资源名称 */
    private final String                     name;
    /** 请求地址 */
    private final String                     url;
    /** 父资源 */
    private final ResourceInfo               parent;

    /** 资源MAP，供查找提高效率 */
    private static Map<String, ResourceInfo> resourceMap = new HashMap<String, ResourceInfo>();

    /**
     * 初始化
     */
    static {
        for (ResourceInfo resource : ResourceInfo.values()) {
            resourceMap.put(resource.name(), resource);
        }
    }

    /**
     * 构造
     * @param name
     * @param type
     * @param method
     * @param url
     * @param parent
     */
    ResourceInfo(String name, String url, ResourceInfo parent) {
        this.name = name;
        this.url = url;
        this.parent = parent;
    }

    /**
     * 根据CODE获取枚举
     * @param code
     * @return
     */
    public static ResourceInfo getByCode(String code) {
        return resourceMap.get(code);
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public ResourceInfo getParent() {
        return parent;
    }

}
