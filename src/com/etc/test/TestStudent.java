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
		System.out.println("��������Ҫ�޸ĵ�ѧ��ID��");
		int sid = sc.nextInt();
		System.out.println("�������û�����");
		String sname = sc.next();
		System.out.println("���������룺");
		String spwd = sc.next();
		System.out.println("���������䣺");
		int sage = sc.nextInt();
		System.out.println("�����뱸ע��");
		String sdetail = sc.next();
		
		Student s = new Student();
		s.setSid(sid);
		s.setSname(sname);
		s.setSpwd(spwd);
		s.setSage(sage);
		s.setSdetail(sdetail);
		
		sm.updateStudent(s);*/
		
		/*System.out.println("��������Ҫɾ����ѧ��ID��");
		
		int sid = sc.nextInt();
		
		sm.deleteStudentById(sid);*/
		/*System.out.println("��������Ҫ���ҵ�ѧ��ID��");
		int sid = sc.nextInt();
		Student s = sm.findStudentById(sid);
		System.out.println(s);*/
		/*System.out.println("�������û�����");
		String sname = sc.next();
		System.out.println("���������룺");
		String spwd = sc.next();
		System.out.println("���������䣺");
		int sage = sc.nextInt();
		System.out.println("�����뱸ע��");
		String sdetail = sc.next();
		
		Student s = new Student();
		s.setSname(sname);
		s.setSpwd(spwd);
		s.setSage(sage);
		s.setSdetail(sdetail);
		
		
		sm.addStudent(s);*/
		/*
		if(sm.checkUser(sname, spwd))
			System.out.println("��½�ɹ�");
		else
			System.out.println("��½ʧ��");
*/
	}

}
