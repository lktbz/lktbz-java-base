package com.xiao.java8.dateapi;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @ClassName LocalDateDemo
 * @Description TODO
 * @Author lktbz
 * @Date 2020/12/17
 */
public class LocalDateDemo {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
    public static void main(String[] args) {
        //安全的不可修改的时间
        System.out.println("次方法使用方式"+LocalDate.of(2012,9,21));
        System.out.println("本机时间"+LocalDate.now());
        System.out.println("下一天"+LocalDate.now().plusDays(1));
        System.out.println("标准日期前二天"+LocalDate.now().minus(2, ChronoUnit.DAYS));
        LocalDate now = LocalDate.now(ZoneId.systemDefault());
        System.out.println(now);

        //日期的格式化
        System.out.println( now.format(DateTimeFormatter.BASIC_ISO_DATE));
        System.out.println( now.format(DateTimeFormatter.ISO_DATE));

        System.out.println(formatter.format(LocalDate.parse("16/08/2016", formatter)));

    }
}
