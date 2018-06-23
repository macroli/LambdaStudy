package com.macroli.code.study;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * TypeName::staticMethod - reference to a static method of a class, an interface, or an enum
 * ObjectRef::instanceMethod - reference to an instance method
 * ClassName::instanceMethod - reference to an instance method from a class
 * TypeName.super::instanceMethod - reference to an instance method from the supertype of an object
 * ClassName::new - reference to the constructor of a class
 * ArrayTypeName::new - reference to the constructor of the specified array type
 */
public class MethodReference {

    public static void main(String[] args) {
        //using a lambda expression
        Function<Integer, String> function = x->Integer.toBinaryString(x);
        System.out.println(function.apply(8));

        //using a reference expression
        Function<Integer, String> referFunc = Integer::toBinaryString;

        //study reference method overloading
        Function<Integer,Integer> function1 = Integer::valueOf;
        Function<String, Integer> function2 = Integer::valueOf;
        BiFunction<String,Integer,Integer> function3 = Integer::valueOf;

        System.out.println(function1.apply(123));
        System.out.println(function2.apply("456"));
        System.out.println(function3.apply("1000",2));

    }
}
