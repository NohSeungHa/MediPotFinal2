package com.medi.pot.notice.vo;

import java.sql.Date;

public class HospitalNotice {
	private int hospitalNoticeNum;
	private String hospitalNoticeTitle;
	private String hospitalNoticeWriter;
	private String hospitalNoticeContent;
	private String hospitalNoticeFile;
	private String hospitalNoticeRefile;
	private int hospitalNoticeReadcount;
	private Date hospitalNoticeDate;
	
	public HospitalNotice() {}

	public HospitalNotice(int hospitalNoticeNum, String hospitalNoticeTitle, String hospitalNoticeWriter,
			String hospitalNoticeContent, String hospitalNoticeFile, String hospitalNoticeRefile,
			int hospitalNoticeReadcount, Date hospitalNoticeDate) {
		super();
		this.hospitalNoticeNum = hospitalNoticeNum;
		this.hospitalNoticeTitle = hospitalNoticeTitle;
		this.hospitalNoticeWriter = hospitalNoticeWriter;
		this.hospitalNoticeContent = hospitalNoticeContent;
		this.hospitalNoticeFile = hospitalNoticeFile;
		this.hospitalNoticeRefile = hospitalNoticeRefile;
		this.hospitalNoticeReadcount = hospitalNoticeReadcount;
		this.hospitalNoticeDate = hospitalNoticeDate;
	}

	public int getHospitalNoticeNum() {
		return hospitalNoticeNum;
	}

	public void setHospitalNoticeNum(int hospitalNoticeNum) {
		this.hospitalNoticeNum = hospitalNoticeNum;
	}

	public String getHospitalNoticeTitle() {
		return hospitalNoticeTitle;
	}

	public void setHospitalNoticeTitle(String hospitalNoticeTitle) {
		this.hospitalNoticeTitle = hospitalNoticeTitle;
	}

	public String getHospitalNoticeWriter() {
		return hospitalNoticeWriter;
	}

	public void setHospitalNoticeWriter(String hospitalNoticeWriter) {
		this.hospitalNoticeWriter = hospitalNoticeWriter;
	}

	public String getHospitalNoticeContent() {
		return hospitalNoticeContent;
	}

	public void setHospitalNoticeContent(String hospitalNoticeContent) {
		this.hospitalNoticeContent = hospitalNoticeContent;
	}

	public String getHospitalNoticeFile() {
		return hospitalNoticeFile;
	}

	public void setHospitalNoticeFile(String hospitalNoticeFile) {
		this.hospitalNoticeFile = hospitalNoticeFile;
	}

	public String getHospitalNoticeRefile() {
		return hospitalNoticeRefile;
	}

	public void setHospitalNoticeRefile(String hospitalNoticeRefile) {
		this.hospitalNoticeRefile = hospitalNoticeRefile;
	}

	public int getHospitalNoticeReadcount() {
		return hospitalNoticeReadcount;
	}

	public void setHospitalNoticeReadcount(int hospitalNoticeReadcount) {
		this.hospitalNoticeReadcount = hospitalNoticeReadcount;
	}

	public Date getHospitalNoticeDate() {
		return hospitalNoticeDate;
	}

	public void setHospitalNoticeDate(Date hospitalNoticeDate) {
		this.hospitalNoticeDate = hospitalNoticeDate;
	}

	@Override
	public String toString() {
		return "HospitalNotice [hospitalNoticeNum=" + hospitalNoticeNum + ", hospitalNoticeTitle=" + hospitalNoticeTitle
				+ ", hospitalNoticeWriter=" + hospitalNoticeWriter + ", hospitalNoticeContent=" + hospitalNoticeContent
				+ ", hospitalNoticeFile=" + hospitalNoticeFile + ", hospitalNoticeRefile=" + hospitalNoticeRefile
				+ ", hospitalNoticeReadcount=" + hospitalNoticeReadcount + ", hospitalNoticeDate=" + hospitalNoticeDate
				+ "]";
	}

	

}
