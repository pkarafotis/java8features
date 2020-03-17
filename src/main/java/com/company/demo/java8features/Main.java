package com.company.demo.java8features;

import com.company.demo.java8features.optionals.Optionals;
import com.company.demo.java8features.dateapi.DateApi;

import com.company.demo.java8features.methodreferences.MethodReferences;
import com.company.demo.java8features.streams.StreamsDemo;

import java.util.Arrays;
import java.util.List;
import com.company.demo.java8features.functional.FunctionalWithArgs;
import com.company.demo.java8features.functional.FunctionalWithGenerics;
import com.company.demo.java8features.functional.SimpleFunctional;
import com.company.demo.java8features.functional.SortStrings;


public class Main {

    public static void main(String[] args) {

//        System.out.println("***START Default Methods ***");
//        DefaultMethod dm = new DefaultMethodImpl();
//        System.out.println("Method implementation on class sum(5,10): " + dm.add(5, 10));
//        System.out.println("Default Method implementation on interface avg(5,10): " + dm.avg(5, 10));
//        System.out.println("*** END Default Methods ***\n\n");

        System.out.println("*** START Optionals***");
        Optionals.checkOptionalsWithoutContent();
        Optionals.checkOptionalsWithContent();
        System.out.println("*** END Optionals***\n\n");

        System.out.println("***START Date API ***");
        DateApi.clock();
        DateApi.localDate();
        DateApi.localTime();
        DateApi.dateTimeFormat();
        DateApi.zonedDateTime();
        System.out.println("*** END Date API ***\n\n");

        System.out.println("*** START Functional Interfaces/Lambda Expressions ***");
        // Full definition
        SimpleFunctional sf = () -> {
            System.out.println("hello functional!");
        };

        // Omit curly braces when there is only one statement in the body of lambda
        SimpleFunctional sf2 = () -> System.out.println("hello functional!");

        sf2.doSomething();

        // Full definition with type parameters and arguments
        FunctionalWithArgs addition = (int a, int b) -> {
            return a + b;
        };

        // Alt definition without type in parameters. Type is inferred by the compiler
        FunctionalWithArgs addition2 = (a, b) -> {
            return a + b;
        };

        // Alt definition without return type and curly braces. When there is only one statement in the body
        // of lambda expression then the return keyword and curly braces might be omitted
        FunctionalWithArgs addition3 = (a, b) -> a + b;

        System.out.println("Using functional interface for addition (5,10): " + addition3.operate(5, 10));

        // Functional interface with generics
        FunctionalWithGenerics<String, Integer> integerConverter = (s) -> Integer.valueOf(s);
        System.out.println("Convert a string to integer: " + integerConverter.convert("123"));

        // Built-in Methods that accept functional interfaces as arguments
        SortStrings.oldWaysOfSorting(Arrays.asList("bob", "alice", "mark", "kate"));
        SortStrings.sortingWithLambda(Arrays.asList("bob", "alice", "mark", "kate"));

        System.out.println("*** END Functional Interfaces/Lambda Expressions ***\n\n");

        System.out.println("***START Method References ***");
        MethodReferences.constructorDemo();
        MethodReferences.staticMethodsDemo();
        MethodReferences.instanceMethodDemo();
        System.out.println("*** END Method References ***\n\n");

        System.out.println("***START Streams ***");
        List<String> strings = Arrays.asList("abc", "adf", "cd", "tfv", "zxc", "aaa", "qwe", "acb", "plmty");
        StreamsDemo.streamCreation();
        StreamsDemo.filtering(strings);
        StreamsDemo.sorting(strings);
        StreamsDemo.map(strings);
        StreamsDemo.match(strings);
        StreamsDemo.count(strings);
        StreamsDemo.collect(strings);
        StreamsDemo.reduce(strings);
        StreamsDemo.parallelStreams();
        System.out.println("*** END Streams ***\n\n");
    }
}
