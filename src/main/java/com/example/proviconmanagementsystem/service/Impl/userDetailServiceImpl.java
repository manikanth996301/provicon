package com.example.proviconmanagementsystem.service.Impl;

import java.util.stream.Collectors;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.proviconmanagementsystem.modal.User;
import com.example.proviconmanagementsystem.repository.UserRepository;

@Service
public class userDetailServiceImpl implements UserDetailsService  {
private final UserRepository userRepository;

public userDetailServiceImpl(UserRepository userRepository) {
	super();
	this.userRepository = userRepository;
}

@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	// TODO Auto-generated method stub
	User u=userRepository.findByuserName(username)
			.orElseThrow(()-> new RuntimeException("User not found "+ username));
	var authoroties=u.getRole().stream()
			.map(r-> new SimpleGrantedAuthority("ROLE_" + r.name()))
			.collect(Collectors.toSet());
	Authentication auth=SecurityContextHolder.getContext().getAuthentication();
	if(auth == null) {
		 System.out.println("[DEBUG] No authentication present (anonymous request)");
	}
	else {
		System.out.println("Debug principal "+ auth.getName() + "authorities "+ auth.getAuthorities() );
	}

	//System.out.println(authoroties);
	return new  org.springframework.security.core.userdetails.User(u.getUserName(), u.getPassword(),authoroties);
	
}

}
