package com.example.Provicon.model;


import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@Column(name="clini_name",unique = true)
	
private String cliniName;
private String clinicAddress;
private String clinicContact;
private String clinicDepartment;
@OneToMany(mappedBy="clinic",cascade=CascadeType.ALL, fetch = FetchType.EAGER)

private List<DoctorSchdule> doctorSchdule;
@OneToMany(mappedBy="clinic",cascade=CascadeType.ALL, fetch = FetchType.EAGER)

private List<Staff> staff;
public Clinic() {
	super();
}
public Clinic(long clinicId, String cliniName, String clinicAddress, String clinicContact, String clinicDepartment,
		List<DoctorSchdule> doctorSchdule, List<Staff> staff) {
	super();
	this.clinicId = clinicId;
	this.cliniName = cliniName;
	this.clinicAddress = clinicAddress;
	this.clinicContact = clinicContact;
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
@Override
public String toString() {
	return "Clinic [clinicId=" + clinicId + ", cliniName=" + cliniName + ", clinicAddress=" + clinicAddress
			+ ", clinicContact=" + clinicContact + ", clinicDepartment=" + clinicDepartment + ", doctorSchdule="
			+ doctorSchdule + ", staff=" + staff + "]";
}



}
