package com.example.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restapi.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
	
}
