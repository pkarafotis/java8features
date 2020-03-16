package com.company.demo.java8features.functional;

@FunctionalInterface
public interface FunctionalWithGenerics<F, T> {
    T convert(F from);
}
