package com.example.proviconmanagementsystem.dto;

import com.example.proviconmanagementsystem.modal.Clinic;
import com.example.proviconmanagementsystem.modal.Doctor;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class DoctorSchduleRequestDTO {
	private String workingDays;
	private String startTime;
	private String endTime;
	private Doctor doctor;
	
	private Clinic clinic;

	public DoctorSchduleRequestDTO() {
		super();
	}
	
	public DoctorSchduleRequestDTO(String workingDays, String startTime, String endTime, Doctor doctor, Clinic clinic) {
		super();
		this.workingDays = workingDays;
		this.startTime = startTime;
		this.endTime = endTime;
		this.doctor = doctor;
		this.clinic = clinic;
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

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}
	
}
