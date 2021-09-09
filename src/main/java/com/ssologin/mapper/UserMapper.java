package com.ssologin.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ssologin.pojo.User;



@Repository
@Mapper
public interface UserMapper {

	/**
	 * 根据用户名查询用户
	 * @param name
	 * @return
	 */
	User findByName(@Param("username")String name);
	
	User findById(String id);
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	boolean addUser(User user);
	
	/**
	 * 根据id删除用户
	 * @param id
	 * @return
	 */
	boolean deleteUserById(String id);
	
	/**
	 * 根据id修改用户
	 * @param user
	 * @return
	 */
	boolean updateUserById(User user);
	
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<User> findAllUsers();
}
