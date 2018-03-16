/**
 * @(#)UserController.java
 * Description:	TODO ��д�ļ����ü�Ҫ˵��
 * Version :	0.0.0
 * Copyright:	Copyright (c) �������޶���Ϣ�Ƽ����޹�˾  ��Ȩ����
 * Create by:	��ͮ  2018��3��15��
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

	//��ʾ����ҳ��
	@GetMapping(value={" ", "/", "/dbtest"})
	public ModelAndView index(){
		return new ModelAndView("/show");
	}
	/**
	 * ����ID��ѯ�û�
	 * @param id
	 * @return
	 */
	//���ظ���ҳ������
	@RequestMapping("data/{id}")	
	public ResponseEntity<User> getUserById (@PathVariable(value = "id") Integer id){
		User user = userService.getUserById(id);
		return ResponseEntity.ok(user);
	}

	/**
	 * ��ѯ�û��б�
	 * @return
	 */
	@RequestMapping("users")
	public ResponseEntity<List<User>> getUserList (HttpServletRequest request){
		Map<String,Object> map = new HashMap<>();
		map.put("rows",userService.getUserList());
		return ResponseEntity.ok(userService.getUserList());
	}

	/**
	 * ����û�
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
	 * ����idɾ���û�
	 * @param id
	 * @return
	 */
	@RequestMapping("user/{id}")
	public ResponseEntity<Integer> delete (@PathVariable(value="id") Integer id){
		return ResponseEntity.ok(userService.deleteById(id));
	}
	//��ʾ����ҳ��
	@RequestMapping("updatePage")
	public ModelAndView updatePage (){
		return new ModelAndView("updateUser");
	}
	
	/**
	 * 
	 * ����id�޸��û���Ϣ
	 * @param user
	 * @return
	 */
	@RequestMapping("updateUser")
	public ResponseEntity<Integer> update (Integer id, User user){
		return ResponseEntity.ok(userService.updateUserById(id, user));
	}
}








