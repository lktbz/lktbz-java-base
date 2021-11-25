package com.xiao.java8.JUC.locked;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName CountDownDemo
 * @Description TODO
 * @Author lktbz
 * @Date 2021/1/13
 * @see CountDownLatch
 * <p>
 * /**
 * *  * A synchronization aid that allows one or more threads to wait until
 * *  * a set of operations being performed in other threads completes
 * *      让一个线程或多个线程等待，直到其他线程执行完毕
 */

/**
 * 例子需求，运动员比赛，只有5个人全部跑完才能运动结束，
 * 当跑完一个运动员，或者裁判，都必须等到5个人都过了终点站，才算可以
 */
public class CountDownDemo {
    private static final int PLAYER_AMOUNT = 5;

    public static void main(String[] args) {
        //对于每位运动员，CountDownLatch减1后即结束比赛
        CountDownLatch begin = new CountDownLatch(1);
        //对于整个比赛，所有运动员结束后才算结束
        CountDownLatch end = new CountDownLatch(PLAYER_AMOUNT);
        //构建运动员
        Player[] plays = new Player[PLAYER_AMOUNT];
        for (int i = 0; i < PLAYER_AMOUNT; i++) {
            plays[i] = new Player(i + 1, begin, end);
        }
        ExecutorService executorService = Executors.newFixedThreadPool(PLAYER_AMOUNT);
        for (Player p : plays) {
            executorService.execute(p);//为运动员分配线程
        }
        System.out.println("比赛开始!");
        System.out.println("线程："+Thread.currentThread().getName()+"在执行");
        /**
         * countDown()
         * 如果计数器为0 则唤醒其他等待的线程后
         * 如果计数器》1 ，则递减，如果计数器少于0 则什么也不做
         */
        begin.countDown();
        try {
            System.out.println("线程："+Thread.currentThread().getName()+"在执行");
            end.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("线程："+Thread.currentThread().getName()+"在执行");
            System.out.println("比赛结束");
        }
        executorService.shutdown();
    }

    static class Player implements Runnable {
        private int id;
        private CountDownLatch begin;
        private CountDownLatch end;

        public Player(int id, CountDownLatch begin, CountDownLatch end) {
            this.id = id;
            this.begin = begin;
            this.end = end;
        }

        @Override
        public void run() {
            try {
                System.out.println("线程："+Thread.currentThread().getName()+"在执行");
                begin.await();
                Thread.sleep((long) Math.random() * 100);
                System.out.println("线程："+Thread.currentThread().getName()+"在执行");
                System.out.println("运动员" + id + "：到达");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("线程："+Thread.currentThread().getName()+"在执行");
                end.countDown(); //运动员到达，减一
            }
        }
    }
}
