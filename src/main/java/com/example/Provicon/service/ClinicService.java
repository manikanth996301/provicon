package com.example.Provicon.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Provicon.globalException.ClinicAlreadyExistsException;
import com.example.Provicon.globalException.ClinicNotFoundException;
import com.example.Provicon.model.Clinic;
import com.example.Provicon.model.DoctorSchdule;
import com.example.Provicon.model.Staff;
import com.example.Provicon.repository.ClinicRepository;
import com.example.Provicon.repository.DoctorschduleRepository;
import com.example.Provicon.repository.StaffRepository;
import com.example.Provicon.repository.StaffSchduleRepository;

@Service

public class ClinicService {
	@Autowired
	private ClinicRepository clinicRepository;

	 public Clinic addClinicDetails(Clinic clinic) {
		 if(clinicRepository.existsBycliniName(clinic.getCliniName())) {
			 throw new ClinicAlreadyExistsException("clinic already exists with name "+ clinic.getCliniName());
		 }
	        return clinicRepository.save(clinic);
	    }

	    public List<Clinic> getAllClinicDetails() {
	        return clinicRepository.findAll();
	    }

	    public Clinic updateClinicDetails(Clinic clinic) {
	    	Clinic c=clinicRepository.findById(clinic.getClinicId())
	    	.orElseThrow(()->new RuntimeException("clinic not found withId"));
	    	if(clinic.getCliniName() != null) {
	    	
	    	c.setCliniName(clinic.getCliniName());
	    	}
	    	if(clinic.getClinicAddress() != null) {
	    	c.setClinicAddress(clinic.getClinicAddress());
	    	}
	    	if(clinic.getClinicContact() != null) {
	    	c.setClinicContact(clinic.getClinicContact());
	    	}
	    	
	    	if(clinic.getClinicDepartment() != null) {
	    	c.setClinicDepartment(clinic.getClinicDepartment());
	    	}
	        return clinicRepository.save(c);
	    }

	    public void deleteClinicDetails(long id) {
	        clinicRepository.deleteById(id);
	    }

	    public Clinic getClinicById(long id) {
	        return clinicRepository.findById(id).orElseThrow(()->
	        new ClinicNotFoundException("Clinic not found withId"));
	        
	    }

		

		public Clinic getClinicByNo(String no) {
			// TODO Auto-generated method stub
			return clinicRepository.findByclinicContact(no);
		}

		public Clinic getClinicByName(String name) {
			// TODO Auto-generated method stub
			return clinicRepository.findByCliniName(name);
		}

}
