package com.example.proviconmanagementsystem.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.proviconmanagementsystem.dto.StaffRequestDTO;
import com.example.proviconmanagementsystem.dto.StaffResponseDTO;

public interface StaffService {

	StaffResponseDTO createStaff(StaffRequestDTO staffRequestDTO, Long clinicId);

	List<StaffResponseDTO> getAllStaff();

	StaffResponseDTO getStaffById(Long staffId);

	StaffResponseDTO updateStaffById(StaffRequestDTO staffRequestDTO, Long doctorId);

	void deleteById(Long staffId);

}
