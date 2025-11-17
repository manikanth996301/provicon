package com.example.Provicon.globalException;

public class DoctorNotFoundException extends RuntimeException {
public DoctorNotFoundException(String msg) {
	super(msg);
}
}
