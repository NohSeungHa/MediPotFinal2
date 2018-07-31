package com.medi.pot.reservation.model.vo;

import java.sql.Date;

public class HospitalInfo {
	private int hospitalNum;
	private String hospitalId;
	private String hospitalPw;
	private String hospitalName;
	private String hospitalLicense;
	private String hospitalTel;
	private String hospitalEmail;
	private String hospitalAddr;
	private Date hospitalDate;
	private int timeInterval;
	private int hospitalLike;
	private String hospitalProfessional;
	private int hospitalInfoNum;
	private String hospitalInfoIntro;
	private String hospitalInfoNotice;
	private String hospitalPhoto;
	private String hospitalInfoUsetime;
	private String hospitalInfoLunchtime;
	
	public HospitalInfo() {
		// TODO Auto-generated constructor stub
	}

	public HospitalInfo(int hospitalNum, String hospitalId, String hospitalPw, String hospitalName,
			String hospitalLicense, String hospitalTel, String hospitalEmail, String hospitalAddr, Date hospitalDate,
			int timeInterval, int hospitalLike, String hospitalProfessional, int hospitalInfoNum,
			String hospitalInfoIntro, String hospitalInfoNotice, String hospitalPhoto, String hospitalInfoUsetime,
			String hospitalInfoLunchtime) {
		super();
		this.hospitalNum = hospitalNum;
		this.hospitalId = hospitalId;
		this.hospitalPw = hospitalPw;
		this.hospitalName = hospitalName;
		this.hospitalLicense = hospitalLicense;
		this.hospitalTel = hospitalTel;
		this.hospitalEmail = hospitalEmail;
		this.hospitalAddr = hospitalAddr;
		this.hospitalDate = hospitalDate;
		this.timeInterval = timeInterval;
		this.hospitalLike = hospitalLike;
		this.hospitalProfessional = hospitalProfessional;
		this.hospitalInfoNum = hospitalInfoNum;
		this.hospitalInfoIntro = hospitalInfoIntro;
		this.hospitalInfoNotice = hospitalInfoNotice;
		this.hospitalPhoto = hospitalPhoto;
		this.hospitalInfoUsetime = hospitalInfoUsetime;
		this.hospitalInfoLunchtime = hospitalInfoLunchtime;
	}

	@Override
	public String toString() {
		return "HospitalInfo [hospitalNum=" + hospitalNum + ", hospitalId=" + hospitalId + ", hospitalPw=" + hospitalPw
				+ ", hospitalName=" + hospitalName + ", hospitalLicense=" + hospitalLicense + ", hospitalTel="
				+ hospitalTel + ", hospitalEmail=" + hospitalEmail + ", hospitalAddr=" + hospitalAddr
				+ ", hospitalDate=" + hospitalDate + ", timeInterval=" + timeInterval + ", hospitalLike=" + hospitalLike
				+ ", hospitalProfessional=" + hospitalProfessional + ", hospitalInfoNum=" + hospitalInfoNum
				+ ", hospitalInfoIntro=" + hospitalInfoIntro + ", hospitalInfoNotice=" + hospitalInfoNotice
				+ ", hospitalPhoto=" + hospitalPhoto + ", hospitalInfoUsetime=" + hospitalInfoUsetime
				+ ", hospitalInfoLunchtime=" + hospitalInfoLunchtime + "]";
	}

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

	public int getTimeInterval() {
		return timeInterval;
	}

	public void setTimeInterval(int timeInterval) {
		this.timeInterval = timeInterval;
	}

	public int getHospitalLike() {
		return hospitalLike;
	}

	public void setHospitalLike(int hospitalLike) {
		this.hospitalLike = hospitalLike;
	}

	public String getHospitalProfessional() {
		return hospitalProfessional;
	}

	public void setHospitalProfessional(String hospitalProfessional) {
		this.hospitalProfessional = hospitalProfessional;
	}

	public int getHospitalInfoNum() {
		return hospitalInfoNum;
	}

	public void setHospitalInfoNum(int hospitalInfoNum) {
		this.hospitalInfoNum = hospitalInfoNum;
	}

	public String getHospitalInfoIntro() {
		return hospitalInfoIntro;
	}

	public void setHospitalInfoIntro(String hospitalInfoIntro) {
		this.hospitalInfoIntro = hospitalInfoIntro;
	}

	public String getHospitalInfoNotice() {
		return hospitalInfoNotice;
	}

	public void setHospitalInfoNotice(String hospitalInfoNotice) {
		this.hospitalInfoNotice = hospitalInfoNotice;
	}

	public String getHospitalPhoto() {
		return hospitalPhoto;
	}

	public void setHospitalPhoto(String hospitalPhoto) {
		this.hospitalPhoto = hospitalPhoto;
	}

	public String getHospitalInfoUsetime() {
		return hospitalInfoUsetime;
	}

	public void setHospitalInfoUsetime(String hospitalInfoUsetime) {
		this.hospitalInfoUsetime = hospitalInfoUsetime;
	}

	public String getHospitalInfoLunchtime() {
		return hospitalInfoLunchtime;
	}

	public void setHospitalInfoLunchtime(String hospitalInfoLunchtime) {
		this.hospitalInfoLunchtime = hospitalInfoLunchtime;
	}
	
	
	
	
	

}
