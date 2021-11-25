package com.xiao.java8.parsellConcurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: lktbz
 * @Date: 2019/7/25 16:54
 * @Description:
 */
public class TestTravell {
    public static void main(String[] args) throws InterruptedException {
        long l = System.currentTimeMillis();
        CountDownLatch countDownLatch=new CountDownLatch(2);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new AirportDemo(countDownLatch));
        executorService.execute(new TravellDemo(countDownLatch));
        countDownLatch.await();
        Executors.newCachedThreadPool();

        System.out.println("这次旅行一共花了多久"+(System.currentTimeMillis()-l));
    }
}
