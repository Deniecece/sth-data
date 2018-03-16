/**
 * @(#)UserController.java
 * Description:	TODO 填写文件作用简要说明
 * Version :	0.0.0
 * Copyright:	Copyright (c) 哈尔滨修盾信息科技有限公司  版权所有
 * Create by:	单彤  2018年3月15日
 */
package com.example.demo.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;


@RestController
public class UserController {

	@Autowired
	private UserService userService;

	//显示索引页面
	@GetMapping(value={" ", "/", "/dbtest"})
	public ModelAndView index(){
		return new ModelAndView("/show");
	}
	/**
	 * 根据ID查询用户
	 * @param id
	 * @return
	 */
	//加载更新页面数据
	@RequestMapping("data/{id}")	
	public ResponseEntity<User> getUserById (@PathVariable(value = "id") Integer id){
		User user = userService.getUserById(id);
		return ResponseEntity.ok(user);
	}

	/**
	 * 查询用户列表
	 * @return
	 */
	@RequestMapping("users")
	public ResponseEntity<List<User>> getUserList (HttpServletRequest request){
		Map<String,Object> map = new HashMap<>();
		map.put("rows",userService.getUserList());
		return ResponseEntity.ok(userService.getUserList());
	}

	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	@RequestMapping("saveUser")
	public ResponseEntity<Integer> add (User user){
		System.out.println("-------saveUser-------"+user.getUsername());
		return ResponseEntity.ok(userService.addUser(user));
	}
	@RequestMapping("savePage")
	public ModelAndView savePage (){
		return new ModelAndView("usersave");
	}
	
	/**
	 * 根据id删除用户
	 * @param id
	 * @return
	 */
	@RequestMapping("user/{id}")
	public ResponseEntity<Integer> delete (@PathVariable(value="id") Integer id){
		return ResponseEntity.ok(userService.deleteById(id));
	}
	//显示更新页面
	@RequestMapping("updatePage")
	public ModelAndView updatePage (){
		return new ModelAndView("updateUser");
	}
	
	/**
	 * 
	 * 根据id修改用户信息
	 * @param user
	 * @return
	 */
	@RequestMapping("updateUser")
	public ResponseEntity<Integer> update (Integer id, User user){
		return ResponseEntity.ok(userService.updateUserById(id, user));
	}
}








