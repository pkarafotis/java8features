package com.company.demo.java8features;

import com.company.demo.java8features.streams.StreamsDemo;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

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
