package com.login.service;

import java.sql.ResultSet;
import java.util.Map;

import com.login.sql.MethodOfSql;


public interface StatementHandle {

	Map handle(ResultSet rs, MethodOfSql ms);
}
