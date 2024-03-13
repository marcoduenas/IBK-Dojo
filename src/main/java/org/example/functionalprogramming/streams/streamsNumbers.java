package org.example.functionalprogramming.streams;

import java.util.List;

public class streamsNumbers {

    public static void main(String[] args) {
		List<Integer> numbers = List.of(18, 9, 13, 4, 6, 2, 4, 17, 15);

        numbers.stream() // Convierte a Stream
				.filter(number -> number > 10) // Expresíón Lambda - Filtrado
				.forEach(System.out::println);// Método referencial

        // numbers.stream() // Convierte a Stream
        // 		.filter(number -> number > 10) // Expresíón Lambda - Filtrado
        //         .sorted() // Expresíón Lambda - Ordenamiento
        //         .map(number -> number *10) // Expresíón Lambda - Transformación
		// 		.forEach(System.out::println);// Método referencial
		
		//List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", "Docker", "Kubernetes");
		
		// courses.stream()
		// .forEach(System.out::println);

		// courses.stream()
		// .filter(course -> course.contains("Spring"))
		// .forEach(System.out::println);

		// courses.stream()
		// .filter(course -> course.length() >= 4)
		// .forEach(System.out::println);
		
		// courses.stream()
		// 	.map(course -> course + " " + course.length()) 
		// 	.forEach(System.out::println);
	}

}
