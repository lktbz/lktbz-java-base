package com.xiao.java8.parsellConcurrent;

import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: lktbz
 * @Date: 2019/7/25 16:49
 * @Description: 旅游之前必须要买机票
 */
public class AirportDemo  implements  Runnable{
    private  CountDownLatch countDownLatch;

    public AirportDemo(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
        try {
            System.out.println("我正在浏览飞机票。。。");
            Thread.sleep(3000);
            System.out.println("我买好了飞机票");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if(!Objects.isNull(countDownLatch)){

                countDownLatch.countDown();

            }
        }

    }
}
