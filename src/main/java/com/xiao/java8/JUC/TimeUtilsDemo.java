package com.xiao.java8.JUC;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: lktbz
 * @Date: 2019/7/26 16:10
 * @Description: 对它的理解，就是替换 Thread.sleep 以及更方便的进行分转秒，天转小时等操作
 */
public class TimeUtilsDemo {
    private TimeUnit timeUnit =TimeUnit.DAYS;
    public static void main(String[] args) {
       /** new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("请倒计时5秒");
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println("倒计时结束了。。。");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("aaa");
            }
        }).start();**/
        TimeUtilsDemo demo = new TimeUtilsDemo();
        demo.outInfo();
        demo.timeUnit =TimeUnit.HOURS;
        demo.outInfo();
        demo.timeUnit =TimeUnit.MINUTES;
        demo.outInfo();
        demo.timeUnit =TimeUnit.SECONDS;
        demo.outInfo();
    }
    public void outInfo() {
        System.out.println(timeUnit.name());
        System.out.println(timeUnit.toDays(1));
        System.out.println(timeUnit.toHours(1));
        System.out.println(timeUnit.toMinutes(1));
        System.out.println(timeUnit.toMicros(1));
        System.out.println(timeUnit.toMillis(1));
        System.out.println(timeUnit.toNanos(1));
        System.out.println(timeUnit.toSeconds(1));
        System.out.println("1天有"+(timeUnit.convert(1, TimeUnit.DAYS))+timeUnit.name());
        System.out.println("12小时"+(timeUnit.convert(12, TimeUnit.HOURS))+timeUnit.name());
        System.out.println("3600秒有"+(timeUnit.convert(36000, TimeUnit.MINUTES))+timeUnit.name());
        System.out.println("-------------------");
    }

}
