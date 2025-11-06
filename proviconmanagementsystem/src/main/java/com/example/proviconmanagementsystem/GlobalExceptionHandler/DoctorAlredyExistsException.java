package com.example.proviconmanagementsystem.GlobalExceptionHandler;

public class DoctorAlredyExistsException extends RuntimeException {
public DoctorAlredyExistsException(String msg) {
	super(msg);
}
}
