package com.xiao.java8.dateapi;

import java.time.LocalTime;

/**
 * @ClassName LocalTimeDemo
 * @Description TODO
 * @Author lktbz
 * @Date 2020/12/17
 */
public class LocalTimeDemo {
    public static void main(String[] args) {
        System.out.println(LocalTime.now());

        System.out.println(LocalTime.parse("06:30"));
        System.out.println(LocalTime.of(6,30));
        System.out.println(LocalTime.now().getHour());

        //根据传入的字符串转换成日期
        String s="17:11:09";
        System.out.println(LocalTime.parse(s));


    }
}
