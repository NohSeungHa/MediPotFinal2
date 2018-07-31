package com.medi.pot.reservation.model.vo;

public class DoctorInfo {
	
	private int doctorNum;
	private String doctorName;
	private String doctorCareer;
	private int hospitalNo;
	private String professional;
	private String doctorSlunch;
	private String doctorElunch;
	private String weekdayStime;
	private String weekdayEtime;
	private String satStime;
	private String satEtime;
	private String closed;
	private String specialized;
	
	public DoctorInfo() {
		// TODO Auto-generated constructor stub
	}

	public DoctorInfo(int doctorNum, String doctorName, String doctorCareer, int hospitalNo, String professional,
			String doctorSlunch, String doctorElunch, String weekdayStime, String weekdayEtime, String satStime,
			String satEtime, String closed, String specialized) {
		super();
		this.doctorNum = doctorNum;
		this.doctorName = doctorName;
		this.doctorCareer = doctorCareer;
		this.hospitalNo = hospitalNo;
		this.professional = professional;
		this.doctorSlunch = doctorSlunch;
		this.doctorElunch = doctorElunch;
		this.weekdayStime = weekdayStime;
		this.weekdayEtime = weekdayEtime;
		this.satStime = satStime;
		this.satEtime = satEtime;
		this.closed = closed;
		this.specialized = specialized;
	}

	@Override
	public String toString() {
		return "DoctorInfo [doctorNum=" + doctorNum + ", doctorName=" + doctorName + ", doctorCareer=" + doctorCareer
				+ ", hospitalNo=" + hospitalNo + ", professional=" + professional + ", doctorSlunch=" + doctorSlunch
				+ ", doctorElunch=" + doctorElunch + ", weekdayStime=" + weekdayStime + ", weekdayEtime=" + weekdayEtime
				+ ", satStime=" + satStime + ", satEtime=" + satEtime + ", closed=" + closed + ", specialized="
				+ specialized + "]";
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

	public String getDoctorCareer() {
		return doctorCareer;
	}

	public void setDoctorCareer(String doctorCareer) {
		this.doctorCareer = doctorCareer;
	}

	public int getHospitalNo() {
		return hospitalNo;
	}

	public void setHospitalNo(int hospitalNo) {
		this.hospitalNo = hospitalNo;
	}

	public String getProfessional() {
		return professional;
	}

	public void setProfessional(String professional) {
		this.professional = professional;
	}

	public String getDoctorSlunch() {
		return doctorSlunch;
	}

	public void setDoctorSlunch(String doctorSlunch) {
		this.doctorSlunch = doctorSlunch;
	}

	public String getDoctorElunch() {
		return doctorElunch;
	}

	public void setDoctorElunch(String doctorElunch) {
		this.doctorElunch = doctorElunch;
	}

	public String getWeekdayStime() {
		return weekdayStime;
	}

	public void setWeekdayStime(String weekdayStime) {
		this.weekdayStime = weekdayStime;
	}

	public String getWeekdayEtime() {
		return weekdayEtime;
	}

	public void setWeekdayEtime(String weekdayEtime) {
		this.weekdayEtime = weekdayEtime;
	}

	public String getSatStime() {
		return satStime;
	}

	public void setSatStime(String satStime) {
		this.satStime = satStime;
	}

	public String getSatEtime() {
		return satEtime;
	}

	public void setSatEtime(String satEtime) {
		this.satEtime = satEtime;
	}

	public String getClosed() {
		return closed;
	}

	public void setClosed(String closed) {
		this.closed = closed;
	}

	public String getSpecialized() {
		return specialized;
	}

	public void setSpecialized(String specialized) {
		this.specialized = specialized;
	}
	
	

}
