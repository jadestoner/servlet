package com.login.service.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.service.StatementHandle;
import com.login.sql.MethodOfSql;
import com.login.utils.DbUtils;

@WebServlet("/loginHandle")
public class LoginHandle extends HttpServlet implements StatementHandle{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		Map result = null ;
		try {
			result = DbUtils.getDbUtils(request).executePreSql(MethodOfSql.LOGIN.getSql(), Arrays.asList(name,pass),this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int total = (int) result.get("total");
		String msg = "";
		if(total>0) msg="登录成功！";
		else msg="为查询到相关顾客！";
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		String jsonStr = "{\"msg\":\""+msg+"\"}";
		PrintWriter out = null;
		try {
		    out = response.getWriter();
		    out.write(jsonStr);
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    if (out != null) {
		        out.close();
		    }
		}
	}
	
	public Map login(ResultSet rs) throws SQLException{
		Map result = new HashMap();
		while(rs.next()){
			result.put("total", rs.getInt(1));
		}
		return result;
	}

	@Override
	public Map handle(ResultSet rs, MethodOfSql ms){
		String name = ms.getMethod();
		try {
			Method method = this.getClass().getMethod(name,ResultSet.class);
			return (Map)method.invoke(this, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}