package com.xiao.java8.dynamicproxy;

public class Testjdk {
    public static void main(String[] args) {
        IGood object = (IGood) new JDKDynamic().getObject(new LittleBoy());
        object.goodboy();
    }
}
