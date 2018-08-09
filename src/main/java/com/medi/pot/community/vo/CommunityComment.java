package com.medi.pot.community.vo;

import java.sql.Date;

public class CommunityComment {
	
	private int commentNum; //댓글 번호
	private int commentNo;  //댓글의 게시판 번호
	private String commentWriter; //댓글의 작성자
	private String commentContent; //댓글 내용
	private Date commentDate; //댓글의 날짜
	
	public CommunityComment() {}

	public CommunityComment(int commentNum, int commentNo, String commentWriter, String commentContent,
			Date commentDate) {
		super();
		this.commentNum = commentNum;
		this.commentNo = commentNo;
		this.commentWriter = commentWriter;
		this.commentContent = commentContent;
		this.commentDate = commentDate;
	}

	public int getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public String getCommentWriter() {
		return commentWriter;
	}

	public void setCommentWriter(String commentWriter) {
		this.commentWriter = commentWriter;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	@Override
	public String toString() {
		return "CommunityComment [commentNum=" + commentNum + ", commentNo=" + commentNo + ", commentWriter="
				+ commentWriter + ", commentContent=" + commentContent + ", commentDate=" + commentDate + "]";
	}

	
	
}