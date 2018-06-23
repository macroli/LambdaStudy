package com.macroli.code.study;

public class FunctionInterfaceAsParameter {

    public static void main(String[] args) {

        //lambda as parameter
        calc(((x, y) -> x * y), 5, 6);
        calc(((x, y) -> x + y), 5, 6);
        calc(((x, y) -> x / y), 5, 6);
        calc(((x, y) -> x % y), 5, 6);
        calc(((x, y) -> x - y), 5, 6);
        //generate lambda method(it is mean function interface as return type)
        System.out.println(addFunction().calc(5, 8));

    }

    private static void calc(Calculate calculate, Integer x, Integer y) {
        int result = calculate.calc(x, y);
        System.out.println(result);
    }

    public static Calculate addFunction() {
        return (x, y) -> x + y;
    }


}

@FunctionalInterface
interface Calculate {
    int calc(Integer a, Integer b);
}














