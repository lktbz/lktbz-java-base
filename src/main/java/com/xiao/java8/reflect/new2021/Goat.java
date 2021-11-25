package com.xiao.java8.reflect.new2021;

/**
 * @Description TODO
 * @Author lktbz
 * @Date 2021/06/19
 */
public class Goat extends Animal implements Locomotion {
    public Goat(String goat) {
        super(goat);
    }

    @Override
    protected String getSound() {
        return "bleat";
    }

    @Override
    public String getLocomotion() {
        return "walks";
    }

    @Override
    public String eats() {
        System.out.println("被调用");
        return "grass";
    }

    // constructor omitted
}