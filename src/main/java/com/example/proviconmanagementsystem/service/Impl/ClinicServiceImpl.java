package com.example.proviconmanagementsystem.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.proviconmanagementsystem.GlobalExceptionHandler.ClinicAlreadyExistsException;
import com.example.proviconmanagementsystem.GlobalExceptionHandler.ClinicNotFoundException;
import com.example.proviconmanagementsystem.dto.ClinicRequestDTO;
import com.example.proviconmanagementsystem.dto.ClinicResponseDTO;
import com.example.proviconmanagementsystem.modal.Clinic;
import com.example.proviconmanagementsystem.repository.ClinicRepository;
import com.example.proviconmanagementsystem.service.ClinicService;
@Service
public class ClinicServiceImpl implements ClinicService{
	@Autowired
private ClinicRepository clinicRepository;
	@Override
	public ClinicResponseDTO createClinic(ClinicRequestDTO clinicRequestDTO) {
		// TODO Auto-generated method stub
		if(clinicRepository.existsByclinicName(clinicRequestDTO.getClinicName())) {
			throw new ClinicAlreadyExistsException("Clinic Already exists with "+ clinicRequestDTO.getClinicName() );
		}
		Clinic clinic=new Clinic();
	
		clinic.setClinicName(clinicRequestDTO.getClinicName());
		clinic.setClinicAddress(clinicRequestDTO.getClinicAddress());
		clinic.setClinicContact(clinicRequestDTO.getClinicContact());
		clinic.setClinicDepartment(clinicRequestDTO.getClinicDepartment());
		
		Clinic savedClinic=clinicRepository.save(clinic);
		
		ClinicResponseDTO cs=new ClinicResponseDTO();
		cs.setClinicId(savedClinic.getClinicId());
		cs.setClinicName(savedClinic.getClinicName());
		cs.setClinicAddress(savedClinic.getClinicAddress());
		cs.setClinicContact(savedClinic.getClinicContact());
		cs.setClinicDepartment(savedClinic.getClinicDepartment());
		Clinic exist=clinicRepository.findById(clinic.getClinicId())
				.orElseThrow(()-> new RuntimeException("Clinic already exists"));
		
		return cs;
	}
	@Override
	public List<ClinicResponseDTO> getAllClinics() {
		// TODO Auto-generated method stub
		return clinicRepository.findAll().stream()
				.map(res ->{
					ClinicResponseDTO response=new ClinicResponseDTO();
					response.setClinicId(res.getClinicId());
					response.setClinicName(res.getClinicName());
					response.setClinicAddress(res.getClinicAddress());
					response.setClinicContact(res.getClinicContact());
					response.setClinicDepartment(res.getClinicDepartment());
					return response;
				})
				.toList();
	}
	@Override
	public ClinicResponseDTO updateClinic(ClinicRequestDTO clinicRequestDTO, Long clinicId) {
		// TODO Auto-generated method stub
		Clinic clinic=clinicRepository.findById(clinicId)
				.orElseThrow(()-> new ClinicNotFoundException("Clinic not found"));
		if(clinicRequestDTO.getClinicName() != null) {
			clinic.setClinicName(clinicRequestDTO.getClinicName());
		}
		if(clinicRequestDTO.getClinicAddress()!= null) {
			clinic.setClinicAddress(clinicRequestDTO.getClinicAddress());
		}
		if(clinicRequestDTO.getClinicContact()!=null) {
			clinic.setClinicContact(clinicRequestDTO.getClinicContact());
		}
	if(clinicRequestDTO.getClinicDepartment()!=null) {
		clinic.setClinicDepartment(clinicRequestDTO.getClinicDepartment());
	}
	Clinic savedClinic=clinicRepository.save(clinic);
	ClinicResponseDTO response=new ClinicResponseDTO();
	response.setClinicId(savedClinic.getClinicId());
	response.setClinicName(savedClinic.getClinicName());
	response.setClinicAddress(savedClinic.getClinicAddress());
	response.setClinicContact(savedClinic.getClinicContact());
	response.setClinicDepartment(savedClinic.getClinicDepartment());
	return response;
	}
	@Override
	public void deleteById(Long clinicId) {
		// TODO Auto-generated method stub
		clinicRepository.deleteById(clinicId);	}
	@Override
	public ResponseEntity<ClinicResponseDTO> getClinicById(Long clinicId) {
		// TODO Auto-generated method stub
		Clinic clinic=clinicRepository.findById(clinicId)
				.orElseThrow(()->new ClinicNotFoundException("clinic not found"));
		ClinicResponseDTO clinicResponseDTO=new ClinicResponseDTO();
		clinicResponseDTO.setClinicId(clinic.getClinicId());
		clinicResponseDTO.setClinicName(clinic.getClinicName());
		clinicResponseDTO.setClinicAddress(clinic.getClinicAddress());
		clinicResponseDTO.setClinicContact(clinic.getClinicContact());
		clinicResponseDTO.setClinicDepartment(clinic.getClinicDepartment());
		return ResponseEntity.ok(clinicResponseDTO);
	}
		@Override
	public Clinic insertClinic(Clinic clinic) {
		Clinic existingClinic=clinicRepository.findById(clinic.getClinicId()).orElse(null);
	    if(existingClinic != null) {
	    	throw new RuntimeException(("clinic already exists"));
	    }
	    return clinicRepository.save(clinic);
	}
	
	

	


	

}
