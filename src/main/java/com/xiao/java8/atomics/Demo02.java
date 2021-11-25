package com.xiao.java8.atomics;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @ClassName Demo02
 * @Description 原子比较类
 * @Author lktbz
 * @Date 2021/1/15
 */
public class Demo02 {
    public static void main(String[] args) {
        AtomicBoolean atomicBoolean=new AtomicBoolean(false);
        boolean b = atomicBoolean.compareAndSet(false, true);
        System.out.println("compareAndSet__"+b);
        boolean b1 = atomicBoolean.get();
        System.out.println("get"+b1);
        boolean andSet = atomicBoolean.getAndSet(false);
        System.out.println("getAndSet--"+andSet);
    }
}
