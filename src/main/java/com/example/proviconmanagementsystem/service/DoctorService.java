package com.example.proviconmanagementsystem.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.proviconmanagementsystem.dto.DoctorRequestDTO;
import com.example.proviconmanagementsystem.dto.DoctorResponseDTO;

public interface DoctorService {

	DoctorResponseDTO createDoctor(DoctorRequestDTO doctorRequestDTO);

	List<DoctorResponseDTO> getAllDoctors();

	DoctorResponseDTO updateDoctor(DoctorRequestDTO doctorRequestDTO, Long doctorId);

	void deleteById(Long doctorId);

	ResponseEntity<DoctorResponseDTO> getDoctorById(Long doctorId);

}
