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

import com.example.Provicon.model.DoctorSchdule;
import com.example.Provicon.service.DoctorSchduleService;

@RestController
@RequestMapping("/Schdule")
public class DoctorSchduleController {
	@Autowired
	private DoctorSchduleService doctorSchduleService;
	 @PostMapping("/add/{enter}")
	    public ResponseEntity<DoctorSchdule> addDoctorSchdule(@RequestBody DoctorSchdule doctorSchdule,
	    		@PathVariable("enter") Long clinicId,@PathVariable("enter") Long doctorId) {
	        DoctorSchdule saved = doctorSchduleService.addDoctorSchdule(doctorSchdule,doctorId,clinicId);
	        return ResponseEntity.ok(saved);
	    }
	    @GetMapping("/get")
	    public List<DoctorSchdule> getAllSchdule() {
	        return doctorSchduleService.getAllSchdule();
	    }

	    @GetMapping("/get/{id}")
	    public ResponseEntity<DoctorSchdule> getSchduleById(@PathVariable("id") long id) {
	        DoctorSchdule schedule = doctorSchduleService.getSchduleById(id);
	        if (schedule == null) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok(schedule);
	    }

	    @PutMapping("/update")
	    public ResponseEntity<DoctorSchdule> updateSchdule(@RequestBody DoctorSchdule doctorSchdule) {
	        DoctorSchdule updatedSchedule = doctorSchduleService.updateSchdule(doctorSchdule);
	        return ResponseEntity.ok(updatedSchedule);
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<Void> deleteById(@PathVariable("id") long id) {
	        doctorSchduleService.deleteById(id);
	        return ResponseEntity.ok().build();
	    }
}
