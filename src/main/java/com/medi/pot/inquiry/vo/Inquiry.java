package com.medi.pot.inquiry.vo;

import java.sql.Date;

public class Inquiry {
	private int inquiryNum;
	private String inquiryTitle;
	private String inquiryWriter;
	private String InquiryCheckPH;
	private String inquiryContent;
	private String inquiryAnswer;
	private String inquiryAnswerCheck;
	private Date inquiryDate;
	
	public Inquiry() {}

	public Inquiry(int inquiryNum, String inquiryTitle, String inquiryWriter, String inquiryCheckPH,
			String inquiryContent, String inquiryAnswer, String inquiryAnswerCheck, Date inquiryDate) {
		super();
		this.inquiryNum = inquiryNum;
		this.inquiryTitle = inquiryTitle;
		this.inquiryWriter = inquiryWriter;
		InquiryCheckPH = inquiryCheckPH;
		this.inquiryContent = inquiryContent;
		this.inquiryAnswer = inquiryAnswer;
		this.inquiryAnswerCheck = inquiryAnswerCheck;
		this.inquiryDate = inquiryDate;
	}

	public int getInquiryNum() {
		return inquiryNum;
	}

	public void setInquiryNum(int inquiryNum) {
		this.inquiryNum = inquiryNum;
	}

	public String getInquiryTitle() {
		return inquiryTitle;
	}

	public void setInquiryTitle(String inquiryTitle) {
		this.inquiryTitle = inquiryTitle;
	}

	public String getInquiryWriter() {
		return inquiryWriter;
	}

	public void setInquiryWriter(String inquiryWriter) {
		this.inquiryWriter = inquiryWriter;
	}

	public String getInquiryCheckPH() {
		return InquiryCheckPH;
	}

	public void setInquiryCheckPH(String inquiryCheckPH) {
		InquiryCheckPH = inquiryCheckPH;
	}

	public String getInquiryContent() {
		return inquiryContent;
	}

	public void setInquiryContent(String inquiryContent) {
		this.inquiryContent = inquiryContent;
	}

	public String getInquiryAnswer() {
		return inquiryAnswer;
	}

	public void setInquiryAnswer(String inquiryAnswer) {
		this.inquiryAnswer = inquiryAnswer;
	}

	public String getInquiryAnswerCheck() {
		return inquiryAnswerCheck;
	}

	public void setInquiryAnswerCheck(String inquiryAnswerCheck) {
		this.inquiryAnswerCheck = inquiryAnswerCheck;
	}

	public Date getInquiryDate() {
		return inquiryDate;
	}

	public void setInquiryDate(Date inquiryDate) {
		this.inquiryDate = inquiryDate;
	}

	@Override
	public String toString() {
		return "Inquiry [inquiryNum=" + inquiryNum + ", inquiryTitle=" + inquiryTitle + ", inquiryWriter="
				+ inquiryWriter + ", InquiryCheckPH=" + InquiryCheckPH + ", inquiryContent=" + inquiryContent
				+ ", inquiryAnswer=" + inquiryAnswer + ", inquiryAnswerCheck=" + inquiryAnswerCheck + ", inquiryDate="
				+ inquiryDate + "]";
	}

}