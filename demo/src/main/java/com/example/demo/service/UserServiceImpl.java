/**
 * @(#)UserServiceImpl.java
 * Description:	TODO 填写文件作用简要说明
 * Version :	0.0.0
 * Copyright:	Copyright (c) 哈尔滨修盾信息科技有限公司  版权所有
 * Create by:	单彤  2018年3月15日
 */
package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserIDao;
import com.example.demo.domain.User;

/**
 * TODO 填写功能说明
 * @author 单彤
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

