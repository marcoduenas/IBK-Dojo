package org.example.functionalprogramming.streams;

import java.util.List;

public class streamsString {

    public static void main(String[] args) {
		
		List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", "Docker", "Kubernetes");
		
		// courses.stream()
		// .forEach(System.out::println);

		courses.stream()
		.filter(course -> course.contains("Spring"))
		.forEach(System.out::println);

		// courses.stream()
		// .filter(course -> course.length() >= 4)
		// .forEach(System.out::println);
		
		// courses.stream()
		// 	.map(course -> course + " " + course.length()) 
		// 	.forEach(System.out::println);
	}

}
