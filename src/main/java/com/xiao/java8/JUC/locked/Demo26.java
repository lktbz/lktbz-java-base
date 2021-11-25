package com.xiao.java8.JUC.locked;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName Demo26
 * @Description 线程池相关操作
 * @Author lktbz
 * @Date 2021/1/15
 */
public class Demo26 {
    public static void main(String[] args) throws InterruptedException {
        //hello world
//            demo01();
        demo02();
    }
    /**
     * 优雅的关闭线程
     * @throws InterruptedException
     */
    public static void demo01() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(()->{
            for (int i = 0; i <5 ; i++) {
                System.out.println("线程"+i+"正在执行中");
                try {
                    Thread.sleep(1000);
                    System.out.println("thread name"+Thread.currentThread().getName());
                } catch (InterruptedException e) {
                }
            }
        });
        executorService.shutdown();
        while (true){
            //isTerminated 线程池全部结束任务并且执行官关闭线程池操作
            boolean trueorfalse= executorService.isTerminated();
            Thread.sleep(1000);
            System.out.println("thread name"+Thread.currentThread().getName());
            System.out.println(trueorfalse);
            if(trueorfalse){
                break;
            }
        }
    }
    /**
     * ExecutorService api 练习
     *  优雅的关闭线程
         */
    public static void demo02() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(()->{
            for (int i = 0; i <5 ; i++) {
                System.out.println("线程"+i+"正在执行中");
                try {
                    Thread.sleep(100);
                    System.out.println("thread name"+Thread.currentThread().getName());
                } catch (InterruptedException e) {
                }
            }
        });
        executorService.shutdown();
        /**
         * awaitTermination 如果在等待的时间内，任务没有结束，返回false ，在等待的事件内结束返回true
         * 用来配合关闭线程池
         */
        boolean b = executorService.awaitTermination(10, TimeUnit.SECONDS);
        if(b){
            System.out.println("b");
        }else{
            System.out.println("bb");
        }


    }
}
