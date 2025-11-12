package com.example.proviconmanagementsystem.modal;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Clinic {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long clinicId;
	@Column(unique=true)
	private String clinicName;
	private String clinicContact;
	private String clinicAddress;
	private String clinicDepartment;
	@OneToMany(mappedBy = "clinic",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<DoctorSchdule> doctorSchdule;
	@OneToMany(mappedBy = "clinic",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Staff> staff;
	public Clinic() {
		super();
	}
	public Clinic(long clinicId, String clinicName, String clinicContact, String clinicAddress, String clinicDepartment,
			List<DoctorSchdule> doctorSchdule, List<Staff> staff) {
		super();
		this.clinicId = clinicId;
		this.clinicName = clinicName;
		this.clinicContact = clinicContact;
		this.clinicAddress = clinicAddress;
		this.clinicDepartment = clinicDepartment;
		this.doctorSchdule = doctorSchdule;
		this.staff = staff;
	}
	public long getClinicId() {
		return clinicId;
	}
	public void setClinicId(long clinicId) {
		this.clinicId = clinicId;
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
