package com.xiao.java8.JUC.locked;

import java.util.concurrent.*;

/**
 * @ClassName Demo20
 * @Description  线程池
 * @Author lktbz
 * @Date 2021/1/14
 */
public class Demo20 {
    public static void main(String[] args) {
//        Executor
//        Executors
//        ExecutorService
        /**
         *    Executor
         *     void execute(Runnable command);
         *     只有一个执行的方法，不需要返回值
         *
         *
         */
        /**
         * Executors
            扩展了Executor 提供了很多功能
           使用方式
         */
        /**
         * 线程池的创建手段
         */
        Executors.newFixedThreadPool(1);
        Executors.newCachedThreadPool(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return null;
            }
        });
        Executors.newSingleThreadExecutor();
        Executors.newScheduledThreadPool(1);
//        继续看其构建线程池
        /**
         *   创建线程池的执行器
         *
         *         public ThreadPoolExecutor(int corePoolSize,  核心线程数
         *                               int maximumPoolSize,  最大线程数
         *                               long keepAliveTime,  当空闲线程等待其他线程最大等待时间
         *                               TimeUnit unit,
         *                               BlockingQueue<Runnable> workQueue,  队列
         *                               ThreadFactory threadFactory,  线程工厂
         *                               RejectedExecutionHandler handler) {   拒绝执行策略
         *         if (corePoolSize < 0 ||
         *             maximumPoolSize <= 0 ||
         *             maximumPoolSize < corePoolSize ||
         *             keepAliveTime < 0)
         *             throw new IllegalArgumentException();
         *         if (workQueue == null || threadFactory == null || handler == null)
         *             throw new NullPointerException();
         *         this.corePoolSize = corePoolSize;
         *         this.maximumPoolSize = maximumPoolSize;
         *         this.workQueue = workQueue;
         *         this.keepAliveTime = unit.toNanos(keepAliveTime);
         *         this.threadFactory = threadFactory;
         *         this.handler = handler;
         *     }
         *     疑问？
         *     1：为什么是阻塞队列？
         *     2：执行什么样的拒绝策略？
         */


    }
}
