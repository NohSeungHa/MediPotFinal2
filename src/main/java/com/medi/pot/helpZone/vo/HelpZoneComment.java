package com.medi.pot.helpZone.vo;

import java.util.Date;

public class HelpZoneComment {
	private int hzCommentNum;			//댓글 번호
	private int hzCommentLevel;		//댓글 레벨
	private int hzCommentWriterNum;		//병원번호(답글작성자)
	private int hzNum;					//헬프존 글번호
	private String hzCommentContent; 	//답글 내용
	private Date hzCommentDate;			//답글 날짜
	
	public HelpZoneComment() {
		// TODO Auto-generated constructor stub
	}

	public HelpZoneComment(int hzCommentNum, int hzCommentLevel, int hzCommentWriterNum, int hzNum,
			String hzCommentContent, Date hzCommentDate) {
		super();
		this.hzCommentNum = hzCommentNum;
		this.hzCommentLevel = hzCommentLevel;
		this.hzCommentWriterNum = hzCommentWriterNum;
		this.hzNum = hzNum;
		this.hzCommentContent = hzCommentContent;
		this.hzCommentDate = hzCommentDate;
	}

	public int getHzCommentNum() {
		return hzCommentNum;
	}

	public void setHzCommentNum(int hzCommentNum) {
		this.hzCommentNum = hzCommentNum;
	}

	public int getHzCommentLevel() {
		return hzCommentLevel;
	}

	public void setHzCommentLevel(int hzCommentLevel) {
		this.hzCommentLevel = hzCommentLevel;
	}

	public int getHzCommentWriterNum() {
		return hzCommentWriterNum;
	}

	public void setHzCommentWriterNum(int hzCommentWriterNum) {
		this.hzCommentWriterNum = hzCommentWriterNum;
	}

	public int getHzNum() {
		return hzNum;
	}

	public void setHzNum(int hzNum) {
		this.hzNum = hzNum;
	}

	public String getHzCommentContent() {
		return hzCommentContent;
	}

	public void setHzCommentContent(String hzCommentContent) {
		this.hzCommentContent = hzCommentContent;
	}

	public Date getHzCommentDate() {
		return hzCommentDate;
	}

	public void setHzCommentDate(Date hzCommentDate) {
		this.hzCommentDate = hzCommentDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HelpZoneComment [hzCommentNum=").append(hzCommentNum).append(", hzCommentLevel=")
				.append(hzCommentLevel).append(", hzCommentWriterNum=").append(hzCommentWriterNum).append(", hzNum=")
				.append(hzNum).append(", hzCommentContent=").append(hzCommentContent).append(", hzCommentDate=")
				.append(hzCommentDate).append("]");
		return builder.toString();
	}
	
	
	
}
