package com.example.Provicon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Provicon.globalException.StaffSchduleNotFoundException;
import com.example.Provicon.model.Staff;
import com.example.Provicon.model.StaffSchdule;
import com.example.Provicon.repository.StaffRepository;
import com.example.Provicon.repository.StaffSchduleRepository;

@Service
public class StaffSchduleService {
	@Autowired
private StaffSchduleRepository staffSchduleRepository;
	@Autowired
	private StaffRepository staffRepository;
	
    public StaffSchdule addStaffSchdule(StaffSchdule staffSchdule,Long staffId) {
//    	
    	Staff staff=staffRepository.findById(staffId)
    			.orElseThrow(()->new RuntimeException("Staff not found"));
    	staffSchdule.setStaff(staff);
        return staffSchduleRepository.save(staffSchdule);
    }

 
    public List<StaffSchdule> getAllStaffSchdules() {
        return staffSchduleRepository.findAll();
    }

 
    public StaffSchdule getStaffSchduleById(long id) {
        return staffSchduleRepository.findById(id).orElseThrow(()-> new StaffSchduleNotFoundException("Staff Schdule not found withId"));
    }

    public StaffSchdule updateStaffSchdule(StaffSchdule staffSchdule) {
    	StaffSchdule ss=staffSchduleRepository.findById(staffSchdule.getId())
    			.orElseThrow(()-> new RuntimeException("Staff Schdule not found"));
    	if(staffSchdule.getDayOfWeek() != null) {
    	ss.setDayOfWeek(staffSchdule.getDayOfWeek());
    	}
    	if(staffSchdule.getStaff() != null) {
    	ss.setStartTime(staffSchdule.getStartTime());
    	}
    	if(staffSchdule.getEndTime() != null) {
    	ss.setEndTime(staffSchdule.getEndTime());
    	}
        return staffSchduleRepository.save(ss);
    }

  
    public void deleteStaffSchdule(long id) {
        staffSchduleRepository.deleteById(id);
    }


	
}
