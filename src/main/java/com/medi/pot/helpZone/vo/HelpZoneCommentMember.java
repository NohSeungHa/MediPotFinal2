package com.medi.pot.helpZone.vo;

import java.util.Date;
//일반회원 댓글 vo
public class HelpZoneCommentMember {
	private int hzCommentM;				//댓글 번호
	private int hzNumM;					//헬프존 글번호
	private int hzCommentWriterNumM;	//작성자 번호
	private String hzCommentContentM;	//댓글 내용
	private Date hzCommentDateM;		//댓글 날짜
	private int hzCommentLevelM;		//댓글레벨
	
	public HelpZoneCommentMember() {
		// TODO Auto-generated constructor stub
	}
	
	public HelpZoneCommentMember(int hzCommentM, int hzNumM, int hzCommentWriterNumM, String hzCommentContentM,
			Date hzCommentDateM, int hzCommentLevelM) {
		super();
		this.hzCommentM = hzCommentM;
		this.hzNumM = hzNumM;
		this.hzCommentWriterNumM = hzCommentWriterNumM;
		this.hzCommentContentM = hzCommentContentM;
		this.hzCommentDateM = hzCommentDateM;
		this.hzCommentLevelM = hzCommentLevelM;
	}

	public int getHzCommentM() {
		return hzCommentM;
	}

	public void setHzCommentM(int hzCommentM) {
		this.hzCommentM = hzCommentM;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HelpZoneCommentMember [hzCommentM=").append(hzCommentM).append(", hzNumM=").append(hzNumM)
				.append(", hzCommentWriterNumM=").append(hzCommentWriterNumM).append(", hzCommentContentM=")
				.append(hzCommentContentM).append(", hzCommentDateM=").append(hzCommentDateM)
				.append(", hzCommentLevelM=").append(hzCommentLevelM).append("]");
		return builder.toString();
	}
	
	
	
	
	
}
