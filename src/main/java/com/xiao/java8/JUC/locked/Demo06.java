package com.xiao.java8.JUC.locked;

import java.util.Random;

/**
 * @ClassName Demo06
 * @Description 对象锁的使用方式一：
 * @Author lktbz
 * @Date 2021/1/10
 */
public class Demo06 {
    private static int c = 0;
    public void increment(int c){
        System.out.println("线程：" + Thread.currentThread().getName() + "；尝试获取锁");
        synchronized (this) {
            //睡一会，在看看同时的情况
            try {
                System.out.println("线程：" + Thread.currentThread().getName() + "；获取了锁");
                c++;
                Thread.sleep(10000);
                System.out.println("线程：" + Thread.currentThread().getName() + "；睡眠结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        Random random = new Random();
//        for (int i = 0; i <30 ; i++) {
//            int i1 = random.nextInt(3);
//            if(i1==0){
//                new  Thread(()->{
//                  new Demo06().increment(c);
//                },"王五").start();
//            }else if(i1==1){
//                new  Thread(()->{
//                    new Demo06().increment(c);
//                },"lisi").start();
//            }else {
//                new  Thread(()->{
//                    new Demo06().increment(c);
//                },"zs").start();
//            }
//        }
//        直接循环30次，3个线程同时抢
        for (int i = 0; i < 30; i++) {
                new Thread(() -> {
                    new Demo06().increment(c);
                }, "王五").start();
                new Thread(() -> {
                    new Demo06().increment(c);
                }, "lisi").start();
                new Thread(() -> {
                    new Demo06().increment(c);
                }, "zs").start();
        }
    }
}
