package com.macroli.code.study;

import java.io.Serializable;
import java.util.function.Function;

public class IntersectionLambda {

    public static void main(String[] args) {
        //no intersection method
        NonFunction nonFunction = (NonFunction & Calculate) ((x, y) -> x + x + y);

        Serializable serializable = (Serializable & Calculator) (x, y) -> x / y;

        //obtain the union method and default method of Calculator & Calculation function
        Calculator calculator = (Calculator & Calculation) (x, y) -> x + y;
        System.out.println(calculator.multiply(6, 8));
        System.out.println(calculator.add(6,8));
        //or
        Calculation calculation = (Calculator & Calculation) (x, y) -> x + y;
        System.out.println(calculation.devide(16,4));


        Function<Integer, Integer> function = val -> val * 5;
        System.out.println(function.apply(15));


    }


}

@FunctionalInterface
interface Calculation {
    int add(int x, int y);


    default int devide(int x, int y) {
        return x / y;
    }

}

//
interface NonFunction {

}

@FunctionalInterface
interface Calculator {
    int add(int x, int y);

    static int subract(int x, int y) {
        return x - y;
    }

    default int multiply(int x, int y) {
        return x * y;
    }
}