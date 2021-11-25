package com.xiao.java8.JUC.locked;

/**
 * @ClassName WriteStarvation
 * @Description TODO
 * @Author lktbz
 * @Date 2021/1/12
 */
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class WriteStarvation {

    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private static Lock readLock = lock.readLock();

    private static Lock writeLock = lock.writeLock();


    static class WriteThread extends Thread {
        @Override
        public void run() {
            writeLock.lock();

            try {
                System.out.println("I am writing.");
            } finally {
                writeLock.unlock();
            }
        }
    }

    static class ReadThread extends Thread {

        private int i;

        public ReadThread(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            readLock.lock();
            try {
                System.out.println("I am reading " + i);
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                readLock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReadThread(0).start();

        //为了确保读线程先启动
        Thread.sleep(1000);

        new WriteThread().start();

        //启动100个读线程
        for (int i = 1; i <= 100; i++) {
            new ReadThread(i).start();
        }
    }
}
