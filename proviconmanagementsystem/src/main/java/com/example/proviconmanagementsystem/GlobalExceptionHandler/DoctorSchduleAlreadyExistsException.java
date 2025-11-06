package com.example.proviconmanagementsystem.GlobalExceptionHandler;

public class DoctorSchduleAlreadyExistsException extends RuntimeException{
public DoctorSchduleAlreadyExistsException(String msg) {
	super(msg);
}
}
