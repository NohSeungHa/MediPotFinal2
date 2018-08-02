package com.medi.pot.reservation.model.vo;

import java.sql.Date;

public class DoctorSchedule {
	private int blockDoctor;
	private int blockHospital;
	private String blockDate;
	private String blockTime;
	private String blockCheck;
	
	public DoctorSchedule() {
		// TODO Auto-generated constructor stub
	}

	public DoctorSchedule(int blockDoctor, int blockHospital, String blockDate, String blockTime, String blockCheck) {
		super();
		this.blockDoctor = blockDoctor;
		this.blockHospital = blockHospital;
		this.blockDate = blockDate;
		this.blockTime = blockTime;
		this.blockCheck = blockCheck;
	}

	@Override
	public String toString() {
		return "DoctorSchedule [blockDoctor=" + blockDoctor + ", blockHospital=" + blockHospital + ", blockDate="
				+ blockDate + ", blockTime=" + blockTime + ", blockCheck=" + blockCheck + "]";
	}

	public int getBlockDoctor() {
		return blockDoctor;
	}

	public void setBlockDoctor(int blockDoctor) {
		this.blockDoctor = blockDoctor;
	}

	public int getBlockHospital() {
		return blockHospital;
	}

	public void setBlockHospital(int blockHospital) {
		this.blockHospital = blockHospital;
	}

	public String getBlockDate() {
		return blockDate;
	}

	public void setBlockDate(String blockDate) {
		this.blockDate = blockDate;
	}

	public String getBlockTime() {
		return blockTime;
	}

	public void setBlockTime(String blockTime) {
		this.blockTime = blockTime;
	}

	public String getBlockCheck() {
		return blockCheck;
	}

	public void setBlockCheck(String blockCheck) {
		this.blockCheck = blockCheck;
	}

	
	

}
