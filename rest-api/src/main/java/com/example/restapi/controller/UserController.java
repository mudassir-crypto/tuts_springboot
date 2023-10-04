package com.example.restapi.controller;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.restapi.dto.UserDto;
import com.example.restapi.exception.UserNotFoundException;
import com.example.restapi.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		List<UserDto> users = userService.findAll();
		return ResponseEntity.ok(users);
	}
	
	
	// implementing hateoas - requires EntityModel and WebMvcLinkBuilder
	@GetMapping("/{id}")
	public EntityModel<UserDto> getUserById(@PathVariable("id") Long userId){
		UserDto userDto = userService.findById(userId);
		if(userDto == null) {
			throw new UserNotFoundException("User not found with this id: " + userId);
		}
		
		EntityModel<UserDto> entityModel = EntityModel.of(userDto);
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());
		//WebMvcLinkBuilder link = linkTo(methodOn(HelloWorldController.class).helloWorld());
		entityModel.add(link.withRel("all-users"));
				
		return entityModel;
	}
	
	@PostMapping("")
	public ResponseEntity<String> createUser(@Valid @RequestBody UserDto userDto) {
		UserDto savedUser = userService.save(userDto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
							.path("/{id}")
							.buildAndExpand(savedUser.getId())
							.toUri();
		System.out.println(location);
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable("id") Long userId){
		UserDto userDto = userService.findById(userId);
		if(userDto == null) {
			throw new UserNotFoundException("User not found with this id: " + userId);
		}
		
		userService.deleteById(userId);
		
		return ResponseEntity.ok("User is deleted successfully");
	}
}
