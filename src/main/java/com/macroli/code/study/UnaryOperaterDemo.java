package com.macroli.code.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class UnaryOperaterDemo {

    public static void main(String[] args) {
        List<Integer> testVal = Arrays.asList(2,4,8,16,32,64);
        UnaryOperator<Integer> uOperater = (s)->s*s;
        List<Integer> result =  unaryOperaterFun(uOperater, testVal);
        result.forEach(System.out::println);

    }

    private static List<Integer> unaryOperaterFun(UnaryOperator<Integer> unaryOperaterDemo, List<Integer> testVal)
    {
        List<Integer> results = new ArrayList<>();
        testVal.forEach(x-> results.add(unaryOperaterDemo.apply(x)));

        return  results;
    }
}
