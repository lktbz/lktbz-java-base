package com.xiao.java8.lambda;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName DifferentWaysMapIterateProgram
 * @Description map
 * @Author lktbz
 * @Date 2020/12/4
 */
public class DifferentWaysMapIterateProgram {
    public static void main(String[] args) {
        Map< Integer, String > coursesMap = new HashMap< Integer, String >();
        coursesMap.put(1, "C");
        coursesMap.put(2, "C++");
        coursesMap.put(3, "Java");
        coursesMap.put(4, "J2EE");
        coursesMap.put(5, "Python");
        coursesMap.put(6, "Scala");

        // JDK 8 for each with lambda
        coursesMap.forEach((k, v) -> coursePrinter(k, v));

        // JDK 8 for each method reference
        coursesMap.forEach(DifferentWaysMapIterateProgram::coursePrinter);
    }
    // common method to print map key value
    private static void coursePrinter(Integer number, String brand) {
        System.out.println("course no : " + number + " and course name : " + brand);
    }
}
