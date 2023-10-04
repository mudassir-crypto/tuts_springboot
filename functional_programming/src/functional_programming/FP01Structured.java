package functional_programming;

import java.util.List;

public class FP01Structured {
	
	private static void printAllNumInListStructure(List<Integer> numbers) {
		// TODO Auto-generated method stub
		for(Integer num:numbers) {
			if(num % 2 == 0) {
				System.out.println(num);
			}
		}
	}
	
	private static void printAllNumInListFunctional(List<Integer> numbers) {
		numbers.stream()
			.forEach(System.out::println);
			//.forEach(FP01Structured::print); // Method reference
	}
	
	private static void printAllEvenNumInListFunctional(List<Integer> numbers) {
		numbers.stream()
//			.filter(FP01Structured::isEven)
			.filter(num -> num%2==0)  // lambda expression
			.forEach(FP01Structured::print); // Method reference
	}
	
	private static void printSquareOfEvenNum(List<Integer> numbers) {
		numbers.stream()
			.filter(num -> num%2 == 0)
			.map(num -> num * num)
			.forEach(System.out::println);
	}
	
	private static void printCubeOfEvenNum(List<Integer> numbers) {
		numbers.stream()
			.filter(num -> num%2 == 0)
			.map(num -> Math.pow(num, 3))
			.forEach(System.out::println);
	}
	
	
	
	private static void print(int num) {
		System.out.println(num);
	}
	
	private static Boolean isEven(int num) {
		return num % 2 == 0;
	}
	
	public static void main(String[] args) {
		List<Integer> numbers = List.of(12,54,11,34,12,45);
		//printAllNumInListStructure(numbers);
		//printAllNumInListFunctional(numbers);
		//printAllEvenNumInListFunctional(numbers);
		//printSquareOfEvenNum(numbers);
		printCubeOfEvenNum(numbers);
	}

}
