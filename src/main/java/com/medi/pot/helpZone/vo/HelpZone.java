package com.medi.pot.helpZone.vo;

import java.util.Date;

public class HelpZone {
	private int helpZoneQuestioner;	//회원 번호
	private int helpZoneNum;		//헬프존 글 번호
	private String helpZoneTitle;	//헬프존 제목
	private String helpZoneContent;	//내용
	private String helpZoneFile;	//업로드 파일
	private String helpZoneRefile;	//재업로드 파일
	private int helpZoneReadCount;	//조회수
	private Date helpZoneDate;		//작성날짜
	private int helpZoneLikeNum;	//좋아요 개수
	private String helpZoneKeyWord;	//질문글 키워드
	
	public HelpZone() {
		// TODO Auto-generated constructor stub
	}
	
	

	public HelpZone(int helpZoneQuestioner, int helpZoneNum, String helpZoneTitle, String helpZoneContent,
			String helpZoneFile, String helpZoneRefile, int helpZoneReadCount, Date helpZoneDate, int helpZoneLikeNum,
			String helpZoneKeyWord) {
		super();
		this.helpZoneQuestioner = helpZoneQuestioner;
		this.helpZoneNum = helpZoneNum;
		this.helpZoneTitle = helpZoneTitle;
		this.helpZoneContent = helpZoneContent;
		this.helpZoneFile = helpZoneFile;
		this.helpZoneRefile = helpZoneRefile;
		this.helpZoneReadCount = helpZoneReadCount;
		this.helpZoneDate = helpZoneDate;
		this.helpZoneLikeNum = helpZoneLikeNum;
		this.helpZoneKeyWord = helpZoneKeyWord;
	}



	public int getHelpZoneQuestioner() {
		return helpZoneQuestioner;
	}



	public void setHelpZoneQuestioner(int helpZoneQuestioner) {
		this.helpZoneQuestioner = helpZoneQuestioner;
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



	public String getHelpZoneRefile() {
		return helpZoneRefile;
	}



	public void setHelpZoneRefile(String helpZoneRefile) {
		this.helpZoneRefile = helpZoneRefile;
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



	public int getHelpZoneLikeNum() {
		return helpZoneLikeNum;
	}



	public void setHelpZoneLikeNum(int helpZoneLikeNum) {
		this.helpZoneLikeNum = helpZoneLikeNum;
	}



	public String getHelpZoneKeyWord() {
		return helpZoneKeyWord;
	}



	public void setHelpZoneKeyWord(String helpZoneKeyWord) {
		this.helpZoneKeyWord = helpZoneKeyWord;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HelpZone [helpZoneQuestioner=").append(helpZoneQuestioner).append(", helpZoneNum=")
				.append(helpZoneNum).append(", helpZoneTitle=").append(helpZoneTitle).append(", helpZoneContent=")
				.append(helpZoneContent).append(", helpZoneFile=").append(helpZoneFile).append(", helpZoneRefile=")
				.append(helpZoneRefile).append(", helpZoneReadCount=").append(helpZoneReadCount)
				.append(", helpZoneDate=").append(helpZoneDate).append(", helpZoneLikeNum=").append(helpZoneLikeNum)
				.append(", helpZoneKeyWord=").append(helpZoneKeyWord).append("]");
		return builder.toString();
	}
	
	
	
}
