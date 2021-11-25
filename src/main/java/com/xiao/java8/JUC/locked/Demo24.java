package com.xiao.java8.JUC.locked;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName Demo24
 * @Description TODO
 * @Author lktbz
 * @Date 2021/1/15
 */
public class Demo24 {
    private static Lock lock=new ReentrantLock();
    public static void main(String[] args) {

        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);

        for (int i = 0; i <10 ; i++) {
           scheduledThreadPoolExecutor.scheduleAtFixedRate(new Worder(lock,i),
                   0,5, TimeUnit.SECONDS   //每5秒执行一次
                   );
        }
//        scheduledThreadPoolExecutor.shutdown();
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
