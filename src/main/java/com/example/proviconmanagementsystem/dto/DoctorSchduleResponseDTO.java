package com.example.proviconmanagementsystem.dto;

import com.example.proviconmanagementsystem.modal.Clinic;
import com.example.proviconmanagementsystem.modal.Doctor;

public class DoctorSchduleResponseDTO {
	private long schduleId;
	private String workingDays;
	private String startTime;
	private String endTime;
private Doctor doctor;
	
	private Clinic clinic;
	public DoctorSchduleResponseDTO() {
		super();
	}
	
	public DoctorSchduleResponseDTO(long schduleId, String workingDays, String startTime, String endTime, Doctor doctor,
			Clinic clinic) {
		super();
		this.schduleId = schduleId;
		this.workingDays = workingDays;
		this.startTime = startTime;
		this.endTime = endTime;
		this.doctor = doctor;
		this.clinic = clinic;
	}

	public long getSchduleId() {
		return schduleId;
	}
	public void setSchduleId(long schduleId) {
		this.schduleId = schduleId;
	}
	public String getWorkingDays() {
		return workingDays;
	}
	public void setWorkingDays(String workingDays) {
		this.workingDays = workingDays;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	
}
