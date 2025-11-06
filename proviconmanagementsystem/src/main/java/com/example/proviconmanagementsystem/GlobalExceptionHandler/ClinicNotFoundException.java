package com.example.proviconmanagementsystem.GlobalExceptionHandler;

public class ClinicNotFoundException extends RuntimeException {
public ClinicNotFoundException(String msg) {
	super(msg);
}
}
