package org.example.functionalprogramming.FunctionalInterface;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateSample {
	public static void main(String[] args) {

		Function<Integer, Integer> multiplicarFunction = x -> x * 10;

		Predicate<Integer> esMayorDiez = (Integer x) -> x > 10;

		List<Integer> numbers = List.of(18, 9, 13, 4, 6, 2, 4, 17, 15);

		numbers.stream()
		.filter(esMayorDiez)
        .map(multiplicarFunction)
        .forEach(System.out::println);

	}
}
