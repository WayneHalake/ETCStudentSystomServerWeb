package com.etc.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.etc.commons.JDBCUtil;
import com.etc.dao.NoteManage;
import com.etc.entity.Notes;

public class NoteManageImp implements NoteManage {

	@Override
	public List<Notes> showAll() {
		// TODO Auto-generated method stub
		List<Notes> notes=new ArrayList<Notes>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		String sql = "select * from notestable";
		
		try {
			conn = JDBCUtil.getConn();
			stat=conn.createStatement();
			rs=stat.executeQuery(sql);
			
			while(rs.next()){
				Notes note=new Notes();
				
				note.setNoteid(rs.getInt("noteid"));
				note.setNotename(rs.getString("notename"));
				note.setPublishedtime(rs.getDate("publishedtime"));
				note.setUserid(rs.getInt("userid"));
				note.setUsername(rs.getString("username"));
				note.setNotecontent(rs.getString("notecontent"));
				
				notes.add(note);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.closeDB(conn, stat, rs);

		}

		return notes;
	}

	@Override
	public void delete(int noteid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		String sql1,sql2;
		
		try {
			//获取数据库连接对象
			conn = JDBCUtil.getConn();
			//声明sql语句
			sql2 = "delete from notecommenttable where noteid="+noteid;
			
			System.out.println("sql:" + sql2);
			
			sql1="delete from notestable where noteid="+noteid;
			
			System.out.println("sql:" + sql1);
			
			//获取执行sql语句的对象
			stat = conn.createStatement();
			
			//执行检索数据库
			stat.executeUpdate(sql2);
			stat.executeUpdate(sql1);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		} finally{
			
			JDBCUtil.closeDB(conn, stat, rs);
		}
	}

	@Override
	public Notes shownote(int noteid) {
		// TODO Auto-generated method stub
		Notes note=new Notes();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		String sql = "select * from notestable where noteid="+noteid;
		try {
			conn = JDBCUtil.getConn();
			stat=conn.createStatement();
			rs=stat.executeQuery(sql);
			
			while(rs.next()){	
				note.setNoteid(rs.getInt("noteid"));
				note.setNotename(rs.getString("notename"));
				note.setPublishedtime(rs.getDate("publishedtime"));
				note.setUserid(rs.getInt("userid"));
				note.setUsername(rs.getString("username"));
				note.setNotecontent(rs.getString("notecontent"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.closeDB(conn, stat, rs);

		}
		return note;
	}

}
