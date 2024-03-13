package org.example.functionalprogramming.FunctionalInterface;

import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class SupplierSample {
	public static void main(String[] args) {

		Function<Integer, Integer> multiplicarFunction = x -> x * 10;

		Predicate<Integer> esMayorDiez = (Integer x) -> x > 10;

		Consumer<Integer> sysoutConsumer = x -> System.out.println(x);

		Supplier<List<Integer>> randomIntegerSupplier = () -> new Random()
																	.ints(20, 1, 20)
																	.boxed()
																	.collect(Collectors.toList());

		List<Integer> numbers = randomIntegerSupplier.get();

		numbers.stream()
		.filter(esMayorDiez)
        .map(multiplicarFunction)
        .forEach(sysoutConsumer);

	}
}
