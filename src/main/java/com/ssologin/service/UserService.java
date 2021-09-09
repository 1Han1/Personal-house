package com.ssologin.service;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.ssologin.pojo.User;

@Service
public interface UserService {

	public User findByName(@Param("username")String name);
	
	public User findById(String id);
	
	public boolean addUser(User user);
	
	public boolean deleteUserById(String id);
	
	public boolean updateUserById(User user);
	
	public List<User> findAllUsers();
}
