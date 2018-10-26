package kr.or.ddit.comm.model;

import java.util.Date;

public class CommVo {
	private int comm_id;
	private int post_id;
	private String comm_note;
	private Date comm_date;
	private int comm_del;
	private String comm_userid;
	
	public CommVo() {
	}
	public int getComm_id() {
		return comm_id;
	}
	public void setComm_id(int comm_id) {
		this.comm_id = comm_id;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public String getComm_note() {
		return comm_note;
	}
	public void setComm_note(String comm_note) {
		this.comm_note = comm_note;
	}
	public Date getComm_date() {
		return comm_date;
	}
	public void setComm_date(Date comm_date) {
		this.comm_date = comm_date;
	}
	public int getComm_del() {
		return comm_del;
	}
	public void setComm_del(int comm_del) {
		this.comm_del = comm_del;
	}
	public String getComm_userid() {
		return comm_userid;
	}
	public void setComm_userid(String comm_userid) {
		this.comm_userid = comm_userid;
	}
	@Override
	public String toString() {
		return "CommVo [comm_id=" + comm_id + ", post_id=" + post_id + ", comm_note=" + comm_note + ", comm_date="
				+ comm_date + ", comm_del=" + comm_del + ", comm_userid=" + comm_userid + "]";
	}
	
	
	
}
