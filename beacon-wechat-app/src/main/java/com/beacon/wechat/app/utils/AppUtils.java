package com.beacon.wechat.app.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.beacon.wechat.app.controller.WechatController;
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
}
