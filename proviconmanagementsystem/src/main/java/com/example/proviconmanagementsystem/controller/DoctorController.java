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

import com.example.proviconmanagementsystem.dto.DoctorRequestDTO;
import com.example.proviconmanagementsystem.dto.DoctorResponseDTO;
import com.example.proviconmanagementsystem.service.DoctorService;

@RestController
@RequestMapping("/Doctor")
public class DoctorController {
	@Autowired
private DoctorService doctorService;
	@PostMapping("/add")
	public ResponseEntity<DoctorResponseDTO> createDoctor(@RequestBody DoctorRequestDTO doctorRequestDTO){
		DoctorResponseDTO response=doctorService.createDoctor(doctorRequestDTO);
		return ResponseEntity.ok(response);
	}
	@GetMapping("/get")
	public List<DoctorResponseDTO> getAllDoctors(){
		return doctorService.getAllDoctors();
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<DoctorResponseDTO> getDoctorById(@PathVariable("id")Long doctorId){
		return doctorService.getDoctorById(doctorId);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<DoctorResponseDTO> updateDoctor(@RequestBody DoctorRequestDTO doctorRequestDTO,@PathVariable("id") Long doctorId){
		DoctorResponseDTO response=doctorService.updateDoctor(doctorRequestDTO,doctorId);
		return ResponseEntity.ok(response);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id")Long doctorId){
		doctorService.deleteById(doctorId);
		return ResponseEntity.ok().build();
	}
}
