package kr.or.ddit.post.model;

import java.util.Date;

public class PostVo {
	private int post_id;
	private int board_id;
	private String post_title;
	private String post_article;
	private int post_pid;
	private Date post_date;
	private int post_del;
	private int post_groupid;
	private String post_userid;
	private int rnum;
	private int tofile_id;
	
	
	public int getTofile_id() {
		return tofile_id;
	}
	public void setTofile_id(int tofile_id) {
		this.tofile_id = tofile_id;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public String getPost_title() {
		return post_title;
	}
	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}
	public String getPost_article() {
		return post_article;
	}
	public void setPost_article(String post_article) {
		this.post_article = post_article;
	}
	public int getPost_pid() {
		return post_pid;
	}
	public void setPost_pid(int post_pid) {
		this.post_pid = post_pid;
	}
	public Date getPost_date() {
		return post_date;
	}
	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}
	public int getPost_del() {
		return post_del;
	}
	public void setPost_del(int post_del) {
		this.post_del = post_del;
	}
	public int getPost_groupid() {
		return post_groupid;
	}
	public void setPost_groupid(int post_groupid) {
		this.post_groupid = post_groupid;
	}
	public String getPost_userid() {
		return post_userid;
	}
	public void setPost_userid(String post_userid) {
		this.post_userid = post_userid;
	}
	@Override
	public String toString() {
		return "PostVo [post_id=" + post_id + ", board_id=" + board_id
				+ ", post_title=" + post_title + ", post_article="
				+ post_article + ", post_pid=" + post_pid + ", post_date="
				+ post_date + ", post_del=" + post_del + ", post_groupid="
				+ post_groupid + ", post_userid=" + post_userid + ", rnum="
				+ rnum + "]";
	}
	
	
	
	

}
