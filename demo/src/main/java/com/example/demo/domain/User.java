/**
 * @(#)User.java
 * Description:	TODO ��д�ļ����ü�Ҫ˵��
 * Version :	0.0.0
 * Copyright:	Copyright (c) �������޶���Ϣ�Ƽ����޹�˾  ��Ȩ����
 * Create by:	��ͮ  2018��3��15��
 */
package com.example.demo.domain;

import java.io.Serializable;

/**
 * TODO ʵ����
 * @author ��ͮ
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

