package com.medi.pot.member.model.vo;

import java.util.Arrays;

public class DoctorInfos {
	    //  의사번호
	    private int doctorNum;

	    //  의사명
	    private String doctorName;

	    //  의사이력
	    private String doctorCareer;

	    //  병원번호
	    private int hospitalNo;

	    //  진료과목
	    private String[] professional;

	    //  점심시작시간
	    private String doctorSlunch;

	    //  점심끝시간
	    private String doctorElunch;

	    //  평일시작시간
	    private String weekdayStime;

	    //  평일끝시간
	    private String weekdayEtime;

	    //  토요일시작시간
	    private String satStime;

	    //  토요일끝시간
	    private String satEtime;

	    //  휴무일
	    private String closed;

	    //  전문분야
	    private String specialized;

	    //  의사사진
	    private String doctorPhoto;
	    
	    //  의사사진 사본
	    private String doctorRePhoto;

	    //  시간 간격
	    private String timeInterval;

		public DoctorInfos() {
			// TODO Auto-generated constructor stub
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

		public String[] getProfessional() {
			return professional;
		}

		public void setProfessional(String[] professional) {
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

		public String getDoctorPhoto() {
			return doctorPhoto;
		}

		public void setDoctorPhoto(String doctorPhoto) {
			this.doctorPhoto = doctorPhoto;
		}

		public String getDoctorRePhoto() {
			return doctorRePhoto;
		}

		public void setDoctorRePhoto(String doctorRePhoto) {
			this.doctorRePhoto = doctorRePhoto;
		}

		public String getTimeInterval() {
			return timeInterval;
		}

		public void setTimeInterval(String timeInterval) {
			this.timeInterval = timeInterval;
		}

		public DoctorInfos(int doctorNum, String doctorName, String doctorCareer, int hospitalNo, String[] professional,
				String doctorSlunch, String doctorElunch, String weekdayStime, String weekdayEtime, String satStime,
				String satEtime, String closed, String specialized, String doctorPhoto, String doctorRePhoto,
				String timeInterval) {
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
			this.doctorPhoto = doctorPhoto;
			this.doctorRePhoto = doctorRePhoto;
			this.timeInterval = timeInterval;
		}

		@Override
		public String toString() {
			return "DoctorInfos [doctorNum=" + doctorNum + ", doctorName=" + doctorName + ", doctorCareer="
					+ doctorCareer + ", hospitalNo=" + hospitalNo + ", professional=" + Arrays.toString(professional)
					+ ", doctorSlunch=" + doctorSlunch + ", doctorElunch=" + doctorElunch + ", weekdayStime="
					+ weekdayStime + ", weekdayEtime=" + weekdayEtime + ", satStime=" + satStime + ", satEtime="
					+ satEtime + ", closed=" + closed + ", specialized=" + specialized + ", doctorPhoto=" + doctorPhoto
					+ ", doctorRePhoto=" + doctorRePhoto + ", timeInterval=" + timeInterval + "]";
		}

		
		
	    
}
