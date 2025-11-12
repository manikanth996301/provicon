package com.example.proviconmanagementsystem.security;

import java.io.IOException;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private final JwtTokenProvider jwtTokenProvider;
	private final UserDetailsService userDetailsService;
	

	public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider, UserDetailsService userDetailsService) {
		super();
		this.jwtTokenProvider = jwtTokenProvider;
		this.userDetailsService = userDetailsService;
	}
	
	

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String authHeader=request.getHeader("Authorization");
		
		try {
	        if (authHeader != null && authHeader.startsWith("Bearer ")) {
	            String token = authHeader.substring(7).trim();

	            if (jwtTokenProvider.isValidToken(token)) {
	                String username = jwtTokenProvider.extractUsername(token);
	                System.out.println("[JWT FILTER] Token is valid. Username = " + username);

	                // Only set authentication if not already set
	                if (SecurityContextHolder.getContext().getAuthentication() == null) {
	                    UserDetails userDetails = userDetailsService.loadUserByUsername(username);

	                    UsernamePasswordAuthenticationToken authToken =
	                            new UsernamePasswordAuthenticationToken(
	                                    userDetails,
	                                    null,
	                                    userDetails.getAuthorities());

	                    SecurityContextHolder.getContext().setAuthentication(authToken);

	                    System.out.println("[JWT FILTER] Authentication set. principal = " 
	                            + username + " authorities = " + userDetails.getAuthorities());
	                }
	            } else {
	                System.out.println("[JWT FILTER] Token invalid or expired.");
	            }
	        } else {
	            // No Authorization header — normal for public endpoints
	            // Uncomment below if you want to see it during testing
	            System.out.println("[JWT FILTER] No Authorization header present.");
	        }
	    } catch (Exception ex) {
	        System.out.println("[JWT FILTER] Exception while processing token: " + ex.getMessage());
	    }

	    filterChain.doFilter(request, response);
	}
	
}
