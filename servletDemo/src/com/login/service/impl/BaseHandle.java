package com.login.service.impl;

import java.sql.ResultSet;
import java.util.Map;

import com.login.service.StatementHandle;
import com.login.sql.MethodOfSql;

public abstract class BaseHandle implements StatementHandle {
	
	public abstract Map handle(ResultSet rs, MethodOfSql ms);
	
}
