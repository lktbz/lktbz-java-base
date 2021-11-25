package com.xiao.java8.atomics;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName Demo01
 * @Description 原子类 AtomicInteger
 * @Author lktbz
 * @Date 2021/1/15
 */
public class Demo01 {
    public static void main(String[] args) {
        //给个初始值
        AtomicInteger integer=new AtomicInteger(2);
        System.out.println("获取值"+integer.get());

        int i = integer.incrementAndGet();
        System.out.println("自增"+i);

        int i1 = integer.decrementAndGet();
        System.out.println("自减"+i1);
        /**
         * 先比较在设置
         */
        boolean b = integer.compareAndSet(2, 5);
        System.out.println(b);

        System.out.println("获取值"+integer.get());
        /**
         * 相加指定的值
         */
        int i2 = integer.addAndGet(2);
        System.out.println("addAndGet-"+i2);

        integer.set(20);

        System.out.println("获取值"+integer.get());

        double v = integer.doubleValue();
        System.out.println("转换成"+v);

        float v1 = integer.floatValue();
        System.out.println("转换成"+v1);

//        int andAdd = integer.getAndAdd(2);
//        System.out.println("getAndAdd-"+andAdd);
        int andDecrement = integer.getAndDecrement();
        System.out.println("getAndDecrement"+andDecrement);
        /**
         * 设置新值，返回旧值
         */
        int andSet = integer.getAndSet(15);
        System.out.println("andSet"+andSet);

    }
}
