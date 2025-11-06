package com.example.proviconmanagementsystem.GlobalExceptionHandler;

public class StaffNotFoundException extends RuntimeException{
public StaffNotFoundException(String msg) {
	super(msg);
}
}
