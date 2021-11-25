package com.xiao.java8.JUC.locked;

import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * @ClassName Demo28
 * @Description ScheduledThreadPoolExecutor 例子
 * @Author lktbz
 * @Date 2021/1/15
 */
public class Demo28 {


    public static void main(String[] args) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor =new ScheduledThreadPoolExecutor(1);
//         scheduledThreadPoolExecutor.schedule(new MyThread(),10, TimeUnit.MILLISECONDS);
//            scheduledThreadPoolExecutor.scheduleAtFixedRate();
    }
    static class  MyThread implements Runnable{
        @Override
        public void run() {
            System.out.println("执行。。。。");
        }
    }
}
