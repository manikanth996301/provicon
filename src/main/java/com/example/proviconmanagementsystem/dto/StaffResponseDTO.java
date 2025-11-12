package com.example.proviconmanagementsystem.dto;

import java.util.List;

import com.example.proviconmanagementsystem.modal.Clinic;
import com.example.proviconmanagementsystem.modal.StaffSchdule;

public class StaffResponseDTO {
	private long staffId;
	private String staffName;
	private String staffAddress;
	private String staffDepartment;
private List<StaffSchdule> staffSchdule;
	
	private Clinic clinic;
	public StaffResponseDTO() {
		super();
	}
	
	public StaffResponseDTO(long staffId, String staffName, String staffAddress, String staffDepartment,
			List<StaffSchdule> staffSchdule, Clinic clinic) {
		super();
		this.staffId = staffId;
		this.staffName = staffName;
		this.staffAddress = staffAddress;
		this.staffDepartment = staffDepartment;
		this.staffSchdule = staffSchdule;
		this.clinic = clinic;
	}

	public long getStaffId() {
		return staffId;
	}
	public void setStaffId(long staffId) {
		this.staffId = staffId;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getStaffAddress() {
		return staffAddress;
	}
	public void setStaffAddress(String staffAddress) {
		this.staffAddress = staffAddress;
	}
	public String getStaffDepartment() {
		return staffDepartment;
	}
	public void setStaffDepartment(String staffDepartment) {
		this.staffDepartment = staffDepartment;
	}

	public List<StaffSchdule> getStaffSchdule() {
		return staffSchdule;
	}

	public void setStaffSchdule(List<StaffSchdule> staffSchdule) {
		this.staffSchdule = staffSchdule;
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	

	
	
}
