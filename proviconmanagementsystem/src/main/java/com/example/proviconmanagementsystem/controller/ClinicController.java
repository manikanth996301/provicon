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

import com.example.proviconmanagementsystem.dto.ClinicRequestDTO;
import com.example.proviconmanagementsystem.dto.ClinicResponseDTO;
import com.example.proviconmanagementsystem.modal.Clinic;
import com.example.proviconmanagementsystem.service.ClinicService;
@RestController
@RequestMapping("/clinic")
public class ClinicController {
	@Autowired
	private ClinicService clinicService;
@PostMapping("/add")	
public ResponseEntity<ClinicResponseDTO> createClinic(@RequestBody ClinicRequestDTO clinicRequestDTO){
	ClinicResponseDTO response=clinicService.createClinic(clinicRequestDTO);
	return ResponseEntity.ok(response);
}
@GetMapping("/get")
public List<ClinicResponseDTO> getAllClinics(){
	return clinicService.getAllClinics();
}
@GetMapping("/find/{id}")
public ResponseEntity<ClinicResponseDTO> getClinicById(@PathVariable("id")Long clinicId){
	return clinicService.getClinicById(clinicId);
}
@PutMapping("/update/{id}")	
public ResponseEntity<ClinicResponseDTO> updateClinic(@RequestBody ClinicRequestDTO clinicRequestDTO,  @PathVariable("id")  Long clinicId){
	ClinicResponseDTO response=clinicService.updateClinic(clinicRequestDTO,clinicId);
	return ResponseEntity.ok(response);
}
@DeleteMapping("/delete/{id}")
public ResponseEntity<Void> deleteById(@PathVariable("id")Long clinicId ){
	clinicService.deleteById(clinicId);
	return ResponseEntity.ok().build();
}
}
