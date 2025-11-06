package com.example.proviconmanagementsystem.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.proviconmanagementsystem.GlobalExceptionHandler.ClinicNotFoundException;
import com.example.proviconmanagementsystem.GlobalExceptionHandler.StaffAlreadyExistsException;
import com.example.proviconmanagementsystem.GlobalExceptionHandler.StaffNotFoundException;
import com.example.proviconmanagementsystem.dto.ClinicResponseDTO;
import com.example.proviconmanagementsystem.dto.StaffRequestDTO;
import com.example.proviconmanagementsystem.dto.StaffResponseDTO;
import com.example.proviconmanagementsystem.modal.Clinic;
import com.example.proviconmanagementsystem.modal.Staff;
import com.example.proviconmanagementsystem.repository.ClinicRepository;
import com.example.proviconmanagementsystem.repository.StaffRepository;
import com.example.proviconmanagementsystem.service.StaffService;
@Service
public class StaffServiceImpl implements StaffService {
	@Autowired
private StaffRepository staffRepository;
	@Autowired
	private ClinicRepository clinicRepository;
	@Override
	public StaffResponseDTO createStaff(StaffRequestDTO staffRequestDTO, Long clinicId) {
		// TODO Auto-generated method stub
		if(staffRepository.existsBystaffName(staffRequestDTO.getStaffName())) {
			throw new StaffAlreadyExistsException("Staff Already Exists "+ staffRequestDTO.getStaffName());
		}
		Clinic clinic=clinicRepository.findById(clinicId).orElseThrow(()->new 
				ClinicNotFoundException("clinic not found"));
	
	
		
		Staff staff=new Staff();
		staff.setStaffName(staffRequestDTO.getStaffName());
		staff.setStaffAddress(staffRequestDTO.getStaffAddress());
		staff.setStaffDepartment(staffRequestDTO.getStaffDepartment());
		staff.setClinic(clinic);
		Staff savedStaff=staffRepository.save(staff);
		StaffResponseDTO response=new StaffResponseDTO();
		response.setStaffId(savedStaff.getStaffId());
		response.setStaffName(savedStaff.getStaffName());
		response.setStaffAddress(savedStaff.getStaffAddress());
		response.setStaffDepartment(savedStaff.getStaffDepartment());
	
		
				return response;
	}
	@Override
	public List<StaffResponseDTO> getAllStaff() {
		// TODO Auto-generated method stub
		return staffRepository.findAll().stream()
				.map(res->{
					StaffResponseDTO response=new StaffResponseDTO();
					response.setStaffId(res.getStaffId());
					response.setStaffName(res.getStaffName());
					response.setStaffAddress(res.getStaffAddress());
					response.setStaffDepartment(res.getStaffDepartment());
					return response;
				})
				.toList();
	}
	@Override
	public StaffResponseDTO getStaffById(Long staffId) {
		// TODO Auto-generated method stub
		Staff staff=staffRepository.findById(staffId)
				.orElseThrow(()-> new StaffNotFoundException("staff not found"));
		StaffResponseDTO response = new StaffResponseDTO();
		response.setStaffId(staff.getStaffId());
		response.setStaffName(staff.getStaffName());
		response.setStaffAddress(staff.getStaffAddress());
		response.setStaffDepartment(staff.getStaffDepartment());
		return response;
	}
	@Override
	public StaffResponseDTO updateStaffById(StaffRequestDTO staffRequestDTO, Long doctorId) {
		// TODO Auto-generated method stub
		Staff staff=staffRepository.findById(doctorId)
				.orElseThrow(()-> new StaffNotFoundException("staff not found"));
		if(staffRequestDTO.getStaffName()!=null) {
			staff.setStaffName(staffRequestDTO.getStaffName());
		}
		if(staffRequestDTO.getStaffAddress()!=null) {
			staff.setStaffAddress(staffRequestDTO.getStaffAddress());
		}
		if(staffRequestDTO.getStaffDepartment()!=null) {
			staff.setStaffDepartment(staffRequestDTO.getStaffDepartment());
		}
		Staff savedStaff=staffRepository.save(staff);
		StaffResponseDTO response=new StaffResponseDTO();
		response.setStaffId(savedStaff.getStaffId());
		response.setStaffName(savedStaff.getStaffName());
		response.setStaffAddress(savedStaff.getStaffAddress());
		response.setStaffDepartment(savedStaff.getStaffDepartment());
		return response;
	}
	@Override
	public void deleteById(Long staffId) {
		// TODO Auto-generated method stub
		staffRepository.deleteById(staffId);
	}
	

}
