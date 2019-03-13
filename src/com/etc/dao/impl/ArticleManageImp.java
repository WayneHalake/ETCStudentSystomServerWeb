package com.etc.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.etc.commons.JDBCUtil;
import com.etc.dao.ArticleManage;
import com.etc.entity.Articles;

public class ArticleManageImp implements ArticleManage {

	@Override
	public List<Articles> showAll() {
		// TODO Auto-generated method stub
		List<Articles> articles=new ArrayList<Articles>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		String sql = "select * from articlestable";
		
		try {
			conn = JDBCUtil.getConn();
			stat=conn.createStatement();
			rs=stat.executeQuery(sql);
			
			while(rs.next()){
				Articles art=new Articles();
				
				art.setUsername(rs.getString("username"));
				art.setArticlename(rs.getString("articlename"));
				art.setArticleid(rs.getInt("articleid"));
				art.setPublishedtime(rs.getDate("publishedtime"));
				art.setUserid(rs.getInt("userid"));
				art.setArticlecontent(rs.getString("articlecontent"));
				articles.add(art);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.closeDB(conn, stat, rs);

		}

		return articles;
	}

	@Override
	public void delete(int articleid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		String sql1,sql2;
		
		try {
			//获取数据库连接对象
			conn = JDBCUtil.getConn();
			//声明sql语句
			sql2 = "delete from articlecommenttable where articleid="+articleid;
			
			System.out.println("sql:" + sql2);
			
			sql1="delete from articlestable where articleid="+articleid;
			
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
	public Articles showArticle(int articleid) {
		// TODO Auto-generated method stub
		Articles art=new Articles();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		String sql = "select * from articlestable where articleid="+articleid;
		try {
			conn = JDBCUtil.getConn();
			stat=conn.createStatement();
			rs=stat.executeQuery(sql);
			
			while(rs.next()){	
				art.setUsername(rs.getString("username"));
				art.setArticlename(rs.getString("articlename"));
				art.setArticleid(rs.getInt("articleid"));
				art.setPublishedtime(rs.getDate("publishedtime"));
				art.setUserid(rs.getInt("userid"));
				art.setArticlecontent(rs.getString("articlecontent"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.closeDB(conn, stat, rs);

		}
		return art;
	}

}
