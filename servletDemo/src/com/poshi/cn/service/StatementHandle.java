package com.poshi.cn.service;

import java.sql.ResultSet;
import java.util.Map;

import com.poshi.cn.sql.MethodOfSql;


public interface StatementHandle {

	Map handle(ResultSet rs, MethodOfSql ms);
}
