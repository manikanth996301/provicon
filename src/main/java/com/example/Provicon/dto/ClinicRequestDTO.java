package com.example.Provicon.dto;

import java.util.List;

public class ClinicRequestDTO {
	 private String cliniName;
	    private String clinicAddress;
	    private String clinicContact;
	    private String clinicDepartment;
	    private List<Long> doctorSchduleIds; 
	    private List<Long> staffIds;
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
		public List<Long> getDoctorSchduleIds() {
			return doctorSchduleIds;
		}
		public void setDoctorSchduleIds(List<Long> doctorSchduleIds) {
			this.doctorSchduleIds = doctorSchduleIds;
		}
		public List<Long> getStaffIds() {
			return staffIds;
		}
		public void setStaffIds(List<Long> staffIds) {
			this.staffIds = staffIds;
		}         
}
