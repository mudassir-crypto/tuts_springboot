package com.example.restapi.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.example.restapi.entity.Post;
import com.example.restapi.entity.User;
import com.example.restapi.exception.UserNotFoundException;
import com.example.restapi.repository.PostRepository;
import com.example.restapi.repository.UserRepository;
import com.example.restapi.service.UserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/jpa/users")
public class UserController2 {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> users = userRepository.findAll();
		return ResponseEntity.ok(users);
	}
	
	
	// implementing hateoas - requires EntityModel and WebMvcLinkBuilder
	@GetMapping("/{id}")
	public EntityModel<User> getUserById(@PathVariable("id") Long userId){
		Optional<User> user = userRepository.findById(userId);
		
		if(user.isEmpty()) {
			throw new UserNotFoundException("User not found with this id: " + userId);
		}
		
		EntityModel<User> entityModel = EntityModel.of(user.get());
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());
		//WebMvcLinkBuilder link = linkTo(methodOn(HelloWorldController.class).helloWorld());
		entityModel.add(link.withRel("all-users"));
				
		return entityModel;
	}
	
	@PostMapping("")
	public ResponseEntity<String> createUser(@Valid @RequestBody User user) {
		User savedUser = userRepository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
							.path("/{id}")
							.buildAndExpand(savedUser.getId())
							.toUri();
		System.out.println(location);
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable("id") Long userId){
		Optional<User> user = userRepository.findById(userId);
		if(user.isEmpty()) {
			throw new UserNotFoundException("User not found with this id: " + userId);
		}
		
		userRepository.deleteById(userId);
		
		return ResponseEntity.ok("User is deleted successfully");
	}
	
	@GetMapping("/{id}/posts")
	public ResponseEntity<List<Post>> getPostOfUser(@PathVariable("id") Long userId){
		Optional<User> user = userRepository.findById(userId);
		if(user.isEmpty()) {
			throw new UserNotFoundException("User not found with this id: " + userId);
		}
		
		return ResponseEntity.ok(user.get().getPosts());
	}
	
	@PostMapping("/{id}/posts")
	public ResponseEntity<String> createPostOfUser(@PathVariable("id") Long userId, @Valid @RequestBody Post post){
		Optional<User> user = userRepository.findById(userId);
		if(user.isEmpty()) {
			throw new UserNotFoundException("User not found with this id: " + userId);
		}
		
		post.setUser(user.get());
		Post savedPost = postRepository.save(post);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedPost.getId())
				.toUri();
		System.out.println(location);
		return ResponseEntity.created(location).build();
	}
}
