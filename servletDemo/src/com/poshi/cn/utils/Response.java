package com.poshi.cn.utils;

import java.io.Serializable;

public class Response<T> implements Serializable{

	private static final long serialVersionUID = 1L;

	private Status status;
	
	private String message;
	
	private T value;
	
	public Response(){
		this.status = Status.success;
	}
	
	public Response(String message){
		this();
		this.message = message;
	}
	
	public Response(Status status, String message){
		this.status = status;
		this.message = message;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	private enum Status{
		success,error
	}
}
