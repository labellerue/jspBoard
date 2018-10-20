package kr.or.ddit.jsp_board.model;

import java.util.Date;

public class Jsp_boardVo {
	private int board_id;
	private String board_subject;
	private int board_avail;
	private Date board_date;
	private String board_userid;
	private int rnum;
	
	
	public Jsp_boardVo() {
	}
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public String getBoard_subject() {
		return board_subject;
	}
	public void setBoard_subject(String board_subject) {
		this.board_subject = board_subject;
	}
	public int getBoard_avail() {
		return board_avail;
	}
	public void setBoard_avail(int board_avail) {
		this.board_avail = board_avail;
	}
	public String getBoard_userid() {
		return board_userid;
	}
	public void setBoard_userid(String board_userid) {
		this.board_userid = board_userid;
	}
	public Date getBoard_date() {
		return board_date;
	}
	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	
	
	
	
}
