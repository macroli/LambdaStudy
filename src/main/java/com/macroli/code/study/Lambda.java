package com.macroli.code.study;

public class Lambda {

    public static void main(String[] args) {

        IntegerCalc intergerCalc = (x) -> x * 6;
        System.out.println(intergerCalc.calc(5));

        FinalModifer finalModifer = ((str) -> str.length());
        String testStr = "hello lambda";
        System.out.println(finalModifer.getStrLength(testStr));

        FinalModifer finalModifer1 = (final String str) -> {
            //str = "hello java lambda"; //explicitly declare final parameter, str doesn't be assign new value
            return str.length();
        };
        System.out.println(finalModifer1.getStrLength(testStr));

    }

    @FunctionalInterface
    interface IntegerCalc {
        Integer calc(Integer arg);
    }

    @FunctionalInterface
    interface FinalModifer {
        int getStrLength(String str);
    }
}
