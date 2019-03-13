package com.etc.entity;

import java.sql.Date;

public class Users {
	
	private int userid;
	private int usernum;
	private String type;
	private String username;
	private String userpwd;
	private String gender;
	private Date intake,outtake;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getUsernum() {
		return usernum;
	}
	public void setUsernum(int usernum) {
		this.usernum = usernum;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getIntake() {
		return intake;
	}
	public void setIntake(Date intake) {
		this.intake = intake;
	}
	public Date getOuttake() {
		return outtake;
	}
	public void setOuttake(Date outtake) {
		this.outtake = outtake;
	}
	public Users(int userid, int usernum, String type, String username, String userpwd, String gender, Date intake,
			Date outtake) {
		super();
		this.userid = userid;
		this.usernum = usernum;
		this.type = type;
		this.username = username;
		this.userpwd = userpwd;
		this.gender = gender;
		this.intake = intake;
		this.outtake = outtake;
	}
	public Users() {
		super();
	}
	
}
