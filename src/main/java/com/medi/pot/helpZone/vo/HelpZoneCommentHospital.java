package com.medi.pot.helpZone.vo;

import java.util.Date;

public class HelpZoneCommentHospital {
	private int hzCommentNumH;			//병원 댓글 번호
	private int hzNumH;					//헬프존 번호
	private int hzCommentWriterNumH;	//병원 회원 작성자
	private String hzCommentContentH;	//댓글내용
	private Date date;					//날짜
	private int hzCommentLevelH;		//댓글 레벨
	private char hzCommentChoice;		//채택여부
	
	public HelpZoneCommentHospital() {
		// TODO Auto-generated constructor stub
	}

	public HelpZoneCommentHospital(int hzCommentNumH, int hzNumH, int hzCommentWriterNumH, String hzCommentContentH,
			Date date, int hzCommentLevelH, char hzCommentChoice) {
		super();
		this.hzCommentNumH = hzCommentNumH;
		this.hzNumH = hzNumH;
		this.hzCommentWriterNumH = hzCommentWriterNumH;
		this.hzCommentContentH = hzCommentContentH;
		this.date = date;
		this.hzCommentLevelH = hzCommentLevelH;
		this.hzCommentChoice = hzCommentChoice;
	}

	public int getHzCommentNumH() {
		return hzCommentNumH;
	}

	public void setHzCommentNumH(int hzCommentNumH) {
		this.hzCommentNumH = hzCommentNumH;
	}

	public int getHzNumH() {
		return hzNumH;
	}

	public void setHzNumH(int hzNumH) {
		this.hzNumH = hzNumH;
	}

	public int getHzCommentWriterNumH() {
		return hzCommentWriterNumH;
	}

	public void setHzCommentWriterNumH(int hzCommentWriterNumH) {
		this.hzCommentWriterNumH = hzCommentWriterNumH;
	}

	public String getHzCommentContentH() {
		return hzCommentContentH;
	}

	public void setHzCommentContentH(String hzCommentContentH) {
		this.hzCommentContentH = hzCommentContentH;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getHzCommentLevelH() {
		return hzCommentLevelH;
	}

	public void setHzCommentLevelH(int hzCommentLevelH) {
		this.hzCommentLevelH = hzCommentLevelH;
	}

	public char getHzCommentChoice() {
		return hzCommentChoice;
	}

	public void setHzCommentChoice(char hzCommentChoice) {
		this.hzCommentChoice = hzCommentChoice;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HelpZoneCommentHospital [hzCommentNumH=").append(hzCommentNumH).append(", hzNumH=")
				.append(hzNumH).append(", hzCommentWriterNumH=").append(hzCommentWriterNumH)
				.append(", hzCommentContentH=").append(hzCommentContentH).append(", date=").append(date)
				.append(", hzCommentLevelH=").append(hzCommentLevelH).append(", hzCommentChoice=")
				.append(hzCommentChoice).append("]");
		return builder.toString();
	}
	
	
}
