package com.poshi.cn.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import com.mysql.jdbc.ResultSetMetaData;
import com.poshi.cn.service.StatementHandle;
import com.poshi.cn.sql.MethodOfSql;

/**
 * Servlet implementation class DbUtils
 */
public class DbUtils{
	private static final long serialVersionUID = 1L;
       
	private static DbUtils dbUtils;
	
	private String driver;
	private  String url ;
	private String username ;
	private String password ;
	
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
	
	public Map executePreQuerySql( String sql, List<Object> list, StatementHandle callBack) throws Exception{
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
		statement.close(); conn.close();
        return result;
	}
	
	public Integer executePreUpdateSql( String sql, List<Object> list, StatementHandle callBack) throws Exception{
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
		return statement.executeUpdate();
	}
	
     private  DbUtils(HttpServletRequest request) {
        InputStream in = request.getServletContext().getResourceAsStream("/WEB-INF/db.properties");
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

     public static List<Map<String,Object>> resultSetToList(ResultSet rs) throws SQLException{
    	 List<Map<String,Object>> results = new ArrayList<Map<String,Object>>();
    	 ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();  
    	 int colCount = rsmd.getColumnCount();
    	 List<String> colNameList = new ArrayList<String>();
    	 for(int i=0;i<colCount;i++){
    		 colNameList.add(rsmd.getColumnName(i+1));
    	 } 
    	 while(rs.next()){
	    	 for(int i=0;i<colCount;i++){
		    	 Map map=new HashMap<String, Object>();
		    	 String key=colNameList.get(i);
		    	 Object value=rs.getString(colNameList.get(i));
		    	 map.put(key, value);
		    	 results.add(map);
	    	 }
    	 }
    	 return results;
     } 
}
