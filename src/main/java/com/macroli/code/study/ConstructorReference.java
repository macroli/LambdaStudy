package com.macroli.code.study;

import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReference {
    public static void main(String[] args) {
        //using the lambda expression
        Supplier<String> supplierFun = () -> new String();
        System.out.println("lambda: This is empty string "+ supplierFun.get());

        Function<String, String> function = (x)->new String(x);
        System.out.println(function.apply("lambda: Initial a new String"));

        //using the constructor reference
        Supplier<String> strSupplier = String::new;
        System.out.println("This is constructor reference "+strSupplier.get());

        Function<String, String> consFun = String::new;
        System.out.println(consFun.apply("This is constructor reference to new a string"));
    }

}
