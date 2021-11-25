package com.xiao.java8.thrad.demo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: lktbz
 * @Date: 2019/7/23 21:12
 * @Description:
 */
public class ThreadLocalDemo  {
    static  ThreadLocal<String> stringThreadLocal=new ThreadLocal<>();
    ReentrantLock Lock =new ReentrantLock();
    public static void main(String[] args) {
        Thread t1=  new Thread(new Runnable() {
            @Override
            public void run() {
              stringThreadLocal.set("sss");
                System.out.println("获取其中的值"+stringThreadLocal.get());
            }
        });
        Thread t2=   new Thread(new Runnable() {
            @Override
            public void run() {
                stringThreadLocal.set("fdff");
                System.out.println("获取该线程的值"+stringThreadLocal.get());
            }
        });
        t1.start();
        t2.start();
    }
}
