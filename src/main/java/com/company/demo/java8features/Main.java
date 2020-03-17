package com.company.demo.java8features;

import com.company.demo.java8features.dateapi.DateApi;

public class Main {

    public static void main(String[] args) {

        System.out.println("***START Date API ***");

        DateApi.clock();
        DateApi.localDate();
        DateApi.localTime();
        DateApi.dateTimeFormat();
        DateApi.zonedDateTime();

        System.out.println("*** END Date API ***\n\n");
    }
}
