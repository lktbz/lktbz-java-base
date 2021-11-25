package com.xiao.java8.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName DifferentWaysListIterateProgram
 * @Description 三种遍历方式
 * @Author lktbz
 * @Date 2020/12/4
 */
public class DifferentWaysListIterateProgram {
    public static void main(String[] args) {
        List< String > courses = Arrays.asList("C", "C++", "Core Java", "J2EE", "Spring", "Hibernate", "Python");
        // JDK 8 streaming example lambda expression
        courses.stream().forEach(course -> printCourse(course));

        // JDK 8 streaming example method reference
        courses.stream().forEach(DifferentWaysListIterateProgram::printCourse);

        // JDK 8 for each
        courses.forEach(DifferentWaysListIterateProgram::printCourse);
    }

    private static void printCourse(String course) {
        System.out.println("course name :: " + course);
    }
}
