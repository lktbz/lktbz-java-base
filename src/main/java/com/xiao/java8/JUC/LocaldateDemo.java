package com.xiao.java8.JUC;

import java.time.Clock;
import java.time.LocalDate;

/**
 * @Auther: lktbz
 * @Date: 2019/7/26 16:06
 * @Description:
 */
public class LocaldateDemo {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now);
        LocalDate now2 = LocalDate.now(Clock.systemUTC());
        System.out.println(now2);


    }
}
