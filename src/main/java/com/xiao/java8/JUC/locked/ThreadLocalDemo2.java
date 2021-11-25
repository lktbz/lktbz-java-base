package com.xiao.java8.JUC.locked;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName ThreadLocalDemo2
 * @Description 缓存的使用
 * @Author lktbz
 * @Date 2021/1/25
 */
public class ThreadLocalDemo2 {
    private static final AtomicInteger nextId = new AtomicInteger(1);
    private static final ThreadLocal<Integer> threadId = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return nextId.getAndIncrement();
        }
    };

    public static int getId() {
       return threadId.get();
    }

    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            new Thread(()->{
                System.out.println("Thread name=:"+Thread.currentThread().getName()+"-获取的值为："+getId());
            }).start();
            new Thread(()->{
                System.out.println("Thread name=:"+Thread.currentThread().getName()+"-获取的值为："+getId());
            }).start();
        }

    }
}
