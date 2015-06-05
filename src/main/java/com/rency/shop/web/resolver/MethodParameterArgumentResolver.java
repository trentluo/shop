package com.rency.shop.web.resolver;

import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.rency.common.utils.tool.BrowserUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;

import com.rency.shop.web.entity.Enviroment;
import com.rency.shop.web.tools.JsonHelper;

/**
 * 请求方法参数解析
 * @author rencaiyu
 *
 */
public class MethodParameterArgumentResolver implements WebArgumentResolver {

	@Override
	public Object resolveArgument(MethodParameter methodParameter,NativeWebRequest webRequest) throws Exception {
		if(methodParameter.getParameterType().equals(Enviroment.class)){
			return resolver(webRequest.getNativeRequest(HttpServletRequest.class));
		}
		return UNRESOLVED;
	}
	
	private Enviroment resolver(HttpServletRequest request){
		Enviroment env = new Enviroment();
		String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            HashMap<String,Object> cookiesMap = new HashMap<String,Object>(cookies.length);
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName() != null) {
                    cookiesMap.put(cookies[i].getName(), cookies[i].getValue());
                }
            }
            env.setCookie(JsonHelper.toJson(cookiesMap));
        }
		env.setClientId(request.getSession().getId());
		env.setClientIp(ip);
		env.setClientMac("");
		env.setBrowser(BrowserUtils.checkBrowse(request));
		env.setBrowserVersion("");
		env.setReferUrl(request.getHeader("Referer"));
		env.setServerIp(request.getRemoteAddr());
		env.setServerName(request.getServerName());
		env.setReqDate(new Date());
		env.setUser("");
		return env;
	}

}
