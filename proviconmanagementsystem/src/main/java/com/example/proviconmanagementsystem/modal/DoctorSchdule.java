package com.example.proviconmanagementsystem.modal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class DoctorSchdule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private long schduleId;
	@Column(unique = true)
private String workingDays;
private String startTime;
private String endTime;
@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
@JoinColumn(name="doctor_id")
private Doctor doctor;
@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
@JoinColumn(name="clinic_id")
@JsonIgnore
private Clinic clinic;
public DoctorSchdule() {
	super();
}
public DoctorSchdule(long schduleId, String workingDays, String startTime, String endTime, Doctor doctor,
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
