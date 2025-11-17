package com.example.Provicon.globalException;

public class ClinicNotFoundException extends RuntimeException {
public ClinicNotFoundException(String msg) {
	super(msg);
}
}
