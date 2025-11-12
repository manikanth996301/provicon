package com.example.proviconmanagementsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.proviconmanagementsystem.security.JwtAuthenticationFilter;
import com.example.proviconmanagementsystem.security.JwtTokenProvider;
import com.example.proviconmanagementsystem.service.Impl.userDetailServiceImpl;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
	private final userDetailServiceImpl  userDetailService;
	private final JwtTokenProvider jwtTokenProvider;
	
	
   
public SecurityConfig(userDetailServiceImpl userDetailService, JwtTokenProvider jwtTokenProvider) {
		super();
		this.userDetailService = userDetailService;
		this.jwtTokenProvider = jwtTokenProvider;
	}
//	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
    @Bean
    public DaoAuthenticationProvider authProvider() {
    	DaoAuthenticationProvider p=new DaoAuthenticationProvider();
    	p.setUserDetailsService(userDetailService);
    	p.setPasswordEncoder(passwordEncoder());
    	return p;
    }
    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
    	return new JwtAuthenticationFilter(jwtTokenProvider, userDetailService);
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
    	http   
    	.csrf(csrf->csrf.disable())
    	
    	.authorizeHttpRequests(auth->auth
    			.requestMatchers("/api/auth/**").permitAll()
    			.requestMatchers("/api/auth/**").hasRole("ADMIN")
    			//clinic http request matchers 
    			.requestMatchers(HttpMethod.PUT,"/clinic/**").hasRole("ADMIN")
    			.requestMatchers(HttpMethod.POST,"/clinic/**").hasRole("ADMIN")
    			.requestMatchers(HttpMethod.DELETE,"/clinic/**").hasRole("ADMIN")
    			.requestMatchers(HttpMethod.GET,"/clinic/**").hasAnyRole("ADMIN","USER")
    			//Doctot http request matchers
    			.requestMatchers(HttpMethod.GET,"/Doctor/**").hasAnyRole("ADMIN","USER")
    			.requestMatchers(HttpMethod.POST,"/Doctor/**").hasRole("ADMIN")
    			.requestMatchers(HttpMethod.PUT,"/Doctor/**").hasRole("ADMIN")
    			.requestMatchers(HttpMethod.DELETE,"/Doctor/**").hasRole("ADMIN")
    			//staff http request matchers
    			.requestMatchers(HttpMethod.GET,"/Staff/**").hasAnyRole("ADMIN","USER")
    			.requestMatchers(HttpMethod.POST,"/Staff/**").hasRole("ADMIN")
    			.requestMatchers(HttpMethod.PUT,"/Staff/**").hasRole("ADMIN")
    			.requestMatchers(HttpMethod.DELETE,"/Staff/**").hasRole("ADMIN")
    			// Doctorschdule request matchers
    			.requestMatchers(HttpMethod.GET,"/DoctorSchdule/**").hasAnyRole("ADMIN","USER")
    			.requestMatchers(HttpMethod.POST,"/DoctorSchdule/**").hasRole("ADMIN")
    			.requestMatchers(HttpMethod.PUT,"/DoctorSchdule/**").hasRole("ADMIN")
    			.requestMatchers(HttpMethod.DELETE,"/DoctorSchdule/**").hasRole("ADMIN")
    			//staffschdule request matchers
    			.requestMatchers(HttpMethod.GET,"/StaffSchdule/**").hasAnyRole("ADMIN","USER")
    			.requestMatchers(HttpMethod.POST,"/StaffSchdule/**").hasRole("ADMIN")
    			.requestMatchers(HttpMethod.PUT,"/StaffSchdule/**").hasRole("ADMIN")
    			.requestMatchers(HttpMethod.DELETE,"/StaffSchdule/**").hasRole("ADMIN")
    			
    			.anyRequest().authenticated()
    			)
//    	.httpBasic();
//    	return http.build();
    	.authenticationProvider(authProvider())
        .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    	return http.build();
    }
}
