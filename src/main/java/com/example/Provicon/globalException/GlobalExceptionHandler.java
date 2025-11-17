package com.example.Provicon.globalException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler({DoctorNotFoundException.class})
public ResponseEntity<Object> handleStudentNotFoundException(DoctorNotFoundException exception){
		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(exception.getMessage());
	}
	@ExceptionHandler({ClinicNotFoundException.class})
	public ResponseEntity<Object> handleClinicNotFoundException(ClinicNotFoundException clinicException ){
		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(clinicException.getMessage());
	}
	@ExceptionHandler({StaffNotFoundException.class})
	public ResponseEntity<Object> handleStaffNotFoundException(StaffNotFoundException ex) {
		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(ex.getMessage());
	}
	@ExceptionHandler({DoctorSchduleNotFoundException.class})
	public ResponseEntity<Object> handleDoctorSchduleNotFoundException(DoctorSchduleNotFoundException ee){
		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(ee.getMessage());
	}
	@ExceptionHandler({StaffSchduleNotFoundException.class})
	public ResponseEntity<Object> handleStaffSchduleNotFoundException(StaffSchduleNotFoundException ss){
		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(ss.getMessage());
	}
	@ExceptionHandler({ClinicAlreadyExistsException.class})
	public ResponseEntity<Object> handleClinicAlreadyExistsException(ClinicAlreadyExistsException ce) {
		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(ce.getMessage());
	}
}
