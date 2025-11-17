package com.example.Provicon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Provicon.dto.UserRequestDTO;
import com.example.Provicon.dto.UserResponseDTO;
import com.example.Provicon.service.UserService;

@RestController
@RequestMapping("/request")
public class UserController {
	@Autowired
	private UserService userService;
	@PostMapping("/create")
public ResponseEntity<UserResponseDTO> createResponse(@RequestBody UserRequestDTO userRequestDTO){
	UserResponseDTO response=userService.createResponse(userRequestDTO);
	return ResponseEntity.ok(response);
}
	@PostMapping("/login")
	public ResponseEntity<UserResponseDTO> login(@RequestBody UserRequestDTO userRequestDTO){
		UserResponseDTO response=userService.login(userRequestDTO.getName(),userRequestDTO.getPassword());
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	@GetMapping("/get")
public ResponseEntity<List<UserResponseDTO>> getAllResponses(){
	List<UserResponseDTO> users=userService.getAllResponses();
	return ResponseEntity.ok(users);
}
}
