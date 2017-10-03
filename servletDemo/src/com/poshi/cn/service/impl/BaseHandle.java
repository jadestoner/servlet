package com.poshi.cn.service.impl;

import java.sql.ResultSet;
import java.util.Map;

import com.poshi.cn.service.StatementHandle;
import com.poshi.cn.sql.MethodOfSql;

public abstract class BaseHandle implements StatementHandle {
	
	public abstract Map handle(ResultSet rs, MethodOfSql ms);
	
}
