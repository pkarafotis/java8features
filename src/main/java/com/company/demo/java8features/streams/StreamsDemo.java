package com.company.demo.java8features.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsDemo {

    public static void streamCreation() {
        System.out.println("\nCreating a stream with Stream.of");
        Stream<String> stream1 = Stream.of("one", "two", "three", "four");
        stream1.forEach(System.out::println);

        System.out.println("\nCreating a stream with Stream.builder");
        Stream.Builder<String> stringStreamBuilder = Stream.builder();
        stringStreamBuilder.accept("one");
        stringStreamBuilder.accept("two");
        stringStreamBuilder.accept("three");
        stringStreamBuilder.accept("four");
        Stream<String> stream2 = stringStreamBuilder.build();
        stream2.forEach(System.out::println);

        System.out.println("\nCreating a stream with generate");
        Stream<String> stream3 = Stream.generate(() -> "generated").limit(2);
        stream3.forEach(System.out::println);

        System.out.println("\nCreating a stream with iterate");
        Stream<Integer> stream4 = Stream.iterate(1, n -> n + 2).limit(10);
        stream4.forEach(System.out::println);
    }

    public static void filtering(List<String> strings) {
        System.out.println("\nFiltering on stream: ");
        strings.stream()
                .filter(s -> s.startsWith("a"))
                .forEach(System.out::println);
    }

    public static void sorting(List<String> strings) {
        System.out.println("\nFiltering on sorted stream: ");
        strings.stream()
                .sorted()
                .filter(s -> s.startsWith("a"))
                .forEach(System.out::println);
    }

    public static void map(List<String> strings) {
        System.out.println("\nMap is used to transform the input object to another one (using a Function<T,R>: ");

        strings.stream()
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }

    public static void match(List<String> strings) {
        System.out.println("\nMatch check a condition (predicate) and results in a terminal type (boolean): ");

        boolean listContainLetterz = strings.stream().anyMatch(s -> s.contains("z"));
        System.out.println("List has an element that contains letter z?: " + listContainLetterz);

        boolean allStringsLengthOf3 = strings.stream().allMatch(s -> s.length() == 3);
        System.out.println("All of the strings in the list have length 3?: " + allStringsLengthOf3);

        boolean listContainG = strings.stream().noneMatch(s -> s.contains("G"));
        System.out.println("There is no string in the list with the letter \"G\": " + listContainG);
    }

    public static void count(List<String> strings) {
        System.out.println("\nCounting the elements of the stream");

        long numOfElements = strings.stream().count();

        System.out.println("There are " + numOfElements + " in the stream");
    }

    public static void collect(List<String> strings) {
        System.out.println("\nReducing a collection of string to a single string with collect");

        String finalString = strings.stream().collect(Collectors.joining(", ", "[", "]"));
        System.out.println("Collection of strings reduced to: " + finalString);

    }
    public static void reduce(List<String> strings) {

        System.out.println("\nReduce");

        // sum the generated numbers: 1+2+3=6
        int sum = IntStream.range(1, 4).reduce((a, b) -> a + b).getAsInt();
        System.out.println("Sum: " + sum);

        // sum with seed 10+1+2+3
        int sum2 = IntStream.range(1, 4).reduce(10, (a, b) -> a + b);
        System.out.println("Sum with seed: " + sum2);

        // Reduce the strings into a single one, concatenating each element with #
        strings.stream()
                .sorted()
                .reduce((s1, s2) -> s1 + "#" + s2)
                .ifPresent(System.out::println);
    }

    public static void parallelStreams() {

        List<String> largeList = createLargeList();

        System.out.println("Sort the large list sequentially");
        long ts0 = System.nanoTime();

        long count = largeList.stream().sorted().count();

        long ts1 = System.nanoTime();

        System.out.println("Sequential sort took: " + TimeUnit.NANOSECONDS.toMillis(ts1-ts0));

        long tp0 = System.nanoTime();

        long count2 = largeList.parallelStream().sorted().count();

        long tp1 = System.nanoTime();

        System.out.println("Parallel sort took: " + TimeUnit.NANOSECONDS.toMillis(tp1-tp0));

    }

    private static List<String> createLargeList() {
        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        return values;
    }
}
