package com.login.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.service.StatementHandle;
import com.login.sql.MethodOfSql;
import com.mysql.jdbc.ResultSetMetaData;

/**
 * Servlet implementation class DbUtils
 */
public class DbUtils extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static DbUtils dbUtils;
	
	private String driver;
	private  String url ;
	private String username ;
	private String password ;
	private HttpServletRequest request;
	
	public static DbUtils getDbUtils(HttpServletRequest request){
		if(dbUtils == null){
			return dbUtils = new DbUtils(request);
		}
		return dbUtils;
	}
	
	private Connection getConnection(){
		// 加载驱动程序
        try {
			Class.forName(driver);
			return DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Map executeSql( String sql, StatementHandle callBack) throws Exception{
		Connection conn = getConnection();
		Statement statement = conn.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		Map result = callBack.handle(rs,MethodOfSql.valueOf(sql));
		rs.close();
        conn.close();
        return result;
	}
	
	public Map executePreSql( String sql, List<Object> list, StatementHandle callBack) throws Exception{
		if(list != null && list.size() != StringUtils.appearNumber(sql, "?")){
			throw new Exception(String.format("参数数量错误！参数size=%d,sql=%s",list.size(),sql));
		}
		Connection conn = getConnection();
		PreparedStatement  statement = conn.prepareStatement(sql);
		Integer index = 1;
		for(Object obj : list){
			statement.setObject(index, obj);
			index++;
		}
		ResultSet rs = statement.executeQuery();
		Map result = callBack.handle(rs,MethodOfSql.getBySql(sql));
		rs.close(); conn.close();
        return result;
	}
	
     private  DbUtils(HttpServletRequest request) {
        InputStream in = request.getServletContext().getResourceAsStream("/db.properties");
        Properties prop = new Properties();
         try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
         driver = prop.getProperty("driver");
         url = prop.getProperty("url");
         username = prop.getProperty("username");
         password = prop.getProperty("password");
    }

     public static Map<String, String> getResultMap(ResultSet rs) throws SQLException {  
         Map<String, String> hm = new HashMap<String, String>();  
         ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();  
         int count = rsmd.getColumnCount();  
         for (int i = 1; i <= count; i++) {  
             String key = rsmd.getColumnLabel(i);  
             String value = rs.getString(i);  
             hm.put(key, value);  
         }  
         return hm;  
     }  
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	public static void main(String[] args) {
		
	}

}
