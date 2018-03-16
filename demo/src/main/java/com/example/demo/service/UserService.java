/**
 * @(#)UserService.java
 * Description:	TODO 填写文件作用简要说明
 * Version :	0.0.0
 * Copyright:	Copyright (c) 哈尔滨修盾信息科技有限公司  版权所有
 * Create by:	单彤  2018年3月15日
 */
package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.User;

/**
 * TODO 填写功能说明
 * @author 单彤
 */
public interface UserService {
	User getUserById(Integer id);

	public List<User> getUserList();

	public int addUser(User user);

	public int updateUserById(Integer id, User user);

	public int deleteById(Integer id);
}
