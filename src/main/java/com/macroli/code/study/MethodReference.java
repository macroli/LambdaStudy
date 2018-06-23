package com.macroli.code.study;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

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
        Function<Integer, String> function = x -> Integer.toBinaryString(x);
        System.out.println(function.apply(8));

        //using a reference expression
        Function<Integer, String> referFunc = Integer::toBinaryString;

        //study reference method overloading
        Function<Integer, Integer> function1 = Integer::valueOf;
        Function<String, Integer> function2 = Integer::valueOf;
        BiFunction<String, Integer, Integer> function3 = Integer::valueOf;

        System.out.println(function1.apply(123));
        System.out.println(function2.apply("456"));
        System.out.println(function3.apply("1000", 2));

        //reference to an instance method
        //a lambda expression
        Supplier<Integer> supplier = () -> "Supplier doesn't pass in parameters".length();

        Supplier<Integer> refSupplier = "Reference to an instance method!"::length;

        System.out.println(supplier.get());
        System.out.println(refSupplier.get());

        //Consumer doesn't return value
        Util util = new Util();
        Consumer<String> consumer = (x) -> util.print(x);
        consumer.accept("pass in parameters");

        Consumer<String> refConsumer = util::print;
        refConsumer.accept("no return value");

        util.debug();

        //Unbound Instance Method Reference
        String string = new String();
        Function<String, Integer> unboundFunc = String::length;
        BiFunction<String, String, String> biFunc = (x, y) -> x.concat(y);

        String hello = "Hello ";
        System.out.println(biFunc.apply(hello, "Macro") + " hello length is: " + unboundFunc.apply(hello));

        String appendStr = "Macro!";
        BiFunction<String, String, String> staticFunc = Util::append;
        System.out.println(staticFunc.apply(hello, appendStr));

        //supertype instance method reference
        MyUtil myUtil = new MyUtil();
        myUtil.superType();


    }
}

class Util {
    private int count = 0;

    public void print(String s) {
        System.out.println(s);
        count++;
    }

    public void debug() {
        System.out.println("count:" + count);
    }

    public static String append(String str, String str2) {
        return str.concat(str2);
    }
}

class MyUtil extends ParentUtil{
    public void superType(){
        BiFunction<String, String, String> strFunc = this::append;
        System.out.println(strFunc.apply("invoke"," child append method"));

        strFunc = MyUtil.super::append;
        System.out.println(strFunc.apply("inoke", " parent append method"));

    }
    @Override
    public String append(String s1, String s2) {
        System.out.println("The children append");
        return s1.concat(s2);
    }
}

class ParentUtil{
    public String append(String s1,String s2){
        System.out.println("parent append");
        return s1+s2;
    }
}
