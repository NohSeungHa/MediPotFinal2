package com.medi.pot.helpZone.vo;

import java.util.Date;

public class HelpZone {
	int helpZoneNum;				//헬프존 번호
	String helpZoneTitle;			//제목
	int helpZoneQuestioner;			//질문자 회원 번호
	String helpZoneKeyWord;			//키워드
	String helpZoneContent;			//내용
	String helpZoneFile;			//파일 이름
	String helpZoneReFile;			//새로운 파일 이름
	int helpZoneReadCount;			//조회수
	Date helpZoneDate;				//작성 날짜
	
	public HelpZone() {
	}

	public HelpZone(int helpZoneNum, String helpZoneTitle, int helpZoneQuestioner, String helpZoneKeyWord,
			String helpZoneContent, String helpZoneFile, String helpZoneReFile, int helpZoneReadCount,
			Date helpZoneDate) {
		super();
		this.helpZoneNum = helpZoneNum;
		this.helpZoneTitle = helpZoneTitle;
		this.helpZoneQuestioner = helpZoneQuestioner;
		this.helpZoneKeyWord = helpZoneKeyWord;
		this.helpZoneContent = helpZoneContent;
		this.helpZoneFile = helpZoneFile;
		this.helpZoneReFile = helpZoneReFile;
		this.helpZoneReadCount = helpZoneReadCount;
		this.helpZoneDate = helpZoneDate;
	}

	public int getHelpZoneNum() {
		return helpZoneNum;
	}

	public void setHelpZoneNum(int helpZoneNum) {
		this.helpZoneNum = helpZoneNum;
	}

	public String getHelpZoneTitle() {
		return helpZoneTitle;
	}

	public void setHelpZoneTitle(String helpZoneTitle) {
		this.helpZoneTitle = helpZoneTitle;
	}

	public int getHelpZoneQuestioner() {
		return helpZoneQuestioner;
	}

	public void setHelpZoneQuestioner(int helpZoneQuestioner) {
		this.helpZoneQuestioner = helpZoneQuestioner;
	}

	public String getHelpZoneKeyWord() {
		return helpZoneKeyWord;
	}

	public void setHelpZoneKeyWord(String helpZoneKeyWord) {
		this.helpZoneKeyWord = helpZoneKeyWord;
	}

	public String getHelpZoneContent() {
		return helpZoneContent;
	}

	public void setHelpZoneContent(String helpZoneContent) {
		this.helpZoneContent = helpZoneContent;
	}

	public String getHelpZoneFile() {
		return helpZoneFile;
	}

	public void setHelpZoneFile(String helpZoneFile) {
		this.helpZoneFile = helpZoneFile;
	}

	public String getHelpZoneReFile() {
		return helpZoneReFile;
	}

	public void setHelpZoneReFile(String helpZoneReFile) {
		this.helpZoneReFile = helpZoneReFile;
	}

	public int getHelpZoneReadCount() {
		return helpZoneReadCount;
	}

	public void setHelpZoneReadCount(int helpZoneReadCount) {
		this.helpZoneReadCount = helpZoneReadCount;
	}

	public Date getHelpZoneDate() {
		return helpZoneDate;
	}

	public void setHelpZoneDate(Date helpZoneDate) {
		this.helpZoneDate = helpZoneDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HelpZone [helpZoneNum=").append(helpZoneNum).append(", helpZoneTitle=").append(helpZoneTitle)
				.append(", helpZoneQuestioner=").append(helpZoneQuestioner).append(", helpZoneKeyWord=")
				.append(helpZoneKeyWord).append(", helpZoneContent=").append(helpZoneContent).append(", helpZoneFile=")
				.append(helpZoneFile).append(", helpZoneReFile=").append(helpZoneReFile).append(", helpZoneReadCount=")
				.append(helpZoneReadCount).append(", helpZoneDate=").append(helpZoneDate).append(", helpZoneLikeNum=")
				.append("]");
		return builder.toString();
	}
	
	
}
