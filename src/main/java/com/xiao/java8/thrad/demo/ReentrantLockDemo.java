package com.xiao.java8.thrad.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: lktbz
 * @Date: 2019/7/24 10:34
 * @Description:
 */
public class ReentrantLockDemo  implements Runnable{
     Lock lock =new ReentrantLock();
    public static void main(String[] args) {
        ReentrantLockDemo demo =new ReentrantLockDemo();
         new Thread(demo).start();
         new Thread(demo).start();
    }
    @Override
    public void run() {
        try{
            /**
             *枷锁
             */
            lock.lock();
            for (int i=0;i<5;i++)
            {
                System.out.println("the name of thread-->"+Thread.currentThread().getName()+"：-->i");
            }
        }finally {
            /**
             * 释放锁
             */
            lock.unlock();
        }

    }
}
