package functional_programming;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class OptionalClass {

	public static void main(String[] args) {
		List<String> courses = 
				List.of("Spring", "Azure", "Spring Framework", "AWS", "API", "Microservice", "Spring Boot", "Docker");
		
		Predicate<? super String> predicate = course -> course.startsWith("A");
		Optional<String> optional = courses.stream().filter(predicate).findFirst();
		System.out.println(optional);
		System.out.println(optional.isEmpty());
		System.out.println(optional.isPresent());
		System.out.println(optional.get());
		
		Optional<String> empty = Optional.empty();
		Optional<String> fruit = Optional.of("banana");
		System.out.println(fruit);
	}
}
