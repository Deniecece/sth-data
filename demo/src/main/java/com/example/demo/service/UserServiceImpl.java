/**
 * @(#)UserServiceImpl.java
 * Description:	TODO ��д�ļ����ü�Ҫ˵��
 * Version :	0.0.0
 * Copyright:	Copyright (c) �������޶���Ϣ�Ƽ����޹�˾  ��Ȩ����
 * Create by:	��ͮ  2018��3��15��
 */
package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserIDao;
import com.example.demo.domain.User;

/**
 * TODO ��д����˵��
 * @author ��ͮ
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserIDao userMapper;

	@Override
	public User getUserById(Integer id) {
		return userMapper.getUserById(id);
	}

	@Override
	public List<User> getUserList() {
		return userMapper.getUserList();
	}

	@Override
	public int addUser(User user) {
		return userMapper.addUser(user);
	}

	@Override
	public int updateUserById(Integer id, User user) {
		return userMapper.updateUserById(id, user);
	}

	@Override
	public int deleteById(Integer id) {
		return userMapper.deleteById(id);
	}
}

