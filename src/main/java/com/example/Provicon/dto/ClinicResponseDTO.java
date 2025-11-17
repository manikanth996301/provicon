package com.example.Provicon.dto;

import java.util.List;

public class ClinicResponseDTO {

	private long clinicId;
    private String cliniName;
    private String clinicAddress;
    private String clinicContact;
    private String clinicDepartment;
    private List<String> doctorSchduleNames; 
    private List<String> staffNames;
	public long getClinicId() {
		return clinicId;
	}
	public void setClinicId(long clinicId) {
		this.clinicId = clinicId;
	}
	public String getCliniName() {
		return cliniName;
	}
	public void setCliniName(String cliniName) {
		this.cliniName = cliniName;
	}
	public String getClinicAddress() {
		return clinicAddress;
	}
	public void setClinicAddress(String clinicAddress) {
		this.clinicAddress = clinicAddress;
	}
	public String getClinicContact() {
		return clinicContact;
	}
	public void setClinicContact(String clinicContact) {
		this.clinicContact = clinicContact;
	}
	public String getClinicDepartment() {
		return clinicDepartment;
	}
	public void setClinicDepartment(String clinicDepartment) {
		this.clinicDepartment = clinicDepartment;
	}
	public List<String> getDoctorSchduleNames() {
		return doctorSchduleNames;
	}
	public void setDoctorSchduleNames(List<String> doctorSchduleNames) {
		this.doctorSchduleNames = doctorSchduleNames;
	}
	public List<String> getStaffNames() {
		return staffNames;
	}
	public void setStaffNames(List<String> staffNames) {
		this.staffNames = staffNames;
	}          
}
