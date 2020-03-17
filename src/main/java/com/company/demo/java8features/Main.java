package com.company.demo.java8features;

import com.company.demo.java8features.defaultmethod.DefaultMethod;
import com.company.demo.java8features.defaultmethod.DefaultMethodImpl;
import com.company.demo.java8features.optionals.Optionals;
import com.company.demo.java8features.dateapi.DateApi;

import com.company.demo.java8features.methodreferences.MethodReferences;
import com.company.demo.java8features.streams.StreamsDemo;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("***START Default Methods ***");
        DefaultMethod dm = new DefaultMethodImpl();
        System.out.println("Method implementation on class sum(5,10): " + dm.add(5, 10));
        System.out.println("Default Method implementation on interface avg(5,10): " + dm.avg(5, 10));
        System.out.println("*** END Default Methods ***\n\n");

        System.out.println("*** START Optionals***");
        Optionals.checkOptionalsWithoutContent();
        Optionals.checkOptionalsWithContent();
        System.out.println("*** END Optionals***\n\n");

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

        System.out.println("***START Date API ***");
        DateApi.clock();
        DateApi.localDate();
        DateApi.localTime();
        DateApi.dateTimeFormat();
        DateApi.zonedDateTime();
        System.out.println("*** END Date API ***\n\n");
    }
}
