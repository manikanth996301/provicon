package com.example.proviconmanagementsystem.GlobalExceptionHandler;

public class DoctorNotFoundException extends RuntimeException{
public DoctorNotFoundException(String msg) {
	super(msg);
}
}
