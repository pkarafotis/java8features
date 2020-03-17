package com.company.demo.java8features;

import com.company.demo.java8features.methodreferences.MethodReferences;

public class Main {

    public static void main(String[] args) {

        System.out.println("***START Method References ***");

        MethodReferences.constructorDemo();
        MethodReferences.staticMethodsDemo();
        MethodReferences.instanceMethodDemo();

        System.out.println("*** END Method References ***\n\n");
    }
}
