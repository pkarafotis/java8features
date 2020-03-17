package com.company.demo.java8features.methodreferences;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class MethodReferences {

    public static void staticMethodsDemo() {
        System.out.println("Method Referencing of static methods");

        List<String> names = Arrays.asList("bob", "alice", "max", "joe");

        System.out.println("Capitalize using normal function");
        Function<String, String> capitalize = (s) -> StringUtils.capitalize(s);
        for (String s:names) {
            System.out.print(capitalize.apply(s) + " ");
        }
        System.out.println();

        System.out.println("Capitalize using static method reference");
        Function<String, String> capitalizeMethodRef = StringUtils::capitalize;
        for (String s:names) {
            System.out.print(capitalizeMethodRef.apply(s) + " ");
        }
        System.out.println();
    }

    public static void constructorDemo() {
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Joe", "Doe");

        System.out.println(person);
    }

    public static void instanceMethodDemo() {

        // Classic lambda expression passed as argument
        List<Integer> integers = Arrays.asList(10, 2, 40, 23, 32);
        List<Integer> integers2 = Arrays.asList(10, 2, 40, 23, 32);

        System.out.println("Sort by normal lambda: ");
        Collections.sort(integers, (a,b) -> a.compareTo(b));
        print(integers);

        System.out.println("Sort by method reference: ");
        Collections.sort(integers2, Integer::compareTo);
        print(integers2);
    }

    private static void print(List<Integer> integers) {
        for(Integer i:integers) {
            System.out.print(i+ " ");
        }
        System.out.println();
    }
}
