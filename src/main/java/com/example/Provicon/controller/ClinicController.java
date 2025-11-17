package com.example.Provicon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Provicon.model.Clinic;
import com.example.Provicon.service.ClinicService;

@RestController
@RequestMapping("/clinic")
public class ClinicController {
	@Autowired
	private ClinicService clinicService;
	 @PostMapping("/add")
	    public ResponseEntity<Clinic> addClinicDetails(@RequestBody Clinic clinic) {
	     
		 Clinic savedClinic = clinicService.addClinicDetails(clinic);
	        return ResponseEntity.ok(savedClinic);
	     
	     }

	    @GetMapping("/get")
	    public List<Clinic> getAllClinicDetails() {
	        return clinicService.getAllClinicDetails();
	    }

	    @GetMapping("/get/{id}")
	    public ResponseEntity<Clinic> getClinicById(@PathVariable("id") long id) {
	        Clinic clinic = clinicService.getClinicById(id);
	        if (clinic == null) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok(clinic);
	    }
	    @GetMapping("/get/search/{number}")
	    public ResponseEntity<Clinic > getClinicByNo(@PathVariable("number") String no){
    	Clinic clinic=clinicService.getClinicByNo(no);
    	if(clinic == null) {
	    			
    			
	    			
    	return ResponseEntity.notFound().build();
	    	}
	    	return ResponseEntity.ok(clinic);
	    }
	    @GetMapping("/get/find")
	    public ResponseEntity<Clinic > getClinicByName(@RequestParam("name") String name){
    	Clinic clinic=clinicService.getClinicByName(name);
    	if(clinic == null) {
	    			
    			
	    			
    	return ResponseEntity.notFound().build();
	    	}
	    	return ResponseEntity.ok(clinic);
	    }

	    @PutMapping("/update")
	    public ResponseEntity<Clinic> updateClinicDetails(@RequestBody Clinic clinic) {
	        Clinic updatedClinic = clinicService.updateClinicDetails(clinic);
	        return ResponseEntity.ok(updatedClinic);
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<Void> deleteClinicDetails(@PathVariable("id") long id) {
	        clinicService.deleteClinicDetails(id);
	        return ResponseEntity.ok().build();
	    }
	
}
