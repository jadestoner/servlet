package com.poshi.cn.service;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.util.Map;

import com.poshi.cn.sql.MethodOfSql;


public interface StatementHandle {

	default Map handle(ResultSet rs, MethodOfSql ms){
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
