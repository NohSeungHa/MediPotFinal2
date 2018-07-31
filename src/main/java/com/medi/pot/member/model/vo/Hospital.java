package com.medi.pot.member.model.vo;

import java.sql.Date;

public class Hospital {
	
	private int hospitalNo;
	private String hospitalId;
	private String hospitalPw;
	private String hospitalName;
	private String hospitalLicense;
	private String hospitalTel;
	private String hospitalEmail;
	private String hospitalAddr;
	private Date memberDate;
	private int hospitalLike;
	private String hospitalAdmission;
	
	public Hospital() {}

	public int getHospitalNo() {
		return hospitalNo;
	}

	public void setHospitalNo(int hospitalNo) {
		this.hospitalNo = hospitalNo;
	}

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

	public int getHospitalLike() {
		return hospitalLike;
	}

	public void setHospitalLike(int hospitalLike) {
		this.hospitalLike = hospitalLike;
	}

	public String getHospitalAdmission() {
		return hospitalAdmission;
	}

	public void setHospitalAdmission(String hospitalAdmission) {
		this.hospitalAdmission = hospitalAdmission;
	}

	@Override
	public String toString() {
		return "Hospital [hospitalNo=" + hospitalNo + ", hospitalId=" + hospitalId + ", hospitalPw=" + hospitalPw
				+ ", hospitalName=" + hospitalName + ", hospitalLicense=" + hospitalLicense + ", hospitalTel="
				+ hospitalTel + ", hospitalEmail=" + hospitalEmail + ", hospitalAddr=" + hospitalAddr + ", memberDate="
				+ memberDate + ", hospitalLike=" + hospitalLike + ", hospitalAdmission=" + hospitalAdmission + "]";
	}

	public Hospital(int hospitalNo, String hospitalId, String hospitalPw, String hospitalName, String hospitalLicense,
			String hospitalTel, String hospitalEmail, String hospitalAddr, Date memberDate, int hospitalLike,
			String hospitalAdmission) {
		super();
		this.hospitalNo = hospitalNo;
		this.hospitalId = hospitalId;
		this.hospitalPw = hospitalPw;
		this.hospitalName = hospitalName;
		this.hospitalLicense = hospitalLicense;
		this.hospitalTel = hospitalTel;
		this.hospitalEmail = hospitalEmail;
		this.hospitalAddr = hospitalAddr;
		this.memberDate = memberDate;
		this.hospitalLike = hospitalLike;
		this.hospitalAdmission = hospitalAdmission;
	}

}
