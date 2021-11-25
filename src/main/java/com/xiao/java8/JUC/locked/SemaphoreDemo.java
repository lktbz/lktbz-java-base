package com.xiao.java8.JUC.locked;

import java.util.concurrent.Semaphore;

/**
 * @ClassName SemaphoreDemo
 * @Description TODO
 * @Author lktbz
 * @Date 2021/1/14
 */
public class SemaphoreDemo {
    /**
     * 假若一个工厂有5台机器，但是有8个工人，一台机器同时只能被一个工人使用，只有使用完了，其他工人才能继续使用
     * @param args
     */
    public static void main(String[] args) {
        int n=8;
        Semaphore semaphore=new Semaphore(5);
        for (int i = 0; i <n ; i++) {
            new Worker(i,semaphore).start();
        }
    }
    static  class Worker extends Thread{
        private int num;
        private Semaphore semaphore;
        public Worker(int num,Semaphore semaphore){
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
           try {
               semaphore.acquire();
               System.out.println("工人"+this.num+"占用一个机器在生产...");
               Thread.sleep(2000);
               System.out.println("工人"+this.num+"释放出机器");
               semaphore.release();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
        }
    }
}
