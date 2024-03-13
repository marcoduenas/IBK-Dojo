package org.example.functionalprogramming.FunctionalInterface;

import java.util.List;
import java.util.function.Function;

public class FunctionSample {
	public static void main(String[] args) {

		Function<Integer, Integer> multiplicarFunction = x -> x * 10;

		List<Integer> numbers = List.of(18, 9, 13, 4, 6, 2, 4, 17, 15);

		numbers.stream()
		.filter(number -> number > 10)
        .map(multiplicarFunction)
        .forEach(System.out::println);

	}
}
