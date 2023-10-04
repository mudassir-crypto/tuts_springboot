package com.example.restapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class SpringSecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		// 1. All request should be authenticated
		// 2. If a request is not authenticated, a web page is shown
		// 3. CSRF -> PUT,POST
		
		http.csrf(AbstractHttpConfigurer::disable);
		http.authorizeHttpRequests(
				(auth) -> {
					auth.requestMatchers("/api/hello/**").permitAll();
					auth.anyRequest().authenticated();
				});
		
		http.httpBasic(Customizer.withDefaults());
		
		return http.build();
	}
	
}
