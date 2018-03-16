/**
 * @(#)UserService.java
 * Description:	TODO ��д�ļ����ü�Ҫ˵��
 * Version :	0.0.0
 * Copyright:	Copyright (c) �������޶���Ϣ�Ƽ����޹�˾  ��Ȩ����
 * Create by:	��ͮ  2018��3��15��
 */
package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.User;

/**
 * TODO ��д����˵��
 * @author ��ͮ
 */
public interface UserService {
	User getUserById(Integer id);

	public List<User> getUserList();

	public int addUser(User user);

	public int updateUserById(Integer id, User user);

	public int deleteById(Integer id);
}
