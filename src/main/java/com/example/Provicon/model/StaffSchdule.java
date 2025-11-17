package com.example.Provicon.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private long id;
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
	public StaffSchdule(long id, String dayOfWeek, String startTime, String endTime, Staff staff) {
		super();
		this.id = id;
		this.dayOfWeek = dayOfWeek;
		this.startTime = startTime;
		this.endTime = endTime;
		this.staff = staff;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "StaffSchdule [id=" + id + ", dayOfWeek=" + dayOfWeek + ", startTime=" + startTime + ", endTime="
				+ endTime + ", staff=" + staff + "]";
	}
	
	
}
