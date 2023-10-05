package com.learn.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BeforeAfterTest {

	@Test
	void test1() {
		System.out.println("test1");
	}
	@Test
	void test2() {
		System.out.println("test2");
	}	
	@Test
	void test3() {
		System.out.println("test3");
	}
	
	@BeforeEach
	void beforeEach() {
		System.out.println("beforeEach");
	}
	
	@AfterEach
	void afterEach() {
		System.out.println("afterEach");
	}
	
	@BeforeAll
	static void beforeAll() {
		System.out.println("beforeAll - cleanup");
	}
	//
	@AfterAll
	static void afterAll() {
		System.out.println("afterAll - cleanup");
	}

}
