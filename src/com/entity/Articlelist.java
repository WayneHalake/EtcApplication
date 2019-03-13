package com.entity;

import java.io.Serializable;
import java.sql.Date;

public class Articlelist implements Serializable{
	private int articleid;
	private String articlename;
	private String publishedtime;
	private String username;
	private int userid;
	private String articlecontent;
	
	public int getArticleid() {
		return articleid;
	}
	public void setArticleid(int articleid) {
		this.articleid = articleid;
	}
	public String getArticlename() {
		return articlename;
	}
	public void setArticlename(String articlename) {
		this.articlename = articlename;
	}
	public String getPublishedtime() {
		return publishedtime;
	}
	public void setPublishedtime(String publishedtime) {
		this.publishedtime = publishedtime;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public Articlelist(int articleid, String articlename, String publishedtime,
			String username, int userid, String articlecontent) {
		super();
		this.articleid = articleid;
		this.articlename = articlename;
		this.publishedtime = publishedtime;
		this.username = username;
		this.userid = userid;
		this.articlecontent = articlecontent;
	}
	public Articlelist() {
		super();
	}
	
}
