package com.learn.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyMathTest {
	public MyMath myMath = new MyMath();
	
	@Test
	void test1() {
		assertEquals(0, myMath.calcSum(new int[] {}));
	}
	
	@Test
	void test2() {
		assertEquals(10, myMath.calcSum(new int[] {1,2,3,4}));
	}
}
