package com.example.proviconmanagementsystem.GlobalExceptionHandler;

public class ClinicAlreadyExistsException extends RuntimeException{
public ClinicAlreadyExistsException(String msg) {
	super(msg);
}
}
