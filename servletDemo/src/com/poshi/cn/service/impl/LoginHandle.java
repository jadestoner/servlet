package com.poshi.cn.service.impl;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.poshi.cn.service.StatementHandle;
import com.poshi.cn.sql.MethodOfSql;
import com.poshi.cn.utils.CommonUtils;
import com.poshi.cn.utils.DbUtils;
import com.poshi.cn.utils.Response;

@WebServlet("/loginHandle")
public class LoginHandle extends HttpServlet implements StatementHandle{
	
	private HttpServletRequest request;
	
	private HttpServletResponse response;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.request = request;
		this.response = response;
		String method = request.getParameter("method");
		if("login".equals(method)){
			doLogin();
		}else if("register".equals(method)){
			doRegister();
		}
	}
	
	private void doRegister(){
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		Integer result = null ;
		try {
			result = DbUtils.getDbUtils(request).executePreUpdateSql(MethodOfSql.REGISTER.getSql(), Arrays.asList(name,pass),this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Response res;
		if(result>0){
			res = new Response("注册成功！");
		}else {
			res = new Response(Response.Status.error,"注册失败！");
		}	
		CommonUtils.returnJson(response, JSON.toJSONString(res));
	}
	
	private void doLogin() throws ServletException, IOException{
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		Map result = null ;
		try {
			result = DbUtils.getDbUtils(request).executePreQuerySql(MethodOfSql.LOGIN.getSql(), Arrays.asList(name,pass),this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int total = Integer.valueOf(String.valueOf(result.get("total")));
		String msg = "";
		Response res;
		if(total>0){
			res = new Response("登录成功！");
		}else {
			res = new Response(Response.Status.error,"未查询到相关顾客！");
		}	
		CommonUtils.returnJson(response, JSON.toJSONString(res));
	}
	
	public Map login(ResultSet rs) throws Exception{
		List<Map<String, Object>> list = DbUtils.resultSetToList(rs);
		if(list == null || list.size() == 0){
			return null;
		}
		return list.get(0);
	}
	
	public Map register(ResultSet rs) throws Exception{
		List<Map<String, Object>> list = DbUtils.resultSetToList(rs);
		if(list == null || list.size() == 0){
			return null;
		}
		return list.get(0);
	}
	
}
