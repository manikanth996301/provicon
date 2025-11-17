package com.example.Provicon.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
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

import com.example.Provicon.model.StaffSchdule;
import com.example.Provicon.service.StaffSchduleService;

@RestController
@RequestMapping("/staffSchdule")
public class StaffSchduleController {
	@Autowired
	private StaffSchduleService staffSchduleService;

    @PostMapping("/add/{enter}")
    public ResponseEntity<StaffSchdule> addStaffSchdule(@RequestBody StaffSchdule staffSchdule,@PathVariable("enter") Long staffId) {
        StaffSchdule savedSchdule = staffSchduleService.addStaffSchdule(staffSchdule,staffId);
        return ResponseEntity.ok(savedSchdule);
    }


    @GetMapping("/get")
    public List<StaffSchdule> getAllStaffSchdules() {
        return staffSchduleService.getAllStaffSchdules();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<StaffSchdule> getStaffSchduleById(@PathVariable("id") long id) {
        StaffSchdule schdule = staffSchduleService.getStaffSchduleById(id);
        if (schdule == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(schdule);
    }

 

    
    @PutMapping("/update")
    public ResponseEntity<StaffSchdule> updateStaffSchdule(@RequestBody StaffSchdule staffSchdule) {
        StaffSchdule updatedSchdule = staffSchduleService.updateStaffSchdule(staffSchdule);
        return ResponseEntity.ok(updatedSchdule);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStaffSchdule(@PathVariable("id") long id) {
        staffSchduleService.deleteStaffSchdule(id);
        return ResponseEntity.ok().build();
    }
}
