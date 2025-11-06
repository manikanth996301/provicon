package com.example.proviconmanagementsystem.dto;

import com.example.proviconmanagementsystem.modal.Staff;

public class StaffSchduleRequestDTO {
	private String dayOfWeek;
	private String startTime;
	private String endTime;
	private Staff staff;
	public StaffSchduleRequestDTO() {
		super();
	}
	
	public StaffSchduleRequestDTO(String dayOfWeek, String startTime, String endTime, Staff staff) {
		super();
		this.dayOfWeek = dayOfWeek;
		this.startTime = startTime;
		this.endTime = endTime;
		this.staff = staff;
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
