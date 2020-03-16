package com.company.demo.java8features.functional;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortStrings {


    public static void oldWaysOfSorting(List<String> names) {
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        printList("oldWaysOfSorting", names);
    }

    public static void sortingWithLambda(List<String> names) {
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
        printList("sortingWithLambda", names);
    }

    private static void printList(String method, List<String> names) {
        System.out.println("Using " + method + ". Array of strings: ");
        for (String s: names) {
            System.out.print(s+" ");
        }
        System.out.println();
    }
}
