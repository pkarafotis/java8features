package com.company.demo.java8features.methodreferences;

public interface PersonFactory<P extends Person> {
    Person create(String firstName, String lastName);
}
