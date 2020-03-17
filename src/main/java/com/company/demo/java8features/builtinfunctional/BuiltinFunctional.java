package com.company.demo.java8features.builtinfunctional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BuiltinFunctional {

    public static void predicateDemo() {

        System.out.println("\nPredicate demo\n");
        Predicate<String> lengthPredicate = (s) -> s.length() > 0;
        Predicate<String> startWithPredicate = (s) -> s.startsWith("s");

        System.out.println("lengthPredicate on empty string: " + lengthPredicate.test(""));
        System.out.println("startWithPredicate on \"string\" string: " + startWithPredicate.test("string"));

        System.out.println("Composition of predicates for input string \"this\": " + lengthPredicate.and(startWithPredicate).test("this"));
        System.out.println("Negation of lengthPredicate for input string \"string\": " + lengthPredicate.negate().test("string"));

    }

    public static void functionsDemo() {

        System.out.println("\nFunctions demo\n");

        Function<Double, Double> sqrt = (d) -> Math.sqrt(d);
        Function<Double, Double> multiply = (d) -> 5*d;

        System.out.println("sqrt of 4.0: " + sqrt.apply(4.0));

        // compose
        // current.compose(before): returns a composed function that first applies 'before' function to its input
        // and then 'current' function to the result
        System.out.println("Function composition multiply.compose(sqrt) on 4.0: " + multiply.compose(sqrt).apply(4.0));

        // andThen
        // current.andThen(after): return a composed function that first applies 'current' function to its input
        // and then 'after' function to the result
        System.out.println("Function composition multiply.andThen(sqrt) on 4.0: " + multiply.andThen(sqrt).apply(4.0));
    }

    public static void suppliersDemo() {
        Supplier<Double> doubleSupplier = () -> Math.random();
        System.out.println("Supply a double value: " + doubleSupplier.get());
    }

    public static void consumersDemo() {
        Consumer<Double> doubleConsumer = (d) -> System.out.println("Passed double value: " + d);
        doubleConsumer.accept(40.0);

        // Chain of consumers (with mutation)
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

        Consumer<List<Integer>> modify = (l) -> {
            for(int i=0; i < l.size(); i++) {
                l.set(i, l.get(i)*2);
            }
        };

        Consumer<List<Integer>> print = (l) -> {
          for(Integer i:l) {
              System.out.print(i + " ");
          }
            System.out.println();
        };

        System.out.println("modify.andThen(print) a list of integers (double each element->print)");
        modify.andThen(print).accept(integers);
    }

}
