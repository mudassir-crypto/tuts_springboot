package com.example.restapi.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.restapi.dto.UserDto;

import lombok.AllArgsConstructor;


@Component
public class UserService {

	private static List<UserDto> users = new ArrayList<>();
		
	private static Long userCount = 0l;
	
	static {
		users.add(new UserDto(++userCount, "John", LocalDate.now().minusYears(30)));
		users.add(new UserDto(++userCount, "Jana", LocalDate.now().minusYears(36)));
		users.add(new UserDto(++userCount, "Tom", LocalDate.now().minusYears(24)));
	}
	
	public List<UserDto> findAll(){
		return users;
	}
	
	public UserDto findById(Long id) {
		Predicate<? super UserDto> predicate = user -> user.getId().equals(id);
		UserDto user = users.stream().filter(predicate).findFirst().orElse(null);
		return user;	
	}
	
	public UserDto save(UserDto userDto) {
		userDto.setId(++userCount);
		users.add(userDto);
		return userDto;
	}
	
	public void deleteById(Long id) {
		Predicate<? super UserDto> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
			
	}
}
