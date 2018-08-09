package com.medi.pot.member.model.vo;

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
	    private String WeekdayStime;

	    //  평일끝시간
	    private String WeekdayEtime;

	    //  토요일시작시간
	    private String SatStime;

	    //  토요일끝시간
	    private String SatEtime;

	    //  휴무일
	    private String Closed;

	    //  전문분야
	    private String Specialized;

	    //  의사사진
	    private String doctorPhoto;
	    
	    //  의사사진 사본
	    private String doctorRePhoto;

	    //  시간 간격
	    private String timeInterval;

		public Integer getDoctorNum() {
			return doctorNum;
		}

		public void setDoctorNum(Integer doctorNum) {
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

		public Integer getHospitalNo() {
			return hospitalNo;
		}

		public void setHospitalNo(Integer hospitalNo) {
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
			return WeekdayStime;
		}

		public void setWeekdayStime(String weekdayStime) {
			WeekdayStime = weekdayStime;
		}

		public String getWeekdayEtime() {
			return WeekdayEtime;
		}

		public void setWeekdayEtime(String weekdayEtime) {
			WeekdayEtime = weekdayEtime;
		}

		public String getSatStime() {
			return SatStime;
		}

		public void setSatStime(String satStime) {
			SatStime = satStime;
		}

		public String getSatEtime() {
			return SatEtime;
		}

		public void setSatEtime(String satEtime) {
			SatEtime = satEtime;
		}

		public String getClosed() {
			return Closed;
		}

		public void setClosed(String closed) {
			Closed = closed;
		}

		public String getSpecialized() {
			return Specialized;
		}

		public void setSpecialized(String specialized) {
			Specialized = specialized;
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
		
		public DoctorInfos() {}

		public DoctorInfos(Integer doctorNum, String doctorName, String doctorCareer, Integer hospitalNo,
				String[] professional, String doctorSlunch, String doctorElunch, String weekdayStime, String weekdayEtime,
				String satStime, String satEtime, String closed, String specialized, String doctorPhoto,
				String doctorRePhoto, String timeInterval) {
			super();
			this.doctorNum = doctorNum;
			this.doctorName = doctorName;
			this.doctorCareer = doctorCareer;
			this.hospitalNo = hospitalNo;
			this.professional = professional;
			this.doctorSlunch = doctorSlunch;
			this.doctorElunch = doctorElunch;
			WeekdayStime = weekdayStime;
			WeekdayEtime = weekdayEtime;
			SatStime = satStime;
			SatEtime = satEtime;
			Closed = closed;
			Specialized = specialized;
			this.doctorPhoto = doctorPhoto;
			this.doctorRePhoto = doctorRePhoto;
			this.timeInterval = timeInterval;
		}

		@Override
		public String toString() {
			return "DoctorInfos [doctorNum=" + doctorNum + ", doctorName=" + doctorName + ", doctorCareer="
					+ doctorCareer + ", hospitalNo=" + hospitalNo + ", professional=" + professional + ", doctorSlunch="
					+ doctorSlunch + ", doctorElunch=" + doctorElunch + ", WeekdayStime=" + WeekdayStime
					+ ", WeekdayEtime=" + WeekdayEtime + ", SatStime=" + SatStime + ", SatEtime=" + SatEtime
					+ ", Closed=" + Closed + ", Specialized=" + Specialized + ", doctorPhoto=" + doctorPhoto
					+ ", doctorRePhoto=" + doctorRePhoto + ", timeInterval=" + timeInterval + "]";
		}

	    
	    
}
