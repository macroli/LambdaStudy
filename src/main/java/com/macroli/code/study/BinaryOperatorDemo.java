package com.macroli.code.study;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class BinaryOperatorDemo {
    public static void main(String[] args) {
        Student s1 = new Student("Shyam", 22, "A");
        Student s2 = new Student("Ram", 23, "A");
        Student s3 = new Student("Mohan", 22, "B");
        Student s4 = new Student("Ramesh", 21, "B");
        List<Student> list = Arrays.asList(s1, s2, s3, s4);

        Comparator<Student> comparatorAge = Comparator.comparing(Student::getAge);

        Map<String,Optional<Student>> oldestByClass = list.stream().collect(Collectors.groupingBy(Student::getClassName,
                Collectors.reducing(BinaryOperator.maxBy(comparatorAge))));

        oldestByClass.forEach((k,v)->System.out.println("Class:"+k+" Age:"+v.get().getAge()));

        BinaryOperator<String> studentBinaryOperator = (x, y)->x+"---"+y;

        List<String> resulsts = binaryOperationFun(studentBinaryOperator, list);
        resulsts.forEach((s)->System.out.println(s));

    }
    private static List<String> binaryOperationFun(BinaryOperator<String> studentBinaryOperator, List<Student> students)
    {
        List<String> stringList = new ArrayList<>();
        students.stream().forEach((x)->stringList.add(studentBinaryOperator.apply(x.getName(),x.getClassName())));
        return stringList;
    }
}

class Student {
    private String name;
    private Integer age;
    private String className;

    public Student(String name, Integer age, String className) {
        this.name = name;
        this.age = age;
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getClassName() {
        return className;
    }
}

