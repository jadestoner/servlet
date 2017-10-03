package com.poshi.cn.sql;

public enum MethodOfSql {

	LOGIN("select count(1) from user where username=? and password =?","login");
	
	
	
	private String sql;
	private String method;
	
	public static MethodOfSql getBySql(String sql){
		if(sql == null){
			return null;
		}
		for(MethodOfSql ms : MethodOfSql.values()){
			if(sql.equals(ms.getSql())){
				return ms;
			}
		}
		return null;
	}
	
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	private MethodOfSql(String sql, String method) {
		this.sql = sql;
		this.method = method;
	}
}
