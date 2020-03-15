package com.company.demo.java8features.defaultMethod;

public interface DefaultMethod {

    // classic abstract method
    int add(int a, int b);

    default double avg(int a, int b) {
        return (a+b)/2;
    }
}
