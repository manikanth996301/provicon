package com.example.proviconmanagementsystem.dto;

import com.example.proviconmanagementsystem.modal.Staff;

public class StaffSchduleResponseDTO {
	private long staffSchduleId;
	private String dayOfWeek;
	private String startTime;
	private String endTime;
	private Staff staff;
	public StaffSchduleResponseDTO() {
		super();
	}
	
	public StaffSchduleResponseDTO(long staffSchduleId, String dayOfWeek, String startTime, String endTime,
			Staff staff) {
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
