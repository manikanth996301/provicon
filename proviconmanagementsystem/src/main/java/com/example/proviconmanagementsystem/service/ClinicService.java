package com.example.proviconmanagementsystem.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.proviconmanagementsystem.dto.ClinicRequestDTO;
import com.example.proviconmanagementsystem.dto.ClinicResponseDTO;
import com.example.proviconmanagementsystem.modal.Clinic;

public interface ClinicService {

	ClinicResponseDTO createClinic(ClinicRequestDTO clinicRequestDTO);

	List<ClinicResponseDTO> getAllClinics();

	ClinicResponseDTO updateClinic(ClinicRequestDTO clinicRequestDTO, Long clinicId);

	void deleteById(Long clinicId);

	ResponseEntity<ClinicResponseDTO> getClinicById(Long clinicId);
    
	 Clinic insertClinic(Clinic clinic);
	


	

}
