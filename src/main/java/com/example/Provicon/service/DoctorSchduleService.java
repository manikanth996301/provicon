package com.example.Provicon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Provicon.globalException.DoctorSchduleNotFoundException;
import com.example.Provicon.model.Clinic;
import com.example.Provicon.model.Doctor;
import com.example.Provicon.model.DoctorSchdule;
import com.example.Provicon.model.Staff;
import com.example.Provicon.repository.ClinicRepository;
import com.example.Provicon.repository.DoctorRepository;
import com.example.Provicon.repository.DoctorschduleRepository;
import com.example.Provicon.repository.StaffRepository;

@Service
public class DoctorSchduleService {
	@Autowired
private DoctorschduleRepository doctorschduleRepository;
	  @Autowired
	    private DoctorRepository doctorRepository;

	    @Autowired
	    private ClinicRepository clinicRepository;

	 
	    public DoctorSchdule addDoctorSchdule(DoctorSchdule doctorSchdule,Long clinicId,Long doctorId) {


	        Doctor doctor = doctorRepository.findById(doctorId)
	                .orElseThrow(() -> new RuntimeException("Doctor not found"));

	        Clinic defaultClinic = clinicRepository.findById(clinicId)
	                .orElseThrow(() -> new RuntimeException("Default clinic not found"));
          
	     

	       
	        doctorSchdule.setDoctor(doctor);
	        doctorSchdule.setClinic(defaultClinic);
	      

	        return doctorschduleRepository.save(doctorSchdule);
	    }

	    public List<DoctorSchdule> getAllSchdule() {
	        return doctorschduleRepository.findAll();
	    }

	    public DoctorSchdule updateSchdule(DoctorSchdule doctorSchdule) {
	    	DoctorSchdule ds=doctorschduleRepository.findById(doctorSchdule.getDoctorSchduleId())
	    			.orElseThrow(()-> new RuntimeException("DOctor schdule not found"));
	    	if(doctorSchdule.getWorkingDays()!=null) {
	    		ds.setWorkingDays(doctorSchdule.getWorkingDays());
	    	}
	    	if(doctorSchdule.getStartTime()!=null) {
	    		ds.setStartTime(doctorSchdule.getStartTime());
	    	}
	    	if(doctorSchdule.getEndTime()!=null) {
	    		ds.setEndTime(doctorSchdule.getEndTime());
	    	}
	        return doctorschduleRepository.save(ds);
	    }

	    public void deleteById(long id) {
	    	doctorschduleRepository.deleteById(id);
	    }

	    public DoctorSchdule getSchduleById(long id) {
	        return doctorschduleRepository.findById(id).orElseThrow(()->new DoctorSchduleNotFoundException("Doctor Schdule not found"));
	    }
	
}
