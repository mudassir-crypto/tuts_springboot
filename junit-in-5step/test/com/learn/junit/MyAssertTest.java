package com.learn.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class MyAssertTest {
	
	List<String> courses = Arrays.asList("AWS", "Azure", "GCP");
	
	@Test
	void test() {
		boolean test = courses.contains("AWS");
		assertEquals(true, test);
		assertNotEquals(false, test);
		assertTrue(test);
		
		assertEquals(3, courses.size());
		assertEquals(3, courses.size(), "Error message");
		
		//assertNull assertNotNull
		assertNotNull(courses);
		
		assertArrayEquals(new int[] {1,2}, new int[] {1,2});
	}

}
