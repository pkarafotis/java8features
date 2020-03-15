package com.company.demo.java8features;

import com.company.demo.java8features.defaultMethod.DefaultMethod;
import com.company.demo.java8features.defaultMethod.DefaultMethodImpl;

public class Main {

    public static void main(String[] args) {

        System.out.println("*** START Default Methods ***");

        DefaultMethod dm = new DefaultMethodImpl();

        System.out.println("Method implementation on class sum(5,10): " + dm.add(5,10));

        System.out.println("Default Method implementation on interface avg(5,10): " + dm.avg(5,10));

        System.out.println("*** END Default Methods ***\n\n");
    }
}
