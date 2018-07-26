package com.medi.pot.member.model.vo;

import java.sql.Date;

public class Hospital {
	
	private String hospitalId;
	private String hospitalPw;
	private String hospitalName;
	private String hospitalLicense;
	private String hospitalTel;
	private String hospitalEmail;
	private String hospitalAddr;
	private Date memberDate;
	private int timeInterval;
	
	
	public String getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getHospitalPw() {
		return hospitalPw;
	}
	public void setHospitalPw(String hospitalPw) {
		this.hospitalPw = hospitalPw;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getHospitalLicense() {
		return hospitalLicense;
	}
	public void setHospitalLicense(String hospitalLicense) {
		this.hospitalLicense = hospitalLicense;
	}
	public String getHospitalTel() {
		return hospitalTel;
	}
	public void setHospitalTel(String hospitalTel) {
		this.hospitalTel = hospitalTel;
	}
	public String getHospitalEmail() {
		return hospitalEmail;
	}
	public void setHospitalEmail(String hospitalEmail) {
		this.hospitalEmail = hospitalEmail;
	}
	public String getHospitalAddr() {
		return hospitalAddr;
	}
	public void setHospitalAddr(String hospitalAddr) {
		this.hospitalAddr = hospitalAddr;
	}
	public Date getMemberDate() {
		return memberDate;
	}
	public void setMemberDate(Date memberDate) {
		this.memberDate = memberDate;
	}
	public int getTimeInterval() {
		return timeInterval;
	}
	public void setTimeInterval(int timeInterval) {
		this.timeInterval = timeInterval;
	}
	
	public Hospital() {}
	
	public Hospital(String hospitalId, String hospitalPw, String hospitalName, String hospitalLicense,
			String hospitalTel, String hospitalEmail, String hospitalAddr, Date memberDate, int timeInterval) {
		super();
		this.hospitalId = hospitalId;
		this.hospitalPw = hospitalPw;
		this.hospitalName = hospitalName;
		this.hospitalLicense = hospitalLicense;
		this.hospitalTel = hospitalTel;
		this.hospitalEmail = hospitalEmail;
		this.hospitalAddr = hospitalAddr;
		this.memberDate = memberDate;
		this.timeInterval = timeInterval;
	}
	@Override
	public String toString() {
		return "Hospital [hospitalId=" + hospitalId + ", hospitalPw=" + hospitalPw + ", hospitalName=" + hospitalName
				+ ", hospitalLicense=" + hospitalLicense + ", hospitalTel=" + hospitalTel + ", hospitalEmail="
				+ hospitalEmail + ", hospitalAddr=" + hospitalAddr + ", memberDate=" + memberDate + ", timeInterval="
				+ timeInterval + "]";
	}
	
}
