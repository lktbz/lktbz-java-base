package com.xiao.java8.JUC.locked;

import java.util.concurrent.SynchronousQueue;

/**
 * @Classname SynchronousQueueDemo
 * @Description 可以实现锁的功能
 * @Date 2021/6/1
 * @Created by lktbz
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        final SynchronousQueue<Integer> queue = new SynchronousQueue<Integer>();
        Thread putThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("put thread start");
                try {
                    queue.put(1);
                    System.out.println("线程是否进行阻塞");
                } catch (InterruptedException e) {
                }
                System.out.println("put thread end");
            }
        });
        Thread putThread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("put2 thread start");
                try {
                    queue.put(2);
                    System.out.println(" put2 线程是否进行阻塞");
                } catch (InterruptedException e) {
                }
                System.out.println("put2 thread end");
            }
        });
        Thread takeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("take thread start");
                try {
                    System.out.println("take from putThread: " + queue.take());
                } catch (InterruptedException e) {
                }
                System.out.println("take thread end");
            }
        });
        Thread takeThread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("take2 thread start");
                try {
                    System.out.println("take2 from putThread: " + queue.take());
                } catch (InterruptedException e) {
                }
                System.out.println("take2 thread end");
            }
        });

        putThread.start();
        Thread.sleep(1000);
       // putThread2.start();
        //Thread.sleep(1000);
        takeThread.start();
        Thread.sleep(1000);
        //takeThread2.start();
    }
}
