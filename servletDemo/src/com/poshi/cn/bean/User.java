
package com.poshi.cn.bean;

import java.util.Date;

public class User {

	private Integer userId;
	
	private String userName;
	
	private Integer sex;
	
	private String imgSrc;
	
	private Integer otherId;
	
	private Date regTime;
	
	private String password;



	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	public Integer getOtherId() {
		return otherId;
	}

	public void setOtherId(Integer otherId) {
		this.otherId = otherId;
	}

	public Date getRegTime() {
		return regTime;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
