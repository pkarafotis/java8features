package com.company.demo.java8features;

import com.company.demo.java8features.functional.FunctionalWithArgs;
import com.company.demo.java8features.functional.FunctionalWithGenerics;
import com.company.demo.java8features.functional.SimpleFunctional;
import com.company.demo.java8features.functional.SortStrings;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println("***START Functional Interfaces/Lambda Expressions ***");

        // Full definition
        SimpleFunctional sf = () -> { System.out.println("hello functional!"); };

       // Omit curly braces when there is only one statement in the body of lambda
        SimpleFunctional sf2 = () -> System.out.println("hello functional!");

        sf2.doSomething();

        // Full definition with type parameters and arguments
        FunctionalWithArgs addition = (int a, int b) -> { return a+b; };

        // Alt definition without type in parameters. Type is inferred by the compiler
        FunctionalWithArgs addition2 = (a, b) -> { return a+b; };

        // Alt definition without return type and curly braces. When there is only one statement in the body
        // of lambda expression then the return keyword and curly braces might be omitted
        FunctionalWithArgs addition3 = (a, b) -> a+b;

        System.out.println("Using functional interface for addition (5,10): " + addition3.operate(5,10));

        // Functional interface with generics
        FunctionalWithGenerics<String, Integer> integerConverter = (s) -> Integer.valueOf(s);
        System.out.println("Convert a string to integer: " + integerConverter.convert("123"));

        // Built-in Methods that accept functional interfaces as arguments
        SortStrings.oldWaysOfSorting(Arrays.asList("bob", "alice", "mark", "kate"));
        SortStrings.sortingWithLambda(Arrays.asList("bob", "alice", "mark", "kate"));

        System.out.println("*** END Functional Interfaces/Lambda Expressions ***\n\n");
    }
}
