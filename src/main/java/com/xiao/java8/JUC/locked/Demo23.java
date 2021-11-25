package com.xiao.java8.JUC.locked;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName Demo21
 * @Description 单线程的线程池
 * @Author lktbz
 * @Date 2021/1/15
 * 需求：
 *  工作者10个人，每天排队吃饭
 */
public class Demo23 {
    private static Lock lock=new ReentrantLock();
    public static void main(String[] args) {
        /**
         * 从运行结果看，因为是单线程，不管有无锁，都顺序执行
            newCachedThreadPool
            字面上看。就是带缓存功能的线程池

             return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
             60L, TimeUnit.SECONDS,
             new SynchronousQueue<Runnable>());
             上面的构造函数，
              60秒
                同步的队列
         */
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i <10 ; i++) {
            executorService.execute(new Worder(lock,i));
        }
        executorService.shutdown();
    }

    static  class Worder extends Thread{
        private Lock lock;
        private Integer id;

        public Worder(Lock lock, Integer id) {
            this.lock = lock;
            this.id = id;
        }

        public Worder(Lock lock) {
            this.lock = lock;
        }
        @Override
        public void run() {
//            同步排队
           doLockWork(lock,id);
//            非同步排队
//            doWork(id);
        }
        private void doWork(Integer id) {
            try {
                Thread.sleep(2000); //模拟排队打饭
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("工友："+id+"正在使用座椅"+Thread.currentThread().getName()+"-准备吃饭");
        }
        private void doLockWork(Lock lock,Integer id) {
            lock.lock();
            try {
              Thread.sleep(2000); //模拟排队打饭
              System.out.println("工友："+id+"正在使用座椅"+Thread.currentThread().getName()+"-准备吃饭");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
