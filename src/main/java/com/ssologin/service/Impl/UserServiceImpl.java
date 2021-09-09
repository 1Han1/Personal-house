package com.ssologin.service.Impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssologin.mapper.UserMapper;
import com.ssologin.pojo.User;
import com.ssologin.service.UserService;
import com.ssologin.utils.MD5Util;
import com.ssologin.utils.UuidUtil;



@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserMapper userMapper;

	@Override
	public User findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		String uuid = UuidUtil.getUUID();
		String pwd = MD5Util.getMd5StrSalt(user.getPassword(), user.getUsername());
		user.setId(uuid);
		user.setPassword(pwd);
		return userMapper.addUser(user);
	}

	@Override
	public boolean deleteUserById(String id) {
		// TODO Auto-generated method stub
		return userMapper.deleteUserById(id);
	}

	@Override
	public boolean updateUserById(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateUserById(user);
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return userMapper.findAllUsers();
	}

	@Override
	public User findById(String id) {
		// TODO Auto-generated method stub
		return userMapper.findById(id);
	}
	
	
	
}
