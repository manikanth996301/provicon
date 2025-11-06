package com.example.proviconmanagementsystem.modal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class StaffSchdule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long staffSchduleId;
	@Column(unique = true)
	private String dayOfWeek;
	private String startTime;
	private String endTime;
	@ManyToOne
	@JoinColumn(name="staff_id")
	@JsonIgnore
private Staff staff;
	public StaffSchdule() {
		super();
	}
	public StaffSchdule(long staffSchduleId, String dayOfWeek, String startTime, String endTime, Staff staff) {
		super();
		this.staffSchduleId = staffSchduleId;
		this.dayOfWeek = dayOfWeek;
		this.startTime = startTime;
		this.endTime = endTime;
		this.staff = staff;
	}
	public long getStaffSchduleId() {
		return staffSchduleId;
	}
	public void setStaffSchduleId(long staffSchduleId) {
		this.staffSchduleId = staffSchduleId;
	}
	public String getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
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
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	
}
