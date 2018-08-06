package com.medi.pot.community.vo;

import java.sql.Date;

public class Community {
	
	private int communityNum;
	private String communityTitle;
	private String communityWriter;
	private String communityCheckPH;
	private String communityContent;
	private String communityFile;
	private String communityRefile;
	private int communityReadcount;
	private Date communityDate;
	
	public Community() {}

	public Community(int communityNum, String communityTitle, String communityWriter, String communityCheckPH,
			String communityContent, String communityFile, String communityRefile, int communityReadcount,
			Date communityDate) {
		super();
		this.communityNum = communityNum;
		this.communityTitle = communityTitle;
		this.communityWriter = communityWriter;
		this.communityCheckPH = communityCheckPH;
		this.communityContent = communityContent;
		this.communityFile = communityFile;
		this.communityRefile = communityRefile;
		this.communityReadcount = communityReadcount;
		this.communityDate = communityDate;
	}

	public int getCommunityNum() {
		return communityNum;
	}

	public void setCommunityNum(int communityNum) {
		this.communityNum = communityNum;
	}

	public String getCommunityTitle() {
		return communityTitle;
	}

	public void setCommunityTitle(String communityTitle) {
		this.communityTitle = communityTitle;
	}

	public String getCommunityWriter() {
		return communityWriter;
	}

	public void setCommunityWriter(String communityWriter) {
		this.communityWriter = communityWriter;
	}

	public String getCommunityCheckPH() {
		return communityCheckPH;
	}

	public void setCommunityCheckPH(String communityCheckPH) {
		this.communityCheckPH = communityCheckPH;
	}

	public String getCommunityContent() {
		return communityContent;
	}

	public void setCommunityContent(String communityContent) {
		this.communityContent = communityContent;
	}

	public String getCommunityFile() {
		return communityFile;
	}

	public void setCommunityFile(String communityFile) {
		this.communityFile = communityFile;
	}

	public String getCommunityRefile() {
		return communityRefile;
	}

	public void setCommunityRefile(String communityRefile) {
		this.communityRefile = communityRefile;
	}

	public int getCommunityReadcount() {
		return communityReadcount;
	}

	public void setCommunityReadcount(int communityReadcount) {
		this.communityReadcount = communityReadcount;
	}

	public Date getCommunityDate() {
		return communityDate;
	}

	public void setCommunityDate(Date communityDate) {
		this.communityDate = communityDate;
	}

	@Override
	public String toString() {
		return "Community [communityNum=" + communityNum + ", communityTitle=" + communityTitle + ", communityWriter="
				+ communityWriter + ", communityCheckPH=" + communityCheckPH + ", communityContent=" + communityContent
				+ ", communityFile=" + communityFile + ", communityRefile=" + communityRefile + ", communityReadcount="
				+ communityReadcount + ", communityDate=" + communityDate + "]";
	}

	
}
