package com.example.Provicon.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Staff {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private long staffId;
private String staffName;
private String staffAddress;
private String staffDepartment;

@OneToMany(mappedBy="staff",cascade=CascadeType.ALL,fetch = FetchType.EAGER)
private List<StaffSchdule> staffschdule;
@ManyToOne
@JoinColumn(name="clinic_id")
@JsonIgnore
private Clinic clinic;
public Staff() {
	super();
}
public Staff(long staffId, String staffName, String staffAddress, String staffDepartment,
		List<StaffSchdule> staffschdule, Clinic clinic) {
	super();
	this.staffId = staffId;
	this.staffName = staffName;
	this.staffAddress = staffAddress;
	this.staffDepartment = staffDepartment;
	this.staffschdule = staffschdule;
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
public List<StaffSchdule> getStaffschdule() {
	return staffschdule;
}
public void setStaffschdule(List<StaffSchdule> staffschdule) {
	this.staffschdule = staffschdule;
}
public Clinic getClinic() {
	return clinic;
}
public void setClinic(Clinic clinic) {
	this.clinic = clinic;
}
@Override
public String toString() {
	return "Staff [staffId=" + staffId + ", staffName=" + staffName + ", staffAddress=" + staffAddress
			+ ", staffDepartment=" + staffDepartment + ", staffschdule=" + staffschdule + ", clinic=" + clinic + "]";
}

}
