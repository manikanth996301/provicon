package com.example.proviconmanagementsystem.service;

import com.example.proviconmanagementsystem.dto.LoginRequestDTO;
import com.example.proviconmanagementsystem.dto.LoginResponseDTO;
import com.example.proviconmanagementsystem.dto.RegisterRequestDTO;
import com.example.proviconmanagementsystem.dto.RegisterResponseDTO;


public interface AuthService {

	RegisterResponseDTO register(RegisterRequestDTO request);
	LoginResponseDTO login(LoginRequestDTO request);
	RegisterResponseDTO registerAdmin(RegisterRequestDTO request);
}
