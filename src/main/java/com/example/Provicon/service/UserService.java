package com.example.Provicon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Provicon.dto.UserRequestDTO;
import com.example.Provicon.dto.UserResponseDTO;
import com.example.Provicon.model.User;
import com.example.Provicon.repository.UserRepo;

@Service
public class UserService {
	@Autowired
private UserRepo  userRepo;

public UserResponseDTO createResponse(UserRequestDTO userRequestDTO) {
	// TODO Auto-generated method stub
	//creating a new user
	//converting request dto -> entity
User user=new User();
user.setName(userRequestDTO.getName());
user.setEmail(userRequestDTO.getEmail());
user.setPasswod(userRequestDTO.getPassword());

// save entity to db
User saveduser=userRepo.save(user);
// convert entity -> response dto
UserResponseDTO userResponseDTO=new UserResponseDTO();
userResponseDTO.setId(saveduser.getId());
userResponseDTO.setName(saveduser.getName());
userResponseDTO.setEmail(saveduser.getEmail());

	return userResponseDTO;
}

public List<UserResponseDTO> getAllResponses() {
	// TODO Auto-generated method stub
	
	
	return userRepo.findAll()
			.stream()
			.map(user->{
				UserResponseDTO dto=new UserResponseDTO();
				dto.setId(user.getId());
				dto.setName(user.getName());
				dto.setEmail(user.getEmail());
				return dto;
			
			})
			.toList();
}

public UserResponseDTO login(String name, String password) {
	// TODO Auto-generated method stub
	User user=userRepo.findByName(name)
			.orElseThrow(()->new RuntimeException("User not found"));
	if(!user.getPasswod().equals(password)) {
		throw new RuntimeException("Invalid password");
	}
		UserResponseDTO userResponseDTO=new UserResponseDTO();
		userResponseDTO.setId(user.getId());
		userResponseDTO.setName(user.getName());
		userResponseDTO.setEmail(user.getPasswod());
		return userResponseDTO;
	
	
}
}

