package com.poshi.cn.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.alibaba.fastjson.JSON;

public class CommonUtils {

	public static <T> T getBean(HttpServletRequest request, Class<T> clazz){
		 T t = null;
		try {
			  t =(T) JSON.parseObject(IOUtils.toString(request.getInputStream()), clazz.getClass());
		} catch (Exception e1) {
		}
		return t;
	}
	
	public static void returnJson(HttpServletResponse response, String json){
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		try {
		    out = response.getWriter();
		    out.write(json);
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    if (out != null) {
		        out.close();
		    }
		}
	}
	
	public static void returnJson(HttpServletResponse response, String message, boolean flag){
		if(flag){
			returnJson(response, JSON.toJSONString(new Response(message)));
		}else{
			returnJson(response, JSON.toJSONString(new Response(Response.Status.error,message)));
		}
	}
	
}
