package com.medi.pot.reservation.model.vo;

public class ReserList {
	private String checkDate;
	private String checkTime;
	private String hospitalName;
	private String hospitalTel;
	private String hospitalAddr;
	private String hospitalProfessional;
	
	public ReserList() {
		// TODO Auto-generated constructor stub
	}

	public ReserList(String checkDate, String checkTime, String hospitalName, String hospitalTel, String hospitalAddr,
			String hospitalProfessional) {
		super();
		this.checkDate = checkDate;
		this.checkTime = checkTime;
		this.hospitalName = hospitalName;
		this.hospitalTel = hospitalTel;
		this.hospitalAddr = hospitalAddr;
		this.hospitalProfessional = hospitalProfessional;
	}

	@Override
	public String toString() {
		return "ReserList [checkDate=" + checkDate + ", checkTime=" + checkTime + ", hospitalName=" + hospitalName
				+ ", hospitalTel=" + hospitalTel + ", hospitalAddr=" + hospitalAddr + ", hospitalProfessional="
				+ hospitalProfessional + "]";
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

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getHospitalTel() {
		return hospitalTel;
	}

	public void setHospitalTel(String hospitalTel) {
		this.hospitalTel = hospitalTel;
	}

	public String getHospitalAddr() {
		return hospitalAddr;
	}

	public void setHospitalAddr(String hospitalAddr) {
		this.hospitalAddr = hospitalAddr;
	}

	public String getHospitalProfessional() {
		return hospitalProfessional;
	}

	public void setHospitalProfessional(String hospitalProfessional) {
		this.hospitalProfessional = hospitalProfessional;
	}
	
	

}
