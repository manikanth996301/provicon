package com.example.proviconmanagementsystem.service.Impl;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.proviconmanagementsystem.dto.LoginRequestDTO;
import com.example.proviconmanagementsystem.dto.LoginResponseDTO;
import com.example.proviconmanagementsystem.dto.RegisterRequestDTO;
import com.example.proviconmanagementsystem.dto.RegisterResponseDTO;
import com.example.proviconmanagementsystem.modal.Role;
import com.example.proviconmanagementsystem.modal.User;
import com.example.proviconmanagementsystem.repository.UserRepository;
import com.example.proviconmanagementsystem.security.JwtTokenProvider;
import com.example.proviconmanagementsystem.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService{
	private final UserRepository UserRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtTokenProvider jwtTokenProvider;
	
	public AuthServiceImpl(com.example.proviconmanagementsystem.repository.UserRepository userRepository,
			PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
		super();
		UserRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtTokenProvider = jwtTokenProvider;
	}

	@Override
	public RegisterResponseDTO register(RegisterRequestDTO request) {
		// TODO Auto-generated method stub
		if(UserRepository.findByuserName(request.getUserName()).isPresent()) {
			throw new RuntimeException("User already exists "+ request.getUserName());
		}
		User user=new User();
		user.setUserName(request.getUserName());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setRole(Set.of(Role.USER));
		UserRepository.save(user);
		//RegisterResponseDTO re=new RegisterResponseDTO();
		
		return new RegisterResponseDTO("user registered successfully", user.getUserName(), "USER");
	}

	@Override
	public LoginResponseDTO login(LoginRequestDTO request) {
		// TODO Auto-generated method stub
		User user=UserRepository.findByuserName(request.getUserName())
				.orElseThrow(()-> new RuntimeException("Invalid credentials"));
		if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
			throw new RuntimeException("Invalid credentials");
		}
		String role=user.getRole().iterator().next().name();
		String token=jwtTokenProvider.generateToken(user.getUserName(), role);
	
		return new LoginResponseDTO(token, user.getUserName(), role);
	}

	@Override
	public RegisterResponseDTO registerAdmin(RegisterRequestDTO request) {
		// TODO Auto-generated method stub
		if(UserRepository.findByuserName(request.getUserName()).isPresent()) {
			throw new RuntimeException("Admin already exists");
		}
		User adminUser=new User();
		adminUser.setUserName(request.getUserName());
		adminUser.setPassword(passwordEncoder.encode(request.getPassword()));
		adminUser.setRole(Set.of(Role.USER));
		UserRepository.save(adminUser);
	
		return new RegisterResponseDTO("Admin registered successfully", adminUser.getUserName(), "ADMIN");
	}


}
