package com.medi.pot.helpZone.vo;

import java.sql.Date;
//일반회원 댓글 vo
public class HelpZoneCommentMember {
	private int hzCommentNumM;			//댓글 번호
	private int hzNumM;					//헬프존 글번호
	private int hzCommentWriterNumM;	//작성자 번호
	private String hzCommentContentM;	//댓글 내용
	private Date hzCommentDateM;		//댓글 날짜
	private int hzCommentLevelM;		//댓글레벨
	
	public HelpZoneCommentMember() {
		// TODO Auto-generated constructor stub
	}

	public int getHzCommentNumM() {
		return hzCommentNumM;
	}

	public void setHzCommentNumM(int hzCommentNumM) {
		this.hzCommentNumM = hzCommentNumM;
	}

	public int getHzNumM() {
		return hzNumM;
	}

	public void setHzNumM(int hzNumM) {
		this.hzNumM = hzNumM;
	}

	public int getHzCommentWriterNumM() {
		return hzCommentWriterNumM;
	}

	public void setHzCommentWriterNumM(int hzCommentWriterNumM) {
		this.hzCommentWriterNumM = hzCommentWriterNumM;
	}

	public String getHzCommentContentM() {
		return hzCommentContentM;
	}

	public void setHzCommentContentM(String hzCommentContentM) {
		this.hzCommentContentM = hzCommentContentM;
	}

	public Date getHzCommentDateM() {
		return hzCommentDateM;
	}

	public void setHzCommentDateM(Date hzCommentDateM) {
		this.hzCommentDateM = hzCommentDateM;
	}

	public int getHzCommentLevelM() {
		return hzCommentLevelM;
	}

	public void setHzCommentLevelM(int hzCommentLevelM) {
		this.hzCommentLevelM = hzCommentLevelM;
	}

	public HelpZoneCommentMember(int hzCommentNumM, int hzNumM, int hzCommentWriterNumM, String hzCommentContentM,
			Date hzCommentDateM, int hzCommentLevelM) {
		super();
		this.hzCommentNumM = hzCommentNumM;
		this.hzNumM = hzNumM;
		this.hzCommentWriterNumM = hzCommentWriterNumM;
		this.hzCommentContentM = hzCommentContentM;
		this.hzCommentDateM = hzCommentDateM;
		this.hzCommentLevelM = hzCommentLevelM;
	}

	@Override
	public String toString() {
		return "HelpZoneCommentMember [hzCommentNumM=" + hzCommentNumM + ", hzNumM=" + hzNumM + ", hzCommentWriterNumM="
				+ hzCommentWriterNumM + ", hzCommentContentM=" + hzCommentContentM + ", hzCommentDateM="
				+ hzCommentDateM + ", hzCommentLevelM=" + hzCommentLevelM + "]";
	}
	
	
	
}