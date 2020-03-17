package com.company.demo.java8features;

import com.company.demo.java8features.builtinfunctional.BuiltinFunctional;

public class Main {

    public static void main(String[] args) {

        System.out.println("***START Built-in Functional Interfaces ***");

        BuiltinFunctional.predicateDemo();
        BuiltinFunctional.functionsDemo();
        BuiltinFunctional.suppliersDemo();
        BuiltinFunctional.consumersDemo();

        System.out.println("*** END Built-in Functional Interfaces ***\n\n");
    }
}
