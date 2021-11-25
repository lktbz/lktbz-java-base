package com.xiao.java8.JUC.locked;

/**
 * @ClassName Demo03
 * @Description join 保证线程的顺序执行
 * @Author lktbz
 * @Date 2021/1/10
 */
public class ThreadJoinDemo03 {
    static class  MyThread implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i <1 ; i++) {
                System.out.println(Thread.currentThread().getName()+"正在执行中。。。。。");
            }
        }
    }
    static class  MyThread2 implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i <1 ; i++) {
                System.out.println(Thread.currentThread().getName()+"正在执行中。。。。。");
            }
        }
    }
    static class  MyThread3 implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i <1 ; i++) {
                System.out.println(Thread.currentThread().getName()+"正在执行中。。。。。");
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        /**
         * 加入三个线程，发现有争抢，不能顺序执行了
         */
        Thread t1 =new Thread(new MyThread());
        Thread t2 =new Thread(new MyThread2());
        Thread t3 =new Thread(new MyThread3());
        /**
         * join 顺序执行
         */
        t1.join();
        t3.join();
        t2.join();
        t1.start();
        t3.start();
        t2.start();
    }

}
