package com.learn.junit;

public class MyMath {
	
	public int calcSum(int[] numbers) {
		int sum = 0;
		
		for(int number:numbers) {
			sum += number;
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		

	}

}
