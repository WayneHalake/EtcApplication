package com.entity;

import java.io.Serializable;
import java.sql.Date;

public class Users implements Serializable{
	
	private String userid;
	private int usernum;
	private String type;
	private String name;
	private String username;
	private String userpwd;
	private String gender;
	String intake;
	private String outtake;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String string) {
		this.userid = string;
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
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getIntake() {
		return intake;
	}
	public void setIntake(String string) {
		this.intake = string;
	}
	public String getOuttake() {
		return outtake;
	}
	public void setOuttake(String string) {
		this.outtake = string;
	}
	public Users(String userid, String type, String name,String username, String userpwd, String gender, String intake,
			String outtake) {
		super();
		
		this.userid = userid;
		this.type = type;
		this.name=name;
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
