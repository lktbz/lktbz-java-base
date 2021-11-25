package com.xiao.java8.concolletion;

import java.util.concurrent.TransferQueue;

public class Consumer implements  Runnable {
    private  final TransferQueue<String>queue;

    public Consumer(TransferQueue<String> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        try {
            System.out.println("线程："+Thread.currentThread().getName()+",正在消费的信息是："+queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
