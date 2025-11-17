package com.example.Provicon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Provicon.globalException.StaffNotFoundException;
import com.example.Provicon.model.Clinic;
import com.example.Provicon.model.Staff;
import com.example.Provicon.repository.ClinicRepository;
import com.example.Provicon.repository.StaffRepository;

@Service
public class StaffService {
	@Autowired
private StaffRepository staffRepository;
@Autowired
private ClinicRepository clinicRepository;
	
    public Staff addStaff(Staff staff,Long clinicId) {
 
        Clinic defaultClinic = clinicRepository.findById(clinicId)
              
        		.orElseThrow(() -> new RuntimeException("Default Clinic not found"));
      
        return staffRepository.save(staff);
    }

    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    public Staff updateStaff(Staff staff) {
    	Staff s=staffRepository.findById(staff.getStaffId())
    			.orElseThrow(()-> new RuntimeException("Staff not found"));
    	if(staff.getStaffName()!= null) {
    		s.setStaffName(staff.getStaffName());
    	}
    	if(staff.getStaffAddress()!=null) {
    		s.setStaffAddress(staff.getStaffAddress());
    	}
    	if(staff.getStaffDepartment()!=null) {
    		s.setStaffDepartment(staff.getStaffDepartment());
    	}
        return staffRepository.save(s);
    }

    public void deleteById(long id) {
        staffRepository.deleteById(id);
    }

    public Staff getStaffById(long id) {
        return staffRepository.findById(id).orElseThrow(()->new StaffNotFoundException("Staff not found with Id"));
    }

	public Staff getStaffByName(String name) {
	
		return staffRepository.findByStaffName(name);
	}
	
}
