package com.etc.test;

import java.sql.*;

import com.etc.commons.JDBCUtil;

public class TestJDBC {
	private static String url="jdbc:mysql://localhost:3306/test";
	private static String user="root";
	private static String password="root";

	public static void main(String[] args) {
		Connection conn =null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			//��ȡ���ݿ�����
			conn = JDBCUtil.getConn();
			//��ȡִ��SQL���Ķ���
			stat = conn.createStatement();
			
			//�������ݿ�
			//stat.executeUpdate("insert into aa(sname) values('zhough')");
			
			rs = stat.executeQuery("select * from aa");
			
			//��������
			while(rs.next()){
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString("sname"));
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.closeDB(conn, stat, rs);
			
		}

	}

}
