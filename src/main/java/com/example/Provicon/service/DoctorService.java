package com.example.Provicon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Provicon.globalException.DoctorNotFoundException;
import com.example.Provicon.model.Doctor;
import com.example.Provicon.repository.DoctorRepository;

@Service
public class DoctorService {
	@Autowired
private DoctorRepository doctorRepository;


    public Doctor addDoctorDetails(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public List<Doctor> getAllDoctorDetails() {
        return doctorRepository.findAll();
    }

    public Doctor updateDoctor(Doctor doctor) {
    	Doctor doc=doctorRepository.findById(doctor.getDoctorId())
    			.orElseThrow(()-> new RuntimeException("Doctor not found"));
    	if(doctor.getDoctorName() != null) {
    		doc.setDoctorName(doctor.getDoctorName());
    	}
    	if(doctor.getDoctorAddress() != null) {
    		doc.setDoctorAddress(doctor.getDoctorAddress());
    	}
    	if(doctor.getDoctorDepartment() != null) {
    		doc.setDoctorDepartment(doctor.getDoctorDepartment());
    	}
    	if(doctor.getDoctorSpecialization() != null) {
    		doc.setDoctorSpecialization(doctor.getDoctorSpecialization());
    	}
        return doctorRepository.save(doc);
    }

    public void deleteById(long id) {
        doctorRepository.deleteById(id);
    }

    public Doctor getDoctorById(long id) {
        return doctorRepository.findById(id).orElseThrow(()-> new DoctorNotFoundException
        		("Student not found with Id"));
    }

	public Doctor getDoctorByName(String name) {
		// TODO Auto-generated method stub
		return doctorRepository.findByDoctorName(name);
	}
}
