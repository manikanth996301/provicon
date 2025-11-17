package com.example.Provicon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Provicon.model.Doctor;
import com.example.Provicon.service.DoctorService;

@RestController
@RequestMapping("/Doctor")
public class DoctorController {
	@Autowired
private DoctorService doctorService;
	 @PostMapping("/add")
	    public ResponseEntity<Doctor> addDoctorDetails(@RequestBody Doctor doctor) {
	        Doctor savedDoctor = doctorService.addDoctorDetails(doctor);
	        return ResponseEntity.ok(savedDoctor);
	    }

	    @GetMapping("/get")
	    public List<Doctor> getAllDoctorDetails() {
	        return doctorService.getAllDoctorDetails();
	    }

	    @GetMapping("/get/{id}")
	    public ResponseEntity<Doctor> getDoctorById(@PathVariable("id") long id) {
	        Doctor doctor = doctorService.getDoctorById(id);
	        if (doctor == null) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok(doctor);
	    }

	    @GetMapping("/get/find/{name}")
	    public ResponseEntity<Doctor> getDoctorByName(@PathVariable("name") String name) {
	        Doctor doctor = doctorService.getDoctorByName(name);
	        if (doctor == null) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok(doctor);
	    }
	    

	    @PutMapping("/update")
	    public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor) {
	        Doctor updatedDoctor = doctorService.updateDoctor(doctor);
	        return ResponseEntity.ok(updatedDoctor);
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<Void> deleteById(@PathVariable("id") long id) {
	        doctorService.deleteById(id);
	        return ResponseEntity.ok().build();
	    }
}
