package com.example.Provicon.model;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private long doctorId;
private String doctorName;
private String doctorAddress;
private String doctorSpecialization;
private String doctorDepartment;
@OneToMany(mappedBy="doctor",cascade=CascadeType.PERSIST,fetch = FetchType.EAGER)
@JsonIgnore
private List<DoctorSchdule> doctorSchdule;
public Doctor() {
	super();
}
public Doctor(long doctorId, String doctorName, String doctorAddress, String doctorSpecialization,
		String doctorDepartment, List<DoctorSchdule> doctorSchdule) {
	super();
	this.doctorId = doctorId;
	this.doctorName = doctorName;
	this.doctorAddress = doctorAddress;
	this.doctorSpecialization = doctorSpecialization;
	this.doctorDepartment = doctorDepartment;
	this.doctorSchdule = doctorSchdule;
}
public long getDoctorId() {
	return doctorId;
}
public void setDoctorId(long doctorId) {
	this.doctorId = doctorId;
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
@Override
public String toString() {
	return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", doctorAddress=" + doctorAddress
			+ ", doctorSpecialization=" + doctorSpecialization + ", doctorDepartment=" + doctorDepartment
			+ ", doctorSchdule=" + doctorSchdule + "]";
}


}
