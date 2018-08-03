package com.medi.pot.notice.vo;

import java.sql.Date;

public class MemberNotice {
	private int memberNoticeNum;
	private String memberNoticeTitle;
	private String memberNoticeWriter;
	private String memberNoticeContent;
	private String memberNoticeFile;
	private String memberNoticeRefile;
	private int memberNoticeReadcount;
	private Date memberNoticeDate;
	
	public MemberNotice() {}

	public MemberNotice(int memberNoticeNum, String memberNoticeTitle, String memberNoticeWriter,
			String memberNoticeContent, String memberNoticeFile, String memberNoticeRefile, int memberNoticeReadcount,
			Date memberNoticeDate) {
		super();
		this.memberNoticeNum = memberNoticeNum;
		this.memberNoticeTitle = memberNoticeTitle;
		this.memberNoticeWriter = memberNoticeWriter;
		this.memberNoticeContent = memberNoticeContent;
		this.memberNoticeFile = memberNoticeFile;
		this.memberNoticeRefile = memberNoticeRefile;
		this.memberNoticeReadcount = memberNoticeReadcount;
		this.memberNoticeDate = memberNoticeDate;
	}

	public int getMemberNoticeNum() {
		return memberNoticeNum;
	}

	public void setMemberNoticeNum(int memberNoticeNum) {
		this.memberNoticeNum = memberNoticeNum;
	}

	public String getMemberNoticeTitle() {
		return memberNoticeTitle;
	}

	public void setMemberNoticeTitle(String memberNoticeTitle) {
		this.memberNoticeTitle = memberNoticeTitle;
	}

	public String getMemberNoticeWriter() {
		return memberNoticeWriter;
	}

	public void setMemberNoticeWriter(String memberNoticeWriter) {
		this.memberNoticeWriter = memberNoticeWriter;
	}

	public String getMemberNoticeContent() {
		return memberNoticeContent;
	}

	public void setMemberNoticeContent(String memberNoticeContent) {
		this.memberNoticeContent = memberNoticeContent;
	}

	public String getMemberNoticeFile() {
		return memberNoticeFile;
	}

	public void setMemberNoticeFile(String memberNoticeFile) {
		this.memberNoticeFile = memberNoticeFile;
	}

	public String getMemberNoticeRefile() {
		return memberNoticeRefile;
	}

	public void setMemberNoticeRefile(String memberNoticeRefile) {
		this.memberNoticeRefile = memberNoticeRefile;
	}

	public int getMemberNoticeReadcount() {
		return memberNoticeReadcount;
	}

	public void setMemberNoticeReadcount(int memberNoticeReadcount) {
		this.memberNoticeReadcount = memberNoticeReadcount;
	}

	public Date getMemberNoticeDate() {
		return memberNoticeDate;
	}

	public void setMemberNoticeDate(Date memberNoticeDate) {
		this.memberNoticeDate = memberNoticeDate;
	}

	@Override
	public String toString() {
		return "MemberNotice [memberNoticeNum=" + memberNoticeNum + ", memberNoticeTitle=" + memberNoticeTitle
				+ ", memberNoticeWriter=" + memberNoticeWriter + ", memberNoticeContent=" + memberNoticeContent
				+ ", memberNoticeFile=" + memberNoticeFile + ", memberNoticeRefile=" + memberNoticeRefile
				+ ", memberNoticeReadcount=" + memberNoticeReadcount + ", memberNoticeDate=" + memberNoticeDate + "]";
	}

}
