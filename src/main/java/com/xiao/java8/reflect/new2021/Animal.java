package com.xiao.java8.reflect.new2021;

/**
 * @Description TODO
 * @Author lktbz
 * @Date 2021/06/19
 */
public abstract class Animal implements Eating {

    public static String CATEGORY = "domestic";
    private String name;

    public Animal(String name) {
    }

    protected abstract String getSound();

    // constructor, standard getters and setters omitted
}
