/**
 * @(#)UserIDao.java
 * Description:	TODO ��д�ļ����ü�Ҫ˵��
 * Version :	0.0.0
 * Copyright:	Copyright (c) �������޶���Ϣ�Ƽ����޹�˾  ��Ȩ����
 * Create by:	��ͮ  2018��3��15��
 */
package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.domain.User;

/**
 * TODO mybatis dao�ӿ�
 * mapper�ļ�
 * mapper��ǩnamespace-->�೤��
 * sql����ǩid-->������
 * @author ��ͮ
 */
@Repository
public interface UserIDao {

	User getUserById(Integer id);
	
	public List<User> getUserList();
	
	public int addUser(User u);
	
	/*@Param��ǩ
	 * spring (0,1,param1,param2)
 	 * 
	 * mybatis (��ֵ���map)
	 * ע�ͽ���������󶨵�һ��map��Ϊ���������
	 * <if test="_parameter != 0">
	 * */
	public int updateUserById(@Param("id") Integer id,@Param("user") User u);
	
	public int deleteById(Integer id);
}
