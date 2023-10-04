package com.example.springboot_basic1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SpringbootBasic1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBasic1Application.class, args);
	}

//	@Bean
//	public WebMvcConfigurer coresConfigurer() {
//		return new WebMvcConfigurer() {
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**")
//					.allowedOriginPatterns("*")
//					.allowedOrigins("http://localhost:3000");
//			}
//		};
//	}
}
