package com.beacon.wechat.app.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class AppUtils {
	public static <T> T spring(Class<T> cls){
        return ContextLoader.getCurrentWebApplicationContext().getBean(cls);
    }
    public static HttpServletRequest request(){
        return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    }
    public static HttpServletResponse response(){
        return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
    }
}
