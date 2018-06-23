package com.macroli.code.study;

public class GenericFunctionInerface {
    public static void main(String[] args) {
        //Generic function
        CompareGeneric<Integer> compareGeneric = (x, y) -> x > y ? x : y;

        System.out.println(compareGeneric.compare(5, 8));

    }

    @FunctionalInterface
    interface CompareGeneric<T> {
        T compare(T a, T b);
    }
}
