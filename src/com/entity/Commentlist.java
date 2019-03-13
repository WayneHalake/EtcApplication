package com.entity;

import java.io.Serializable;
import java.sql.Date;

public class Commentlist implements Serializable{
	private int commentid;
	private int articleid;
	private int noteid;
	private String content;
	private String commenttime;
	private int commentuserid;
	private String username;
	public int getCommentid() {
		return commentid;
	}
	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}
	public int getArticleid() {
		return articleid;
	}
	public void setArticleid(int articleid) {
		this.articleid = articleid;
	}
	public int getNoteid() {
		return noteid;
	}
	public void setNoteid(int noteid) {
		this.noteid = noteid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCommenttime() {
		return commenttime;
	}
	public void setCommenttime(String commenttime) {
		this.commenttime = commenttime;
	}
	public int getCommentuserid() {
		return commentuserid;
	}
	public void setCommentuserid(int commentuserid) {
		this.commentuserid = commentuserid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public Commentlist(int commentid, int articleid, int noteid, String content, String commenttime, int commentuserid,
			String username) {
		super();
		this.commentid = commentid;
		this.articleid = articleid;
		this.noteid = noteid;
		this.content = content;
		this.commenttime = commenttime;
		this.commentuserid = commentuserid;
		this.username = username;
	}
	public Commentlist() {
		super();
	}
	
}
