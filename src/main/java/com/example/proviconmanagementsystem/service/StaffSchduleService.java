package com.example.proviconmanagementsystem.service;

import java.util.List;

import com.example.proviconmanagementsystem.dto.StaffSchduleRequestDTO;
import com.example.proviconmanagementsystem.dto.StaffSchduleResponseDTO;

public interface StaffSchduleService {

	StaffSchduleResponseDTO createStaffSchdule(StaffSchduleRequestDTO staffSchduleRequestDTO, Long staffSchduleId);

	List<StaffSchduleResponseDTO> getAllStaffSchdules();

	StaffSchduleResponseDTO getStaffSchduleById(Long staffSchduleId);

	StaffSchduleResponseDTO updateStaffSchduleById(StaffSchduleRequestDTO staffSchduleRequestDTO, Long staffSchduleId);

	void deleteById(Long staffSchduleId);

	

}
