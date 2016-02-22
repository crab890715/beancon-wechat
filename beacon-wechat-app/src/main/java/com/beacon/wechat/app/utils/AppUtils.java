package com.beacon.wechat.app.utils;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AppUtils {
	private static Logger log = Logger.getLogger(AppUtils.class);
	private static ObjectMapper mapper=new ObjectMapper();
	public static <T> T spring(Class<T> cls){
        return ContextLoader.getCurrentWebApplicationContext().getBean(cls);
    }
    public static HttpServletRequest request(){
        return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    }
    public static HttpServletResponse response(){
        return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
    }
    
    public static String url(){
    	HttpServletRequest request = request();
        return request.getRequestURL().toString()+"?"+request.getQueryString();
    }
    public static <T> T fromJson(String json,TypeReference<T> tr) {
        try {
			return mapper.readValue(json,tr);
		} catch (JsonParseException e) {
			log.error(e);
		} catch (JsonMappingException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		}
        return null;
    }
    public static String toJson(Object bean){
        try {
			return mapper.writeValueAsString(bean);
		} catch (JsonProcessingException e) {
			log.error(e);
		}
        return null;
    }
    /**
     * 设置COOKIE
     */
    public static void setCookie(String name,String value,int maxAge){
        Cookie cookie=new Cookie(name,value);
        cookie.setMaxAge(maxAge);
        cookie.setPath("/");
        response().addCookie(cookie);
    }
    /**
     * 设置COOKIE
     */
    public static String getCookie(String name){
    	Cookie[] cookies=request().getCookies();
    	if(cookies!=null){
            for(Cookie ck : cookies){
                if(name.equalsIgnoreCase(ck.getName())){
                    return ck.getValue();
                }
            }
    	}
        return null;
    }
    public static void deleteCookie(String name){ setCookie(name,"",0);}
}
