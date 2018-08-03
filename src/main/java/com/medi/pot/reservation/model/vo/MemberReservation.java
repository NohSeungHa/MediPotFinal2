package com.medi.pot.reservation.model.vo;

public class MemberReservation {
	private int checkNum;
	private int checkDoctor;
	private int checkHospital;
	private int checkMember;
	private String checkDate;
	private String checkTime;
	
	public MemberReservation() {
		// TODO Auto-generated constructor stub
	}

	public MemberReservation(int checkNum, int checkDoctor, int checkHospital, int checkMember, String checkDate,
			String checkTime) {
		super();
		this.checkNum = checkNum;
		this.checkDoctor = checkDoctor;
		this.checkHospital = checkHospital;
		this.checkMember = checkMember;
		this.checkDate = checkDate;
		this.checkTime = checkTime;
	}

	@Override
	public String toString() {
		return "MemberReservation [checkNum=" + checkNum + ", checkDoctor=" + checkDoctor + ", checkHospital="
				+ checkHospital + ", checkMember=" + checkMember + ", checkDate=" + checkDate + ", checkTime="
				+ checkTime + "]";
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
	
	
	

}
