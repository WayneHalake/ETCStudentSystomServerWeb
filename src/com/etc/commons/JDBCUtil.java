package com.etc.commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * �������ݿ�Ĺ�����
 * �����ṩ�������ߣ���ȡ���ݿ����ӹ��ߺ͹ر����ݿ���Դ����
 * @author Administrator
 *
 */
public class JDBCUtil {
	
	private static String url="jdbc:mysql://localhost:3306/etcstudentsystem";
	private static String user="root";
	private static String password="123456";
	
	/**
	 * ��ȡ���ݿ����ӷ���
	 * @return
	 */
	public static Connection getConn(){
		Connection conn = null;
		try {
			//�������ݿ�����
			Class.forName("com.mysql.jdbc.Driver");
			
			System.out.println("connection is start");
			
			//���ݿ�����--���ݿ�����ͨ��DriverManage������
			conn = DriverManager.getConnection(url, user, password);
			
			System.out.println("connection is end!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	/**
	 * �ر����ݿ�ĸ�����Դ
	 * @param conn
	 * @param stat
	 * @param rs
	 */
	public static void closeDB(Connection conn,Statement stat, ResultSet rs){
		//�رո�����Դ
		try {
			if(null != rs)
				rs.close();
			if(null != stat)
				stat.close();
			if(null != conn)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
