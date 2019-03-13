package com.etc.dao;

import java.util.List;

import com.etc.entity.Users;

/**
 * 学生管理接口
 * 
 * @author Administrator
 *
 */
public interface UserManage {
	/**
	 * 登陆接口，需传入用户名和密码
	 * @param username
	 * @param userpwd
	 * @return true：登陆成功；false：登陆失败
	 */
	public boolean checkUser(String username,String userpwd);
	
	/**
	 * 
	 * @param username
	 * @param userpwd
	 * @param usertype
	 * @return
	 */
	public boolean checkUser(String username,String userpwd,String usertype);
	
	/**
	 * 增加用户的接口
	 * @param Users
	 * 
	 */
	public void registUser(Users user);
	
	/**
	 * 查找单个用户的信息
	 * @param userid
	 * @param type
	 * @return Users
	 */
	public Users findUserById(int userid,String type);
	
	/**
	 * 根据userid删除用户信息
	 * @param userid
	 * @param type
	 */
	public void deleteuserById(int userid,String type);
	
	/**
	 * 修改用户信息表中的信息
	 * @param Users
	 * @param type
	 */
	public void admupdateuser(Users user,String type);
	
	/**
	 * 修改登录表中的信息
	 * @param userid
	 */
	public void updateuser(Users user);
	
	/**
	 * 查找所有的用户
	 * @param type
	 * @return List<Users>
	 */
	public List<Users> findAllUsers(String type);
}
