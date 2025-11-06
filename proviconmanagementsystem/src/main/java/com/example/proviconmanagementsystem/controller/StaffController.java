package com.example.proviconmanagementsystem.controller;

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

import com.example.proviconmanagementsystem.dto.StaffRequestDTO;
import com.example.proviconmanagementsystem.dto.StaffResponseDTO;
import com.example.proviconmanagementsystem.service.StaffService;

@RestController
@RequestMapping("/Staff")
public class StaffController {
	@Autowired
private StaffService staffService;
	@PostMapping("/add/{id}")
	public ResponseEntity<StaffResponseDTO> createStaff(@RequestBody StaffRequestDTO staffRequestDTO,@PathVariable("id")Long clinicId){
		StaffResponseDTO response=staffService.createStaff(staffRequestDTO,clinicId);
		return ResponseEntity.ok(response);
	}
	@GetMapping("/get")
	public List<StaffResponseDTO> getAllStaff(){
		return staffService.getAllStaff();
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<StaffResponseDTO> getStaffById(@PathVariable("id") Long staffId){
		StaffResponseDTO response=staffService.getStaffById(staffId);
		return ResponseEntity.ok(response);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<StaffResponseDTO> updateStaffById(@RequestBody StaffRequestDTO staffRequestDTO,@PathVariable("id")Long doctorId){
		StaffResponseDTO response=staffService.updateStaffById(staffRequestDTO,doctorId);
		return ResponseEntity.ok(response);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id")Long staffId){
		staffService.deleteById(staffId);
		return ResponseEntity.ok().build();
	}
}
