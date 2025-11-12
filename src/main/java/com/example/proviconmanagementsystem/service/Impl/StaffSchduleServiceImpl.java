package com.example.proviconmanagementsystem.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.proviconmanagementsystem.GlobalExceptionHandler.StaffNotFoundException;
import com.example.proviconmanagementsystem.GlobalExceptionHandler.StaffSchduleAlreadyExistsException;
import com.example.proviconmanagementsystem.GlobalExceptionHandler.StaffSchduleNotFoundException;
import com.example.proviconmanagementsystem.dto.StaffSchduleRequestDTO;
import com.example.proviconmanagementsystem.dto.StaffSchduleResponseDTO;
import com.example.proviconmanagementsystem.modal.Staff;
import com.example.proviconmanagementsystem.modal.StaffSchdule;
import com.example.proviconmanagementsystem.repository.StaffRepository;
import com.example.proviconmanagementsystem.repository.StaffSchduleRepository;
import com.example.proviconmanagementsystem.service.StaffSchduleService;

@Service
public class StaffSchduleServiceImpl implements StaffSchduleService{
	@Autowired
private StaffSchduleRepository staffSchduleRepository;
	@Autowired
private StaffRepository staffRepository;
	@Override
	public StaffSchduleResponseDTO createStaffSchdule(StaffSchduleRequestDTO staffSchduleRequestDTO, Long staffSchduleId) {
		// TODO Auto-generated method stub
		if(staffSchduleRepository.existsBydayOfWeek(staffSchduleRequestDTO.getDayOfWeek())) {
			throw new StaffSchduleAlreadyExistsException("Staff Schdule already Exists");
		}
		Staff staff=staffRepository.findById(staffSchduleId)
				.orElseThrow(()-> new StaffNotFoundException("Staff not found"));
		StaffSchdule schdule=new StaffSchdule();
		schdule.setDayOfWeek(staffSchduleRequestDTO.getDayOfWeek());
		schdule.setStartTime(staffSchduleRequestDTO.getStartTime());
		schdule.setEndTime(staffSchduleRequestDTO.getEndTime());
		schdule.setStaff(staff);
		StaffSchdule savedStaffSchdule=staffSchduleRepository.save(schdule);
		StaffSchduleResponseDTO response=new StaffSchduleResponseDTO();
		response.setStaffSchduleId(savedStaffSchdule.getStaffSchduleId());
		response.setDayOfWeek(savedStaffSchdule.getDayOfWeek());
		response.setStartTime(savedStaffSchdule.getStartTime());
		response.setEndTime(savedStaffSchdule.getEndTime());
		return response;
	}

	@Override
	public List<StaffSchduleResponseDTO> getAllStaffSchdules() {
		// TODO Auto-generated method stub
		return staffSchduleRepository.findAll().stream()
				.map(res->{
					StaffSchduleResponseDTO response=new StaffSchduleResponseDTO();
					response.setStaffSchduleId(res.getStaffSchduleId());
					response.setDayOfWeek(res.getDayOfWeek());
					response.setStartTime(res.getStartTime());
					response.setEndTime(res.getEndTime());
					return response;
				})
				.toList();
	}

	@Override
	public StaffSchduleResponseDTO getStaffSchduleById(Long staffSchduleId) {
		// TODO Auto-generated method stub
		StaffSchdule staffSchdule=staffSchduleRepository.findById(staffSchduleId)
				.orElseThrow(()->new StaffSchduleNotFoundException("Staff Schdule not found"));
		StaffSchduleResponseDTO response=new StaffSchduleResponseDTO();
		response.setStaffSchduleId(staffSchdule.getStaffSchduleId());
		response.setDayOfWeek(staffSchdule.getDayOfWeek());
		response.setStartTime(staffSchdule.getStartTime());
		response.setEndTime(staffSchdule.getEndTime());
		return response;
	}

	@Override
	public StaffSchduleResponseDTO updateStaffSchduleById(StaffSchduleRequestDTO staffSchduleRequestDTO,
			Long staffSchduleId) {
		// TODO Auto-generated method stub
		StaffSchdule staffSChdule=staffSchduleRepository.findById(staffSchduleId)
				.orElseThrow(()->new StaffSchduleNotFoundException("Staff Schdule not found"));
		if(staffSchduleRequestDTO.getDayOfWeek()!=null) {
			staffSChdule.setDayOfWeek(staffSchduleRequestDTO.getDayOfWeek());
		}
			if(staffSchduleRequestDTO.getStartTime()!=null) {
			staffSChdule.setStartTime(staffSchduleRequestDTO.getStartTime());
			}
			if(staffSchduleRequestDTO.getEndTime()!=null) {
				staffSChdule.setEndTime(staffSchduleRequestDTO.getEndTime());
			}
			StaffSchdule savedStaffSchdule=staffSchduleRepository.save(staffSChdule);
			StaffSchduleResponseDTO response=new StaffSchduleResponseDTO();
			response.setStaffSchduleId(savedStaffSchdule.getStaffSchduleId());
			response.setDayOfWeek(savedStaffSchdule.getDayOfWeek());
			response.setStartTime(savedStaffSchdule.getStartTime());
			response.setEndTime(savedStaffSchdule.getEndTime());
			return response;
		}

	@Override
	public void deleteById(Long staffSchduleId) {
		// TODO Auto-generated method stub
		 staffSchduleRepository.deleteById(staffSchduleId);
	}

	

	
}
