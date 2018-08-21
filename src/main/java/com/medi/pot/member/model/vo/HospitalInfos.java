package com.medi.pot.member.model.vo;

public class HospitalInfos {
	
	private int hospitalInfoNum;
	private String hospitalInfoIntro;
	private String hospitalInfoNotice;
	private String hospitalPhoto;
	private String hospitalRePhoto;
	private String hospitalInfoUsetime;
	private String hospitalInfoLunchtime;

	public HospitalInfos() {}

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

	public String getHospitalRePhoto() {
		return hospitalRePhoto;
	}

	public void setHospitalRePhoto(String hospitalRePhoto) {
		this.hospitalRePhoto = hospitalRePhoto;
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

	public HospitalInfos(int hospitalInfoNum, String hospitalInfoIntro, String hospitalInfoNotice, String hospitalPhoto,
			String hospitalRePhoto, String hospitalInfoUsetime, String hospitalInfoLunchtime) {
		super();
		this.hospitalInfoNum = hospitalInfoNum;
		this.hospitalInfoIntro = hospitalInfoIntro;
		this.hospitalInfoNotice = hospitalInfoNotice;
		this.hospitalPhoto = hospitalPhoto;
		this.hospitalRePhoto = hospitalRePhoto;
		this.hospitalInfoUsetime = hospitalInfoUsetime;
		this.hospitalInfoLunchtime = hospitalInfoLunchtime;
	}

	@Override
	public String toString() {
		return "HospitalInfos [hospitalInfoNum=" + hospitalInfoNum + ", hospitalInfoIntro=" + hospitalInfoIntro
				+ ", hospitalInfoNotice=" + hospitalInfoNotice + ", hospitalPhoto=" + hospitalPhoto
				+ ", hospitalRePhoto=" + hospitalRePhoto + ", hospitalInfoUsetime=" + hospitalInfoUsetime
				+ ", hospitalInfoLunchtime=" + hospitalInfoLunchtime + "]";
	}
	
	
}
