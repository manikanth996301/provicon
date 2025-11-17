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

import com.example.Provicon.model.Staff;
import com.example.Provicon.service.StaffService;

@RestController
@RequestMapping("/staff")
public class StaffController {
	@Autowired
private StaffService staffService;
	  @PostMapping("/add/{enter}")
	    public ResponseEntity<Staff> addStaff(@RequestBody Staff staff,@PathVariable("enter") Long clinicId) {
	        Staff savedStaff = staffService.addStaff(staff,clinicId);
	        return ResponseEntity.ok(savedStaff);
	    }

	    @GetMapping("/get")
	    public List<Staff> getAllStaff() {
	        return staffService.getAllStaff();
	    }

	    @GetMapping("/get/{id}")
	    public ResponseEntity<Staff> getStaffById(@PathVariable("id") long id) {
	        Staff staff = staffService.getStaffById(id);
	        if (staff == null) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok(staff);
	    }
	    @GetMapping("/get/find/{name}")
	    public ResponseEntity<Staff> getStaffByName(@PathVariable("name") String name ) {
	        Staff staff = staffService.getStaffByName(name);
	        if (staff == null) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok(staff);
	    }

	    @PutMapping("/update")
	    public ResponseEntity<Staff> updateStaff(@RequestBody Staff staff) {
	        Staff updatedStaff = staffService.updateStaff(staff);
	        return ResponseEntity.ok(updatedStaff);
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<Void> deleteById(@PathVariable("id") long id) {
	        staffService.deleteById(id);
	        return ResponseEntity.ok().build();
	    }
	
}
