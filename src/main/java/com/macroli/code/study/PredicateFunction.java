package com.macroli.code.study;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateFunction {
    public static void main(String[] args) {

        //Predicate pass in T  return boolean
        Predicate<String> predicateLen = (x) -> x.length() > 5;
        String testStr = "Hello world!";
        System.out.println(predicateLen.test(testStr));

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        conditionFilter(list, (x) -> x > 6).forEach(System.out::println);

    }

    private static List<Integer> conditionFilter(List<Integer> list, Predicate<Integer> predicate) {
        return list.stream().filter(predicate).collect(Collectors.toList());
    }
}
