package com.medi.pot.reservation.model.vo;

public class MemberReservation {
	private int checkNum;
	private int checkDoctor;
	private int checkHospital;
	private int checkMember;
	private String checkDate;
	private String checkTime;
	private int blockDoctor;
	private int blockHosplital;
	private String blockDate;
	private String blockTime;
	private String blockCheck;
	private String memberName;
	private int memberNum;
	
	public MemberReservation() {
		// TODO Auto-generated constructor stub
	}

	public MemberReservation(int checkNum, int checkDoctor, int checkHospital, int checkMember, String checkDate,
			String checkTime, int blockDoctor, int blockHosplital, String blockDate, String blockTime,
			String blockCheck, String memberName, int memberNum) {
		super();
		this.checkNum = checkNum;
		this.checkDoctor = checkDoctor;
		this.checkHospital = checkHospital;
		this.checkMember = checkMember;
		this.checkDate = checkDate;
		this.checkTime = checkTime;
		this.blockDoctor = blockDoctor;
		this.blockHosplital = blockHosplital;
		this.blockDate = blockDate;
		this.blockTime = blockTime;
		this.blockCheck = blockCheck;
		this.memberName = memberName;
		this.memberNum = memberNum;
	}

	@Override
	public String toString() {
		return "MemberReservation [checkNum=" + checkNum + ", checkDoctor=" + checkDoctor + ", checkHospital="
				+ checkHospital + ", checkMember=" + checkMember + ", checkDate=" + checkDate + ", checkTime="
				+ checkTime + ", blockDoctor=" + blockDoctor + ", blockHosplital=" + blockHosplital + ", blockDate="
				+ blockDate + ", blockTime=" + blockTime + ", blockCheck=" + blockCheck + ", memberName=" + memberName
				+ ", memberNum=" + memberNum + "]";
	}

	public int getCheckNum() {
		return checkNum;
	}

	public void setCheckNum(int checkNum) {
		this.checkNum = checkNum;
	}

	public int getCheckDoctor() {
		return checkDoctor;
	}

	public void setCheckDoctor(int checkDoctor) {
		this.checkDoctor = checkDoctor;
	}

	public int getCheckHospital() {
		return checkHospital;
	}

	public void setCheckHospital(int checkHospital) {
		this.checkHospital = checkHospital;
	}

	public int getCheckMember() {
		return checkMember;
	}

	public void setCheckMember(int checkMember) {
		this.checkMember = checkMember;
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

	public int getBlockDoctor() {
		return blockDoctor;
	}

	public void setBlockDoctor(int blockDoctor) {
		this.blockDoctor = blockDoctor;
	}

	public int getBlockHosplital() {
		return blockHosplital;
	}

	public void setBlockHosplital(int blockHosplital) {
		this.blockHosplital = blockHosplital;
	}

	public String getBlockDate() {
		return blockDate;
	}

	public void setBlockDate(String blockDate) {
		this.blockDate = blockDate;
	}

	public String getBlockTime() {
		return blockTime;
	}

	public void setBlockTime(String blockTime) {
		this.blockTime = blockTime;
	}

	public String getBlockCheck() {
		return blockCheck;
	}

	public void setBlockCheck(String blockCheck) {
		this.blockCheck = blockCheck;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	
	
	
	

}
