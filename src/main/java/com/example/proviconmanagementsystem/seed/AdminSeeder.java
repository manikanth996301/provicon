package com.example.proviconmanagementsystem.seed;

import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.proviconmanagementsystem.modal.Role;
import com.example.proviconmanagementsystem.modal.User;
import com.example.proviconmanagementsystem.repository.UserRepository;

@Component
public class AdminSeeder implements CommandLineRunner {
private final UserRepository userRepository;
private final PasswordEncoder passwordEncoder;

@Value("${app.initial-admin.username:admin}")
private String adminUser;

@Value("${app.initial-admin.password:admin123}")
private String adminPass;

	public AdminSeeder(UserRepository userRepository, PasswordEncoder passwordEncoder) {
	super();
	this.userRepository = userRepository;
	this.passwordEncoder = passwordEncoder;
}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		if(userRepository.existsByuserName(adminUser))
			return;
		User admin= new User();
		admin.setUserName(adminUser);
		admin.setPassword(passwordEncoder.encode(adminPass));
		admin.setRole(Set.of(Role.ADMIN,Role.USER));
		userRepository.save(admin);
		System.out.println("seeded admin user "+ adminUser);
	}

}
