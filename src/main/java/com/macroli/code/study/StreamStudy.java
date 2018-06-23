package com.macroli.code.study;

import javax.swing.text.html.parser.Entity;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamStudy {
    public static void main(String[] args) {
        List<String> alpha = Arrays.asList("a", "b", "c", "d");
        List<String> alphaKey = Arrays.asList("1", "2", "3", "4");
        System.out.println(alpha.stream().skip(1).collect(Collectors.toList()));

        Map map = alpha.stream().collect(Collectors.toMap(Function.identity(), x -> x));
        System.out.println(map.entrySet());

        Map map1  = alpha.stream().collect(Collectors.toMap(Function.identity(), x -> alpha));
        System.out.println(map1.entrySet());

    }
}
