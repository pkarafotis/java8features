package com.company.demo.java8features.optionals;

import java.util.NoSuchElementException;
import java.util.Optional;

public class Optionals {

    public static void checkOptionalsWithoutContent() {
        System.out.println("\n***checkOptionalsWithoutContent***");
        String content = null;
        Optional<String> contentWrapper = Optional.ofNullable(content);
        print(content, contentWrapper);

    }

    public static void checkOptionalsWithContent() {
        System.out.println("\n***checkOptionalsWithContent***");
        String content = "This is a valid string";
        Optional<String> contentWrapper = Optional.ofNullable(content);
        print(content, contentWrapper);
    }

    public static void print(String content, Optional<String> contentWrapper) {
        System.out.println("content is: " + content);
        System.out.println("contentWrapper.isPresent() ? " + contentWrapper.isPresent());
        System.out.println("contentWrapper.orElse() alternative for NPEs: " + contentWrapper.orElse("default value"));
        System.out.println("trying to get the value from optional");

        try {
            System.out.println("value is : " + contentWrapper.get());
        } catch (NoSuchElementException e) {
            System.out.println("runtime exception thrown");
        }
    }
}
