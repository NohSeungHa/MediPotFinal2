package com.medi.pot.member.model.vo;

import java.sql.Date;

public class Hospital {
	
	private int hospitalNum;
	private String hospitalId;
	private String hospitalPw;
	private String hospitalName;
	private String hospitalLicense;
	private String hospitalReLicense;
	private String hospitalTel;
	private String hospitalEmail;
	private String hospitalAddr;
	private Date hospitalDate;
	private int hospitalLike;
	private String hospitalAdmission;
	private String hospitalProfessional;
	
	public Hospital() {}

	public int getHospitalNum() {
		return hospitalNum;
	}

	public void setHospitalNum(int hospitalNum) {
		this.hospitalNum = hospitalNum;
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

	public String getHospitalReLicense() {
		return hospitalReLicense;
	}

	public void setHospitalReLicense(String hospitalReLicense) {
		this.hospitalReLicense = hospitalReLicense;
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

	public Date getHospitalDate() {
		return hospitalDate;
	}

	public void setHospitalDate(Date hospitalDate) {
		this.hospitalDate = hospitalDate;
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

	public String getHospitalProfessional() {
		return hospitalProfessional;
	}

	public void setHospitalProfessional(String hospitalProfessional) {
		this.hospitalProfessional = hospitalProfessional;
	}

	public Hospital(int hospitalNum, String hospitalId, String hospitalPw, String hospitalName, String hospitalLicense,
			String hospitalReLicense, String hospitalTel, String hospitalEmail, String hospitalAddr, Date hospitalDate,
			int hospitalLike, String hospitalAdmission, String hospitalProfessional) {
		super();
		this.hospitalNum = hospitalNum;
		this.hospitalId = hospitalId;
		this.hospitalPw = hospitalPw;
		this.hospitalName = hospitalName;
		this.hospitalLicense = hospitalLicense;
		this.hospitalReLicense = hospitalReLicense;
		this.hospitalTel = hospitalTel;
		this.hospitalEmail = hospitalEmail;
		this.hospitalAddr = hospitalAddr;
		this.hospitalDate = hospitalDate;
		this.hospitalLike = hospitalLike;
		this.hospitalAdmission = hospitalAdmission;
		this.hospitalProfessional = hospitalProfessional;
	}

	@Override
	public String toString() {
		return "Hospital [hospitalNum=" + hospitalNum + ", hospitalId=" + hospitalId + ", hospitalPw=" + hospitalPw
				+ ", hospitalName=" + hospitalName + ", hospitalLicense=" + hospitalLicense + ", hospitalReLicense="
				+ hospitalReLicense + ", hospitalTel=" + hospitalTel + ", hospitalEmail=" + hospitalEmail
				+ ", hospitalAddr=" + hospitalAddr + ", hospitalDate=" + hospitalDate + ", hospitalLike=" + hospitalLike
				+ ", hospitalAdmission=" + hospitalAdmission + ", hospitalProfessional=" + hospitalProfessional + "]";
	}

	

}
