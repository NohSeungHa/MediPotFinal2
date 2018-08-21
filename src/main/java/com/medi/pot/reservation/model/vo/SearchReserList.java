package com.medi.pot.reservation.model.vo;

public class SearchReserList {
	private int checkNum;
	private int doctorNum;
	private String doctorName;
	private String memberName;
	private String memberGender;
	private String memberBirth;
	private String memberPhone;
	private String memberAddr;
	private String sendMsg;
	private String checkDate;
	private String checkTime;
	
	public SearchReserList() {
		// TODO Auto-generated constructor stub
	}

	public SearchReserList(int checkNum, int doctorNum, String doctorName, String memberName, String memberGender,
			String memberBirth, String memberPhone, String memberAddr, String sendMsg, String checkDate,
			String checkTime) {
		super();
		this.checkNum = checkNum;
		this.doctorNum = doctorNum;
		this.doctorName = doctorName;
		this.memberName = memberName;
		this.memberGender = memberGender;
		this.memberBirth = memberBirth;
		this.memberPhone = memberPhone;
		this.memberAddr = memberAddr;
		this.sendMsg = sendMsg;
		this.checkDate = checkDate;
		this.checkTime = checkTime;
	}

	@Override
	public String toString() {
		return "SearchReserList [checkNum=" + checkNum + ", doctorNum=" + doctorNum + ", doctorName=" + doctorName
				+ ", memberName=" + memberName + ", memberGender=" + memberGender + ", memberBirth=" + memberBirth
				+ ", memberPhone=" + memberPhone + ", memberAddr=" + memberAddr + ", sendMsg=" + sendMsg
				+ ", checkDate=" + checkDate + ", checkTime=" + checkTime + "]";
	}

	public int getCheckNum() {
		return checkNum;
	}

	public void setCheckNum(int checkNum) {
		this.checkNum = checkNum;
	}

	public int getDoctorNum() {
		return doctorNum;
	}

	public void setDoctorNum(int doctorNum) {
		this.doctorNum = doctorNum;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public String getMemberBirth() {
		return memberBirth;
	}

	public void setMemberBirth(String memberBirth) {
		this.memberBirth = memberBirth;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberAddr() {
		return memberAddr;
	}

	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}

	public String getSendMsg() {
		return sendMsg;
	}

	public void setSendMsg(String sendMsg) {
		this.sendMsg = sendMsg;
	}

	public String getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}

	public String getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}

	
	
}
