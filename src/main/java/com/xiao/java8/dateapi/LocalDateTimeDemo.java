package com.xiao.java8.dateapi;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * @ClassName LocalDateTimeDemo
 * @Description TODO
 * @Author lktbz
 * @Date 2020/12/17
 */
public class LocalDateTimeDemo {
    public static <SystemClock> void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalDateTime now1 = LocalDateTime.now(ZoneId.ofOffset("GMT", ZoneOffset.UTC));
        System.out.println(now1);
        //日期格式化
        String s7 = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS"));
        System.out.println(s7);
        //系统默认时间日期
        Clock clock = Clock.systemDefaultZone();
        System.out.println("clock"+clock);
        Clock clock1 = Clock.systemUTC();
        System.out.println("clock1"+clock1);
//        获取时间戳
        Long mims=  LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println(mims);


    }
}
