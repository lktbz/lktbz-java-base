package com.xiao.java8.dynamicproxy;

public class LittleBoy implements  IGood {
    @Override
    public String goodboy() {
        System.out.println("腼腆的男人，不好找女人怎么办");
        return "腼腆";
    }
}
