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

import com.example.proviconmanagementsystem.dto.DoctorSchduleRequestDTO;
import com.example.proviconmanagementsystem.dto.DoctorSchduleResponseDTO;
import com.example.proviconmanagementsystem.service.DoctorSchduleService;

@RestController
@RequestMapping("/DoctorSchdule")
public class DoctorSchduleController {
	@Autowired
private DoctorSchduleService doctorSchduleService;
	@PostMapping("/add/{id}")
	public ResponseEntity<DoctorSchduleResponseDTO> createSchdule(@RequestBody DoctorSchduleRequestDTO doctorSchduleRequestDTO,@PathVariable("id")Long clinicId,@PathVariable("id")Long doctorId){
		DoctorSchduleResponseDTO response=doctorSchduleService.createSchdule(doctorSchduleRequestDTO,clinicId,doctorId);
		return ResponseEntity.ok(response);
	}
	@GetMapping("/get")
	public List<DoctorSchduleResponseDTO> getAllDoctorSchdules(){
		return doctorSchduleService.getAllDoctorSchdules();
	}
	@GetMapping("/find/{id}")
 public ResponseEntity<DoctorSchduleResponseDTO> getDoctorSchduleById(@PathVariable("id")Long schduleId){
	 DoctorSchduleResponseDTO response=doctorSchduleService.getDoctorSchduleById(schduleId);
	 return ResponseEntity.ok(response);
 }
	@PutMapping("/update/{id}")
	public ResponseEntity<DoctorSchduleResponseDTO> updateDoctorSchduleById(@RequestBody DoctorSchduleRequestDTO doctorSchduleRequestDTO,@PathVariable("id")Long schduleId){
		DoctorSchduleResponseDTO response=doctorSchduleService.updateDoctorSchduleById(doctorSchduleRequestDTO,schduleId);
		return ResponseEntity.ok(response);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id")Long schduleId){
		doctorSchduleService.deleteById(schduleId);
		return ResponseEntity.ok().build();
	}
}
