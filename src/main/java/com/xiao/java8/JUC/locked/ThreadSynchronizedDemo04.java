package com.xiao.java8.JUC.locked;

/**
 * @ClassName ThreadSynchronizedDemo04
 * @Description synchronized 锁方法级别
 * @Author lktbz
 * @Date 2021/1/10
 */
public class ThreadSynchronizedDemo04 {

    //    这是加锁的基类
    static class Counter {
        private int c = 0;

        public void increment() {
            c++;
        }

        public void decrement() {
            c--;
        }

        public int value() {
            return c;
        }
    }

    /**
     * 加锁在方法级别加锁（实例锁） 各自锁住各自的
     */
    static class SynchronizedCounter {
        private int c = 0;

        public synchronized void increment() {
            System.out.println("线程："+Thread.currentThread().getName()+"；获取了锁");
            c++;
        }

        public synchronized void decrement() {
            c--;
        }

        public synchronized int value() {
            System.out.println("线程："+Thread.currentThread().getName()+"；获取了锁");
            return c;
        }
    }
    public static void main(String[] args) throws InterruptedException {
//       锁以已经在方法上加上
//        现在创建线程
        for (int i = 0; i < 50; i++) {
             new Thread(() -> {
                 System.out.println("线程："+Thread.currentThread().getName()+"；准备获取锁");
                 SynchronizedCounter synchronizedCounter = new SynchronizedCounter();
                 synchronizedCounter.increment();
                 int value = synchronizedCounter.value();
                 System.out.println("线程："+Thread.currentThread().getName()+"值为"+value);
             },"t1").start();
            new Thread(() -> {
                System.out.println("线程："+Thread.currentThread().getName()+"；准备获取锁");
                SynchronizedCounter synchronizedCounter = new SynchronizedCounter();
                synchronizedCounter.increment();
                int value = synchronizedCounter.value();
                System.out.println("线程："+Thread.currentThread().getName()+"值为"+value);
            },"t5").start();
             new Thread(() -> {
                 System.out.println("线程："+Thread.currentThread().getName()+"；准备获取锁");
                 SynchronizedCounter synchronizedCounter = new SynchronizedCounter();
                 synchronizedCounter.increment();
                 int value = synchronizedCounter.value();
                 System.out.println("线程："+Thread.currentThread().getName()+"；释放锁");
                 System.out.println("线程："+Thread.currentThread().getName()+"值为"+value);
             },"t2").start();
            new Thread(() -> {
                System.out.println("线程："+Thread.currentThread().getName()+"；准备获取锁");
                SynchronizedCounter synchronizedCounter = new SynchronizedCounter();
                synchronizedCounter.increment();
                int value = synchronizedCounter.value();
                System.out.println("线程："+Thread.currentThread().getName()+"；释放锁");
                System.out.println("线程："+Thread.currentThread().getName()+"值为"+value);
            },"t4").start();


        }
//        main 线程一直查询
//        while (true){
//            SynchronizedCounter synchronizedCounter = new SynchronizedCounter();
//            System.out.println("获取的值为"+synchronizedCounter.value());
////            线程睡几秒，让别的线程有执行机会
//            Thread.sleep(4000);
//        }
    }
}
