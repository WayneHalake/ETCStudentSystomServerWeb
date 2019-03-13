package com.etc.entity;

import java.sql.Date;

public class Articles {
	private int articleid;
	private String articlename;
	private Date publishedtime;
	private int userid;
	private String articlecontent;
	private String username;
	
	public int getArticleid() {
		return articleid;
	}
	public void setArticleid(int articleid) {
		this.articleid = articleid;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getArticlename() {
		return articlename;
	}
	public void setArticlename(String articlename) {
		this.articlename = articlename;
	}
	public Date getPublishedtime() {
		return publishedtime;
	}
	public void setPublishedtime(Date publishedtime) {
		this.publishedtime = publishedtime;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getArticlecontent() {
		return articlecontent;
	}
	public void setArticlecontent(String articlecontent) {
		this.articlecontent = articlecontent;
	}
	public Articles(int articleid, String articlename, Date publishedtime, int userid, String articlecontent,String username) {
		super();
		this.articleid = articleid;
		this.articlename = articlename;
		this.publishedtime = publishedtime;
		this.userid = userid;
		this.articlecontent = articlecontent;
		this.username=username;
	}
	public Articles() {
		super();
	}

}
