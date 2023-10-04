package functional_programming;

import java.util.List;

public class FP01Excercise {

	
	private static void printAllOddNumbers(List<Integer> numbers){
		numbers.stream()
			.filter(num -> num%2 != 0)
			.forEach(System.out::println);
	}
	
	private static void printLengthOfEachCourse(List<String> courses) {
		courses.stream()
			.map(course -> course + ": " + course.length())
			.forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers = List.of(12,54,11,34,12,45);
		//printAllOddNumbers(numbers);
		
		List<String> courses = 
				List.of("Spring", "Azure", "Spring Framework", "AWS", "API", "Microservice", "Spring Boot", "Docker");
		
//		courses.stream()
//			.forEach(System.out::println);
		
//		courses.stream()
//			.filter(course -> course.contains("Spring"))
//			.forEach(System.out::println);
//		
//		courses.stream()
//		.filter(course -> course.length() >= 6)
//		.forEach(System.out::println);
		
		
		printLengthOfEachCourse(courses);
	}

}
