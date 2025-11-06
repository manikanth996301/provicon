package com.example.proviconmanagementsystem.dto;

import java.util.List;

import com.example.proviconmanagementsystem.modal.DoctorSchdule;
import com.example.proviconmanagementsystem.modal.Staff;

public class ClinicRequestDTO {
	private String clinicName;
	private String clinicContact;
	private String clinicAddress;
	private String clinicDepartment;
	private List<DoctorSchdule> doctorSchdule;
	
	private List<Staff> staff;
	public ClinicRequestDTO() {
		super();
	}
	
	public ClinicRequestDTO(String clinicName, String clinicContact, String clinicAddress, String clinicDepartment,
			List<DoctorSchdule> doctorSchdule, List<Staff> staff) {
		super();
		this.clinicName = clinicName;
		this.clinicContact = clinicContact;
		this.clinicAddress = clinicAddress;
		this.clinicDepartment = clinicDepartment;
		this.doctorSchdule = doctorSchdule;
		this.staff = staff;
	}

	public String getClinicName() {
		return clinicName;
	}
	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}
	public String getClinicContact() {
		return clinicContact;
	}
	public void setClinicContact(String clinicContact) {
		this.clinicContact = clinicContact;
	}
	public String getClinicAddress() {
		return clinicAddress;
	}
	public void setClinicAddress(String clinicAddress) {
		this.clinicAddress = clinicAddress;
	}
	public String getClinicDepartment() {
		return clinicDepartment;
	}
	public void setClinicDepartment(String clinicDepartment) {
		this.clinicDepartment = clinicDepartment;
	}

	public List<DoctorSchdule> getDoctorSchdule() {
		return doctorSchdule;
	}

	public void setDoctorSchdule(List<DoctorSchdule> doctorSchdule) {
		this.doctorSchdule = doctorSchdule;
	}

	public List<Staff> getStaff() {
		return staff;
	}

	public void setStaff(List<Staff> staff) {
		this.staff = staff;
	}
	
}
