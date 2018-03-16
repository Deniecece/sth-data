/**
 * @(#)User.java
 * Description:	TODO 填写文件作用简要说明
 * Version :	0.0.0
 * Copyright:	Copyright (c) 哈尔滨修盾信息科技有限公司  版权所有
 * Create by:	单彤  2018年3月15日
 */
package com.example.demo.domain;

import java.io.Serializable;

/**
 * TODO 实体类
 * @author 单彤
 */
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String username;
	private  String password;
	private String sex;
	
	public User() {
	}
	public User(Integer id) {
		this.id = id;
	}
	public User(Integer id, String username, String password, String sex) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.sex = sex;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
}

