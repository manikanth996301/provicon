package com.example.proviconmanagementsystem.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proviconmanagementsystem.GlobalExceptionHandler.ClinicNotFoundException;
import com.example.proviconmanagementsystem.GlobalExceptionHandler.DoctorNotFoundException;
import com.example.proviconmanagementsystem.GlobalExceptionHandler.DoctorSchduleAlreadyExistsException;
import com.example.proviconmanagementsystem.GlobalExceptionHandler.DoctorSchduleNotFoundException;
import com.example.proviconmanagementsystem.dto.DoctorSchduleRequestDTO;
import com.example.proviconmanagementsystem.dto.DoctorSchduleResponseDTO;
import com.example.proviconmanagementsystem.modal.Clinic;
import com.example.proviconmanagementsystem.modal.Doctor;
import com.example.proviconmanagementsystem.modal.DoctorSchdule;
import com.example.proviconmanagementsystem.repository.ClinicRepository;
import com.example.proviconmanagementsystem.repository.DoctorRepository;
import com.example.proviconmanagementsystem.repository.DoctorSchduleRepository;
import com.example.proviconmanagementsystem.service.DoctorSchduleService;
@Service
public class DoctorSchduleServiceImpl implements DoctorSchduleService {
	@Autowired
	private DoctorSchduleRepository doctorSchduleRepository;
	@Autowired
	private ClinicRepository clinicRepository;
	@Autowired
	private DoctorRepository doctorRepository;
	@Override
	public DoctorSchduleResponseDTO createSchdule(DoctorSchduleRequestDTO doctorSchduleRequestDTO,Long clinicId, Long doctorId) {
		// TODO Auto-generated method stub
		if(doctorSchduleRepository.existsByworkingDays(doctorSchduleRequestDTO.getWorkingDays())) {
			throw new DoctorSchduleAlreadyExistsException("Doctor schdule already exists "+ doctorSchduleRequestDTO.getWorkingDays());
		}
		Clinic clinic=clinicRepository.findById(clinicId)
				.orElseThrow(()-> new ClinicNotFoundException("Clinic not found "));
		Doctor doctor=doctorRepository.findById(doctorId)                .orElseThrow(()-> new DoctorNotFoundException("Doctor not found"));
		DoctorSchdule schdule=new DoctorSchdule();
	
		schdule.setWorkingDays(doctorSchduleRequestDTO.getWorkingDays());
		schdule.setStartTime(doctorSchduleRequestDTO.getStartTime());
		schdule.setEndTime(doctorSchduleRequestDTO.getEndTime());
		schdule.setDoctor(doctor);
		schdule.setClinic(clinic);
		DoctorSchdule savedSchdule=doctorSchduleRepository.save(schdule);
		DoctorSchduleResponseDTO response=new DoctorSchduleResponseDTO();
		response.setSchduleId(savedSchdule.getSchduleId());
		response.setWorkingDays(savedSchdule.getWorkingDays());
		response.setStartTime(savedSchdule.getStartTime());
		response.setEndTime(savedSchdule.getEndTime());
		return response;
	}
	@Override
	public List<DoctorSchduleResponseDTO> getAllDoctorSchdules() {
		// TODO Auto-generated method stub
		return doctorSchduleRepository.findAll().stream()
				.map(res->{
					DoctorSchduleResponseDTO response=new DoctorSchduleResponseDTO();
					response.setSchduleId(res.getSchduleId());
					response.setWorkingDays(res.getWorkingDays());
					response.setStartTime(res.getStartTime());
					response.setEndTime(res.getEndTime());
					return response;
				}).toList();
	}
	@Override
	public DoctorSchduleResponseDTO getDoctorSchduleById(Long schduleId) {
		// TODO Auto-generated method stub
		DoctorSchdule schdule=doctorSchduleRepository.findById(schduleId)
				.orElseThrow(()-> new DoctorSchduleNotFoundException("Docotor schdule not found"));
		DoctorSchduleResponseDTO response=new DoctorSchduleResponseDTO();
		response.setSchduleId(schdule.getSchduleId());
		response.setWorkingDays(schdule.getWorkingDays());
		response.setStartTime(schdule.getStartTime());
		response.setEndTime(schdule.getEndTime());
		return response;
	}
	@Override
	public DoctorSchduleResponseDTO updateDoctorSchduleById(DoctorSchduleRequestDTO doctorSchduleRequestDTO,
			Long schduleId) {
		// TODO Auto-generated method stub
		DoctorSchdule schdule=doctorSchduleRepository.findById(schduleId)
				.orElseThrow(()->new DoctorSchduleNotFoundException("Doctor Schdule not found"));
		if(doctorSchduleRequestDTO.getWorkingDays()!=null) {
			schdule.setWorkingDays(doctorSchduleRequestDTO.getWorkingDays());
		}
		if(doctorSchduleRequestDTO.getStartTime()!=null) {
			schdule.setStartTime(doctorSchduleRequestDTO.getStartTime());
		}
		if(doctorSchduleRequestDTO.getEndTime()!=null) {
			schdule.setEndTime(doctorSchduleRequestDTO.getEndTime());
		}
		DoctorSchdule saveSchdule=doctorSchduleRepository.save(schdule);
		DoctorSchduleResponseDTO response = new DoctorSchduleResponseDTO();
		response.setSchduleId(saveSchdule.getSchduleId());
		response.setWorkingDays(saveSchdule.getWorkingDays());
		response.setStartTime(saveSchdule.getStartTime());
		response.setEndTime(saveSchdule.getEndTime());
		return response ;
	}
	@Override
	public void deleteById(Long schduleId) {
		// TODO Auto-generated method stub
		doctorSchduleRepository.deleteById(schduleId);
	}

}
