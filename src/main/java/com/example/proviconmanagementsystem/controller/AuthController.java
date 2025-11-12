package com.example.proviconmanagementsystem.controller;

import java.util.Map;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.proviconmanagementsystem.dto.LoginRequestDTO;
import com.example.proviconmanagementsystem.dto.LoginResponseDTO;
import com.example.proviconmanagementsystem.dto.RegisterRequestDTO;
import com.example.proviconmanagementsystem.dto.RegisterResponseDTO;
import com.example.proviconmanagementsystem.modal.Role;
import com.example.proviconmanagementsystem.modal.User;
import com.example.proviconmanagementsystem.repository.UserRepository;
import com.example.proviconmanagementsystem.security.JwtTokenProvider;
import com.example.proviconmanagementsystem.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
private final AuthService authService;

public AuthController(AuthService authService) {
	super();
	this.authService = authService;
}
@PostMapping("/register")
public ResponseEntity<RegisterResponseDTO> register(@RequestBody RegisterRequestDTO request){
	RegisterResponseDTO response=authService.register(request);
	return ResponseEntity.ok(response);
	
}
@PostMapping("/login")
public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO request){
	LoginResponseDTO response=authService.login(request);
	return ResponseEntity.ok(response);
}
@PostMapping("/registerAdmin")
@PreAuthorize("hasRole('ADMIN')")
public ResponseEntity<RegisterResponseDTO> registerAdmin(@RequestBody RegisterRequestDTO request){
	RegisterResponseDTO response=authService.registerAdmin(request);
	return ResponseEntity.ok(response);
}
	
	
}
