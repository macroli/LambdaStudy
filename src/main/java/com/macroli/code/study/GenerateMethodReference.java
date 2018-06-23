package com.macroli.code.study;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class GenerateMethodReference {
    public static void main(String[] args) {
        Function<String[], List<String>> function = Arrays::<String>asList;
        String[] strs = {"1", "2", "3", "4", "5"};
        System.out.println(function.apply(strs));
        function.apply(strs).stream().forEach(System.out::println);

    }
}
