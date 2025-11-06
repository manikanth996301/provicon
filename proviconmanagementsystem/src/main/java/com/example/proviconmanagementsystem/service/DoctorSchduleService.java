package com.example.proviconmanagementsystem.service;

import java.util.List;

import com.example.proviconmanagementsystem.dto.DoctorSchduleRequestDTO;
import com.example.proviconmanagementsystem.dto.DoctorSchduleResponseDTO;

public interface DoctorSchduleService {

	DoctorSchduleResponseDTO createSchdule(DoctorSchduleRequestDTO doctorSchduleRequestDTO, Long clinicId, Long doctorId);

	List<DoctorSchduleResponseDTO> getAllDoctorSchdules();

	DoctorSchduleResponseDTO getDoctorSchduleById(Long schduleId);

	DoctorSchduleResponseDTO updateDoctorSchduleById(DoctorSchduleRequestDTO doctorSchduleRequestDTO, Long schduleId);

	void deleteById(Long schduleId);

}
