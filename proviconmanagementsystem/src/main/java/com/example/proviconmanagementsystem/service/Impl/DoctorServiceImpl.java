package com.example.proviconmanagementsystem.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.proviconmanagementsystem.GlobalExceptionHandler.DoctorAlredyExistsException;
import com.example.proviconmanagementsystem.GlobalExceptionHandler.DoctorNotFoundException;
import com.example.proviconmanagementsystem.dto.DoctorRequestDTO;
import com.example.proviconmanagementsystem.dto.DoctorResponseDTO;
import com.example.proviconmanagementsystem.modal.Doctor;
import com.example.proviconmanagementsystem.repository.DoctorRepository;
import com.example.proviconmanagementsystem.service.DoctorService;
@Service
public class DoctorServiceImpl implements DoctorService {
	@Autowired
private DoctorRepository doctorRepository;
	@Override
	public DoctorResponseDTO createDoctor(DoctorRequestDTO doctorRequestDTO) {
		// TODO Auto-generated method stub
		if(doctorRepository.existsBydoctorName(doctorRequestDTO.getDoctorName())) {
			throw new DoctorAlredyExistsException("Doctor already exists "+ doctorRequestDTO.getDoctorName());
		}
		Doctor doctor=new Doctor();
		doctor.setDoctorName(doctorRequestDTO.getDoctorName());
		doctor.setDoctorAddress(doctorRequestDTO.getDoctorAddress());
		doctor.setDoctorDepartment(doctorRequestDTO.getDoctorDepartment());
		doctor.setDoctorSpecialization(doctorRequestDTO.getDoctorSpecialization());
		Doctor savedDoctor=doctorRepository.save(doctor);
		DoctorResponseDTO doctorResponseDTO=new DoctorResponseDTO();
		doctorResponseDTO.setDoctorId(savedDoctor.getDoctorId());
		doctorResponseDTO.setDoctorName(savedDoctor.getDoctorName());
		doctorResponseDTO.setDoctorAddress(savedDoctor.getDoctorAddress());
		doctorResponseDTO.setDoctorDepartment(savedDoctor.getDoctorDepartment());
		doctorResponseDTO.setDoctorSpecialization(savedDoctor.getDoctorSpecialization());
		return doctorResponseDTO;
	}
	@Override
	public List<DoctorResponseDTO> getAllDoctors() {
		// TODO Auto-generated method stub
		return doctorRepository.findAll().stream()
				.map(res ->{
					DoctorResponseDTO response=new DoctorResponseDTO();
					response.setDoctorId(res.getDoctorId());
					response.setDoctorName(res.getDoctorName());
					response.setDoctorAddress(res.getDoctorAddress());
					response.setDoctorDepartment(res.getDoctorDepartment());
					response.setDoctorSpecialization(res.getDoctorSpecialization());
					return response;
				})
				.toList();
	}
	@Override
	public DoctorResponseDTO updateDoctor(DoctorRequestDTO doctorRequestDTO, Long doctorId) {
		// TODO Auto-generated method stub
		Doctor doctor=doctorRepository.findById(doctorId)
				.orElseThrow(()-> new DoctorNotFoundException("Doctor not found"));
		if(doctorRequestDTO.getDoctorName()!=null) {
			doctor.setDoctorName(doctorRequestDTO.getDoctorName());
		}
		if(doctorRequestDTO.getDoctorAddress()!=null) {
			doctor.setDoctorAddress(doctorRequestDTO.getDoctorAddress());
		}
		if(doctorRequestDTO.getDoctorDepartment()!=null) {
			doctor.setDoctorDepartment(doctorRequestDTO.getDoctorDepartment());
		}
		if(doctorRequestDTO.getDoctorSpecialization()!=null) {
			doctor.setDoctorSpecialization(doctorRequestDTO.getDoctorSpecialization());
		}
		Doctor saveddoctor=doctorRepository.save(doctor);
		DoctorResponseDTO doctorResponseDTO=new DoctorResponseDTO();
		doctorResponseDTO.setDoctorId(saveddoctor.getDoctorId());
		doctorResponseDTO.setDoctorName(saveddoctor.getDoctorName());
		doctorResponseDTO.setDoctorAddress(saveddoctor.getDoctorAddress());
		doctorResponseDTO.setDoctorDepartment(saveddoctor.getDoctorDepartment());
		doctorResponseDTO.setDoctorSpecialization(saveddoctor.getDoctorSpecialization());
		return doctorResponseDTO;
	}
	@Override
	public void deleteById(Long doctorId) {
		// TODO Auto-generated method stub
		doctorRepository.deleteById(doctorId);
	}
	@Override
	public ResponseEntity<DoctorResponseDTO> getDoctorById(Long doctorId) {
		// TODO Auto-generated method stub
		Doctor doctor =doctorRepository.findById(doctorId)
				.orElseThrow(()-> new DoctorNotFoundException("Doctor not found"));
		DoctorResponseDTO response=new DoctorResponseDTO();
		response.setDoctorId(doctor.getDoctorId());
		response.setDoctorName(doctor.getDoctorName());
		response.setDoctorAddress(doctor.getDoctorAddress());
		response.setDoctorDepartment(doctor.getDoctorDepartment());
		response.setDoctorSpecialization(doctor.getDoctorSpecialization());
		return ResponseEntity.ok(response);
	}

}
