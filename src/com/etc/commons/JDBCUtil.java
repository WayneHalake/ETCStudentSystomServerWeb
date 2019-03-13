package com.etc.commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 链接数据库的工具类
 * 该类提供两个工具：获取数据库链接工具和关闭数据库资源工具
 * @author Administrator
 *
 */
public class JDBCUtil {
	
	private static String url="jdbc:mysql://localhost:3306/etcstudentsystem";
	private static String user="root";
	private static String password="123456";
	
	/**
	 * 获取数据库链接方法
	 * @return
	 */
	public static Connection getConn(){
		Connection conn = null;
		try {
			//加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			
			System.out.println("connection is start");
			
			//数据库链接--数据库链接通过DriverManage来管理
			conn = DriverManager.getConnection(url, user, password);
			
			System.out.println("connection is end!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	/**
	 * 关闭数据库的各种资源
	 * @param conn
	 * @param stat
	 * @param rs
	 */
	public static void closeDB(Connection conn,Statement stat, ResultSet rs){
		//关闭各种资源
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
