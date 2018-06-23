package com.macroli.code.study;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionInterface {
    public static void main(String[] args) {
        //Function in T and then return R
        Function<Integer, Integer> square = (x) -> x * x;
        System.out.println(square.apply(10));

        Function<Integer, Integer> chainFun = ((Function<Integer, Integer>)((x)->x+5))
                .andThen(x->x+10)
                .andThen(x->x/3);
        System.out.println(chainFun.apply(5));

        //first executing apply of square
        int result = chainFun.compose(square).apply(3);
        System.out.println(result);

        //implement BiFunction
        MyBiFunctionClass myBiFunctionClass = new MyBiFunctionClass();
        String predicateWord = "Hello, Beautiful ";
        String noun ="Shoes";
        String resultStr = myBiFunctionClass.apply(predicateWord, noun);
        System.out.println(resultStr);

    }

}


class MyBiFunctionClass implements BiFunction<String,String,String>{
    @Override
    public String apply(String s, String s2){
        return s.concat(s2);
    }
}
