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
			//获取数据库链接
			conn = JDBCUtil.getConn();
			//获取执行SQL语句的对象
			stat = conn.createStatement();
			
			//检索数据库
			//stat.executeUpdate("insert into aa(sname) values('zhough')");
			
			rs = stat.executeQuery("select * from aa");
			
			//处理数据
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
