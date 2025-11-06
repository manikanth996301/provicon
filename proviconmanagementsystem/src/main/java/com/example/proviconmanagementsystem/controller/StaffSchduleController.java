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

import com.example.proviconmanagementsystem.dto.StaffSchduleRequestDTO;
import com.example.proviconmanagementsystem.dto.StaffSchduleResponseDTO;
import com.example.proviconmanagementsystem.service.StaffSchduleService;

@RestController
@RequestMapping("/StaffSchdule")
public class StaffSchduleController {
	@Autowired
	private StaffSchduleService staffSchduleService;
	@PostMapping("/add/{id}")
	public ResponseEntity<StaffSchduleResponseDTO> createStaffSchdule(@RequestBody StaffSchduleRequestDTO staffSchduleRequestDTO,@PathVariable("id")Long staffSchduleId){
		StaffSchduleResponseDTO response=staffSchduleService.createStaffSchdule(staffSchduleRequestDTO,staffSchduleId);
		return ResponseEntity.ok(response);
	}
	@GetMapping("/get")
	public List<StaffSchduleResponseDTO> getAllStaffSchdules(){
		return staffSchduleService.getAllStaffSchdules();
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<StaffSchduleResponseDTO> getStaffSchduleById(@PathVariable("id")Long staffSchduleId){
		StaffSchduleResponseDTO response=staffSchduleService.getStaffSchduleById(staffSchduleId);
		return ResponseEntity.ok(response);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<StaffSchduleResponseDTO> updateStaffSchduleById(@RequestBody StaffSchduleRequestDTO staffSchduleRequestDTO,@PathVariable("id")Long staffSchduleId){
		StaffSchduleResponseDTO response=staffSchduleService.updateStaffSchduleById(staffSchduleRequestDTO,staffSchduleId);
		return ResponseEntity.ok(response);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id")Long staffSchduleId){
		staffSchduleService.deleteById(staffSchduleId);
		return ResponseEntity.ok().build();
	}
}
