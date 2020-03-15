package com.company.demo.java8features;

import com.company.demo.java8features.optionals.Optionals;

public class Main {

    public static void main(String[] args) {

        System.out.println("*** START Optionals***");

        Optionals.checkOptionalsWithoutContent();
        Optionals.checkOptionalsWithContent();

        System.out.println("*** END Optionals***\n\n");
    }
}
