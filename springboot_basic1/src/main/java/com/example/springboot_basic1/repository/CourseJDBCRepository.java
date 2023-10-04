//package com.example.springboot_basic1.repository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import com.example.springboot_basic1.dto.CourseDto;
//import com.example.springboot_basic1.entity.Course;
//
//@Repository
//public class CourseJDBCRepository {
//	
//	@Autowired
//	private JdbcTemplate springJdbcTemplate;
//	
//	private static String INSERT_QUERY =
//			"""
//				insert into course(id,name,author)
//				values(?,?,?);
//			""";
//	
//	private static String DELETE_QUERY = 
//			"""
//				delete from course
//				where id=?
//			""";
//	
//	private static String SELECT_QUERY_ID = 
//			"""
//				select * from course
//				where id=?
//			""";
//	
//	
//	public void insert(CourseDto courseDto) {
//		springJdbcTemplate.update(INSERT_QUERY, courseDto.getId(), courseDto.getName(), courseDto.getAuthor());
//	}
//	
//	public void deleteById(Long id) {
//		springJdbcTemplate.update(DELETE_QUERY, id);
//		
//	}
//	
//	public CourseDto selectById(Long id) {
//		//Resultset -> Bean => RowMapper
//		return springJdbcTemplate.queryForObject(SELECT_QUERY_ID, new BeanPropertyRowMapper<>(CourseDto.class), id);
//	}
//	
//}
