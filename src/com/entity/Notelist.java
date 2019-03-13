package com.entity;

import java.io.Serializable;
import java.sql.Date;

public class Notelist implements Serializable{
	private int noteid;
	private String notename;
	private String publishedtime;
	private int userid;
	private String notecontent;
	private String username;
	public int getNoteid() {
		return noteid;
	}
	public void setNoteid(int noteid) {
		this.noteid = noteid;
	}
	public String getNotename() {
		return notename;
	}
	public void setNotename(String notename) {
		this.notename = notename;
	}
	public String getPublishedtime() {
		return publishedtime;
	}
	public void setPublishedtime(String date) {
		this.publishedtime = date;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getNotecontent() {
		return notecontent;
	}
	public void setNotecontent(String notecontent) {
		this.notecontent = notecontent;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Notelist(int noteid, String notename, String publishedtime,
			int userid, String notecontent, String username) {
		super();
		this.noteid = noteid;
		this.notename = notename;
		this.publishedtime = publishedtime;
		this.userid = userid;
		this.notecontent = notecontent;
		this.username = username;
	}
	public Notelist() {
		super();
	}
	
	
}
