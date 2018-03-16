/**
 * @(#)UserIDao.java
 * Description:	TODO 填写文件作用简要说明
 * Version :	0.0.0
 * Copyright:	Copyright (c) 哈尔滨修盾信息科技有限公司  版权所有
 * Create by:	单彤  2018年3月15日
 */
package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.domain.User;

/**
 * TODO mybatis dao接口
 * mapper文件
 * mapper标签namespace-->类长名
 * sql语句标签id-->方法名
 * @author 单彤
 */
@Repository
public interface UserIDao {

	User getUserById(Integer id);
	
	public List<User> getUserList();
	
	public int addUser(User u);
	
	/*@Param标签
	 * spring (0,1,param1,param2)
 	 * 
	 * mybatis (按值组成map)
	 * 注释将多个参数绑定到一个map做为输入参数。
	 * <if test="_parameter != 0">
	 * */
	public int updateUserById(@Param("id") Integer id,@Param("user") User u);
	
	public int deleteById(Integer id);
}
