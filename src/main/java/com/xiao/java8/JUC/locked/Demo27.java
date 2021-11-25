package com.xiao.java8.JUC.locked;

import java.util.concurrent.*;

/**
 * @ClassName Demo27
 * @Description ExecutorService 实现类的学习：
 *              ThreadPoolExecutor
 *              ScheduledThreadPoolExecutor
 * @Author lktbz
 * @Date 2021/1/15
 */
public class Demo27 {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(1,1,0, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());
        for (int i = 0; i <10; i++) {
            threadPoolExecutor.execute(()->{
                System.out.println("hahaha");
            });
        }
//        while (true){
//            Thread.sleep(1000);
//            System.out.println(threadPoolExecutor.getCompletedTaskCount());
//         }

        ThreadFactory threadFactory = threadPoolExecutor.getThreadFactory();
//        threadPoolExecutor.

    }}
