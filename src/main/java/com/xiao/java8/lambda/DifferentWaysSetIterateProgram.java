package com.xiao.java8.lambda;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName DifferentWaysSetIterateProgram
 * @Description set
 * @Author lktbz
 * @Date 2020/12/4
 */
public class DifferentWaysSetIterateProgram {
    public static void main(String[] args) {
        Set< String > courses = new HashSet< String >();
        courses.add("Java");
        courses.add("C");
        courses.add("C++");
        courses.add("Python");
        courses.add("Scala");

        // JDK 8 streaming example lambda expression
        courses.stream().forEach(course -> coursePrinter(course));

        // JDK 8 streaming example method reference
        courses.stream().forEach(DifferentWaysSetIterateProgram::coursePrinter);

        // JDK 8 for each with lambda
        courses.forEach(course -> coursePrinter(course));

        // JDK 8 for each
        courses.forEach(DifferentWaysSetIterateProgram::coursePrinter);
    }

    private static void coursePrinter(String course) {
        System.out.println("course name :: " + course);
    }
}
