package com.xiao.java8.reflect.new2021;

/**
 * @Description TODO
 * @Author lktbz
 * @Date 2021/06/19
 */
public class Bird extends Animal {
    private boolean walks;
    private String name;
    public Bird() {
        super("bird");
    }

    public Bird(String name, boolean walks) {
        super(name);
        setWalks(walks);
    }

    private void setWalks(boolean walks) {
    }

    public Bird(String name) {
        super(name);
    }

    public boolean walks() {
        return walks;
    }

    @Override
    protected String getSound() {
        return null;
    }

    @Override
    public String eats() {
        return null;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "walks=" + walks +
                ", name='" + name + '\'' +
                '}';
    }
    // standard setters and overridden methods
}