package com.example.springboot_basic1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot_basic1.entity.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;


//way1 - jdbc
//way2 - jpa repo 
//way3 - spring data jpa


public interface CourseRepository extends JpaRepository<Course, Long>{
	
	List<Course> findByAuthor(String author);
	List<Course> findByName(String name);
}


//@Repository
//@Transactional
//public class CourseRepository {
//	
//	@PersistenceContext
//	private EntityManager entityManager;
//	
//	public void insert(Course course) {
//		entityManager.merge(course);
//	}
//	
//	public Course findById(Long id) {
//		return entityManager.find(Course.class, id);
//	}
//	
//	public void deleteById(Long id) {
//		Course course = entityManager.find(Course.class, id);
//		entityManager.remove(course);
//	}
//}
