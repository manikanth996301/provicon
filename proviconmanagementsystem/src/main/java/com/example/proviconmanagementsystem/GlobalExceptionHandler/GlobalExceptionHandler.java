package com.example.proviconmanagementsystem.GlobalExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler({ClinicNotFoundException.class})
public ResponseEntity<Object> handleClinicNotFoundException(ClinicNotFoundException ex){
	return ResponseEntity
			.status(HttpStatus.INTERNAL_SERVER_ERROR)
			.body(ex.getMessage());
}
	@ExceptionHandler({DoctorNotFoundException.class})
	public ResponseEntity<Object> handleDoctorNotFoundException(DoctorNotFoundException de){
		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(de.getMessage());
	}
	@ExceptionHandler({StaffNotFoundException.class})
	public ResponseEntity<Object> handleStaffNotFoundException(StaffNotFoundException se){
		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(se.getMessage());
	}
	@ExceptionHandler({DoctorSchduleNotFoundException.class})
	public ResponseEntity<Object> handleDoctorSchduleNotFoundException(DoctorSchduleNotFoundException dse){
		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(dse.getMessage());
	}
	@ExceptionHandler({StaffSchduleNotFoundException.class})
	public ResponseEntity<Object> handleStaffSchduleNotFoundException(StaffSchduleNotFoundException sse){
		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(sse.getMessage());
	}
	@ExceptionHandler({ClinicAlreadyExistsException.class})
	public ResponseEntity<Object> handleClinicAlreadyExistsException(ClinicAlreadyExistsException cae){
		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				
				.body(cae.getMessage());
	}
	@ExceptionHandler({DoctorAlredyExistsException.class})
	public ResponseEntity<Object> handleDoctorAlredyExistsException(DoctorAlredyExistsException dae){
		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(dae.getMessage());
	}
	@ExceptionHandler({StaffAlreadyExistsException.class})
	public ResponseEntity<Object> handleStaffAlreadyExistsException(StaffAlreadyExistsException sae){
		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(sae.getMessage());
	}
	@ExceptionHandler({DoctorSchduleAlreadyExistsException.class})
	public ResponseEntity<Object> handleDoctorSchduleAlreadyExistsException(DoctorSchduleAlreadyExistsException dsae){
		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(dsae.getMessage());
	}
	@ExceptionHandler({StaffSchduleAlreadyExistsException.class})
	public ResponseEntity<Object> handleStaffSchduleAlreadyExistsException(StaffSchduleAlreadyExistsException ssae){
		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(ssae.getMessage());
	}
}
