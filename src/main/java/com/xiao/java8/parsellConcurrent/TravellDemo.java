package com.xiao.java8.parsellConcurrent;

import java.util.Objects;
import java.util.concurrent.CountDownLatch;

/**
 * @Auther: lktbz
 * @Date: 2019/7/25 16:48
 * @Description: 带着媳妇出去旅游
 */
public class TravellDemo implements Runnable {
    private CountDownLatch latch;

    public TravellDemo(CountDownLatch latch) {
        this.latch = latch;
    }
    @Override
    public void run() {
        try {

            System.out.println("已经上飞机了，正在去目的地");
            Thread.sleep(4000);
            System.out.println("目的地到了。。。。。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if(!Objects.isNull(latch)){

                latch.countDown();
            }
        }
    }
}
