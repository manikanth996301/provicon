package com.example.proviconmanagementsystem.GlobalExceptionHandler;

public class StaffAlreadyExistsException extends RuntimeException{
public StaffAlreadyExistsException(String msg) {
	super(msg);
}
}
