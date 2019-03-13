package com.etc.test;

import java.util.List;


import com.etc.dao.UserManage;
import com.etc.dao.impl.UserManageImpl;
import com.etc.entity.Users;

public class TestStudent {

	public static void main(String[] args) {
		UserManage um = new UserManageImpl();
		
		List<Users> students = um.findAllUsers("admis");
		
		for (Users student : students) {
			
			System.out.println(student.getUsername());
		}
		/*Scanner sc = new Scanner(System.in);
		System.out.println("请输入你要修改的学生ID：");
		int sid = sc.nextInt();
		System.out.println("请输入用户名：");
		String sname = sc.next();
		System.out.println("请输入密码：");
		String spwd = sc.next();
		System.out.println("请输入年龄：");
		int sage = sc.nextInt();
		System.out.println("请输入备注：");
		String sdetail = sc.next();
		
		Student s = new Student();
		s.setSid(sid);
		s.setSname(sname);
		s.setSpwd(spwd);
		s.setSage(sage);
		s.setSdetail(sdetail);
		
		sm.updateStudent(s);*/
		
		/*System.out.println("请输入你要删除的学生ID：");
		
		int sid = sc.nextInt();
		
		sm.deleteStudentById(sid);*/
		/*System.out.println("请输入你要查找的学生ID：");
		int sid = sc.nextInt();
		Student s = sm.findStudentById(sid);
		System.out.println(s);*/
		/*System.out.println("请输入用户名：");
		String sname = sc.next();
		System.out.println("请输入密码：");
		String spwd = sc.next();
		System.out.println("请输入年龄：");
		int sage = sc.nextInt();
		System.out.println("请输入备注：");
		String sdetail = sc.next();
		
		Student s = new Student();
		s.setSname(sname);
		s.setSpwd(spwd);
		s.setSage(sage);
		s.setSdetail(sdetail);
		
		
		sm.addStudent(s);*/
		/*
		if(sm.checkUser(sname, spwd))
			System.out.println("登陆成功");
		else
			System.out.println("登陆失败");
*/
	}

}
