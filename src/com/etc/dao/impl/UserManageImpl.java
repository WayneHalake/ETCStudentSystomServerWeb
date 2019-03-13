package com.etc.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.etc.commons.JDBCUtil;
import com.etc.dao.UserManage;
import com.etc.entity.Users;

public class UserManageImpl implements UserManage {

	
	@Override
	public boolean checkUser(String username, String userpwd) {
		boolean bl = false;
		Connection conn = null;
		Statement stat = null;
		ResultSet rs1 = null;

		// 获取数据库链接
		conn = JDBCUtil.getConn();

		// 声明SQL语句
		String sql1 = "select * from logintable where username='" + username
				+ "' and userpwd='" + userpwd + "'";
		System.out.println("sql:" + sql1);
		

		try {
			// 获取执行SQL语句的对象
			stat = conn.createStatement();

			// 检索数据库
			rs1 = stat.executeQuery(sql1);

			while (rs1.next()) {
				bl = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.closeDB(conn, stat, rs1);

		}
		return bl;
	}

	@Override
	public void registUser(Users user) {
		Connection conn = null;
		Statement stat = null;
		
		 int userid=user.getUserid();
		 int usernum=user.getUsernum();
		 String type=user.getType();
		 String username=user.getUsername();
		 String userpwd=user.getUserpwd();
		 String gender=user.getGender();
		 Date intake=user.getIntake();
		 Date outtake=user.getOuttake();
		 
		try {
			// 获取数据库链接对象
			conn = JDBCUtil.getConn();

			// 声明sql语句
			String sql1 = "insert into logintable(userid,username,userpwd,usertype) "
					+ "values(" +userid+ ",'"
					+ username + "','" + userpwd + "','"
					+ type+ "')";
			
			System.out.println("sql1:" + sql1);
			String sql2=null;
			
			if(type.equals("student")){
				
				sql2 = "insert into studentstable(userid,username,usernum,gender,intake,outtake) "
						+ "values(" +userid+ ",'"
						+ username + "'," + usernum + ",'"
						+ gender+ "',"+intake+","+outtake+")";
				
				System.out.println("sql2:" + sql2);
			}
			else if(type.equals("teacher")){
				sql2 = "insert into teacherstable(userid,username,usernum,gender,intake,outtake) "
						+ "values(" +userid+ ",'"
						+ username + "'," + usernum + ",'"
						+ gender+ "',"+intake+","+outtake+")";
				
				System.out.println("sql2:" + sql2);
			}
			else{
				sql2 = "insert into admisterstable(userid,username,usernum,gender,intake,outtake) "
						+ "values(" +userid+ ",'"
						+ username + "'," + usernum + ",'"
						+ gender+ "',"+intake+","+outtake+")";
				
				System.out.println("sql2:" + sql2);
			}

			
			//获取执行sql语句的对象
			stat = conn.createStatement();
			
			//执行检索数据库
			stat.executeUpdate(sql1);
			stat.executeUpdate(sql2);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.closeDB(conn, stat, null);
		}

	}

	@Override
	public Users findUserById(int userid,String type) {
		Users user = new Users();
		Connection conn = null;
		PreparedStatement stat = null;//PreparedStatement:预编译语句
		ResultSet rs = null;
		String table=null;
		try {
			conn = JDBCUtil.getConn();
			
			//?为占位符
			
			//占位符赋值
			if(type.equals("student")){
				table="studentstable";
			}else if(type.equals("teacher")){
				table="teacherstable";
			}else{
				table="admisterstable";
			}
			stat = conn.prepareStatement("select * from "+table+" where userid=?");
			stat.setInt(1, userid);
			
			//执行检索数据库
			rs = stat.executeQuery();
			
			//处理结果集
			while(rs.next()){
				user.setUserid(rs.getInt("userid"));
				user.setUsername(rs.getString("username"));
				user.setGender(rs.getString("gender"));
				user.setUsernum(rs.getInt("usernum"));
				user.setIntake(rs.getDate("intake"));
				user.setOuttake(rs.getDate("outtake"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.closeDB(conn, stat, rs);
		}
		return user;
	}

	@Override
	public void deleteuserById(int userid,String type) {
		Connection conn = null;
		Statement stat = null;
		String table=null;
		String sql1,sql2;
		try {
			// 获取数据库链接对象
			conn = JDBCUtil.getConn();

			// 声明sql语句
			if(type.equals("student")){
				table="studentstable";
			}else if(type.equals("teacher")){
				table="teacherstable";
			}else{
				table="admisterstable";
			}
			
			sql2 = "delete from "+table+" where userid="+userid;
				
			sql1="delete from logintable where userid="+userid;
			//获取执行sql语句的对象
			stat = conn.createStatement();
			
			//执行检索数据库
			stat.executeUpdate(sql2);
			stat.executeUpdate(sql1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.closeDB(conn, stat, null);
		}
	}
	
	@Override
	public void admupdateuser(Users user,String type) {
		Connection conn = null;
		PreparedStatement stat = null;
		String table=null;
		try {
			// 获取数据库链接对象
			conn = JDBCUtil.getConn();
			
			if(type.equals("student")){
				table="studentstable";
			}else if(type.equals("teacher")){
				table="teacherstable";
			}else{
				table="admisterstable";
			}
			// 声明sql语句
			String sql = "update "+table+" set username=?,usernum=?,gender=?,intake=?,outtake=? where userid=?";
			stat = conn.prepareStatement(sql);
			

			stat.setString(1, user.getUsername());
			stat.setInt(2, user.getUsernum());
			stat.setString(3, user.getGender());
			stat.setDate(4, user.getIntake());
			stat.setDate(5, user.getOuttake());
			stat.setInt(6, user.getUserid());
			
			//执行检索数据库
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.closeDB(conn, stat, null);
		}
		
	}
	
	@Override
	public List<Users> findAllUsers(String type){
		List<Users> user1 = new ArrayList<Users>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		String table=null;
		try {
			conn = JDBCUtil.getConn();
			
			if(type.equals("student")){
				table="studentstable";
			}else if(type.equals("teacher")){
				table="teacherstable";
			}else{
				table="admisterstable";
			}
			
			String sql = "select * from "+table;
			
			stat = conn.createStatement();
			
			rs = stat.executeQuery(sql);
			
			while(rs.next()){
				Users user2 = new Users();
				user2.setUserid(rs.getInt("userid"));
				user2.setUsername(rs.getString("username"));
				user2.setUsernum(rs.getInt("usernum"));
				user2.setGender(rs.getString("gender"));
				user2.setIntake(rs.getDate("intake"));
				user2.setOuttake(rs.getDate("outtake"));
				
				user1.add(user2);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtil.closeDB(conn, stat, rs);

		}
		return user1;
	}

	@Override
	public boolean checkUser(String username, String userpwd, String usertype) {
		// TODO Auto-generated method stub
		boolean bl = false;
		Connection conn = null;
		Statement stat = null;
		ResultSet rs1 = null;

		// 获取数据库链接
		conn = JDBCUtil.getConn();

		// 声明SQL语句
		String sql1 = "select * from logintable where username='" + username
				+ "' and userpwd='" + userpwd + "'and usertype='"+usertype+"'";
		System.out.println("sql:" + sql1);
		

		try {
			// 获取执行SQL语句的对象
			stat = conn.createStatement();

			// 检索数据库
			rs1 = stat.executeQuery(sql1);

			while (rs1.next()) {
				bl = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.closeDB(conn, stat, rs1);

		}
		return bl;
	}

	@Override
	public void updateuser(Users user) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stat = null;
		
		try {
			// 获取数据库链接对象
			conn = JDBCUtil.getConn();

			// 声明sql语句
			String sql = "update logintable set username=?,userpwd=? where userid=?";
			stat = conn.prepareStatement(sql);
			
			stat.setString(1, user.getUsername());
			stat.setString(2, user.getUserpwd());

			stat.setInt(3, user.getUserid());
			
			//执行检索数据库
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.closeDB(conn, stat, null);
		}
	}


}
