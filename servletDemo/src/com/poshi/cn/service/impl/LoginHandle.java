package com.poshi.cn.service.impl;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.poshi.cn.bean.User;
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
		String handle = request.getParameter("handle");
		if("login".equals(handle)){
			doLogin();
		}else if("register".equals(handle)){
			doRegister();
		}
	}
	
	private void doRegister(){
		String name = request.getParameter("username");
		String pass = request.getParameter("password");
		Integer result = null ;
		try {
			Map res = DbUtils.getDbUtils(request).executePreQuerySql(MethodOfSql.USERNAME_EXIST.getSql(), Arrays.asList(name),this);
			int total = Integer.valueOf(String.valueOf(res.get("total")));
			if(total > 0){
				CommonUtils.returnJson(response, "用户已存在！", false);
				return;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			result = DbUtils.getDbUtils(request).executePreUpdateSql(MethodOfSql.REGISTER.getSql(), Arrays.asList(name,pass));
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
		User user = CommonUtils.getBean(request, User.class);
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		Map result = null ;
		try {
			result = DbUtils.getDbUtils(request).executePreQuerySql(MethodOfSql.LOGIN.getSql(), Arrays.asList(name,pass),this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		
		int total = Integer.valueOf(String.valueOf(result.get("total")));
		Response res;
		if(total>0){
			res = new Response("登录成功！");
		}else {
			res = new Response(Response.Status.error,"未查询到相关顾客！");
		}	
		RequestDispatcher dispatcher =  request.getRequestDispatcher("/WEB-INF/views/index.jsp");
		dispatcher.forward(request, response);
	}
	
	public Map login(ResultSet rs) throws Exception{
		List<Map<String, Object>> list = DbUtils.resultSetToList(rs);
		if(list == null || list.size() == 0){
			return null;
		}
		return list.get(0);
	}		
}
