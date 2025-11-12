package com.example.proviconmanagementsystem.dto;

import java.util.List;

import com.example.proviconmanagementsystem.modal.DoctorSchdule;

public class DoctorRequestDTO {
	private String doctorName;
	private String doctorAddress;
	private String doctorSpecialization;
	private String doctorDepartment;
	private List<DoctorSchdule> doctorSchdule;
	public DoctorRequestDTO() {
		super();
	}
	
	public DoctorRequestDTO(String doctorName, String doctorAddress, String doctorSpecialization,
			String doctorDepartment, List<DoctorSchdule> doctorSchdule) {
		super();
		this.doctorName = doctorName;
		this.doctorAddress = doctorAddress;
		this.doctorSpecialization = doctorSpecialization;
		this.doctorDepartment = doctorDepartment;
		this.doctorSchdule = doctorSchdule;
	}

	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDoctorAddress() {
		return doctorAddress;
	}
	public void setDoctorAddress(String doctorAddress) {
		this.doctorAddress = doctorAddress;
	}
	public String getDoctorSpecialization() {
		return doctorSpecialization;
	}
	public void setDoctorSpecialization(String doctorSpecialization) {
		this.doctorSpecialization = doctorSpecialization;
	}
	public String getDoctorDepartment() {
		return doctorDepartment;
	}
	public void setDoctorDepartment(String doctorDepartment) {
		this.doctorDepartment = doctorDepartment;
	}

	public List<DoctorSchdule> getDoctorSchdule() {
		return doctorSchdule;
	}

	public void setDoctorSchdule(List<DoctorSchdule> doctorSchdule) {
		this.doctorSchdule = doctorSchdule;
	}
	
}
