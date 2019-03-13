package com.etc.dao;

import java.util.List;

import com.etc.entity.Users;

/**
 * ѧ������ӿ�
 * 
 * @author Administrator
 *
 */
public interface UserManage {
	/**
	 * ��½�ӿڣ��贫���û���������
	 * @param username
	 * @param userpwd
	 * @return true����½�ɹ���false����½ʧ��
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
	 * �����û��Ľӿ�
	 * @param Users
	 * 
	 */
	public void registUser(Users user);
	
	/**
	 * ���ҵ����û�����Ϣ
	 * @param userid
	 * @param type
	 * @return Users
	 */
	public Users findUserById(int userid,String type);
	
	/**
	 * ����useridɾ���û���Ϣ
	 * @param userid
	 * @param type
	 */
	public void deleteuserById(int userid,String type);
	
	/**
	 * �޸��û���Ϣ���е���Ϣ
	 * @param Users
	 * @param type
	 */
	public void admupdateuser(Users user,String type);
	
	/**
	 * �޸ĵ�¼���е���Ϣ
	 * @param userid
	 */
	public void updateuser(Users user);
	
	/**
	 * �������е��û�
	 * @param type
	 * @return List<Users>
	 */
	public List<Users> findAllUsers(String type);
}
