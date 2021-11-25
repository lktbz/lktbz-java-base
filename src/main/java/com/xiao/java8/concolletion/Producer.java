package com.xiao.java8.concolletion;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

public class Producer implements  Runnable {
    private final TransferQueue<String>queue;

    public Producer(TransferQueue<String> queue) {
        this.queue = queue;
    }

    private  String produce(){
        String s="you luckly number"+new Random().nextInt(100);
        System.out.println("生产者生产的消息是："+s);
        return s;
    }

    @Override
    public void run() {
        while (true){
            if(queue.hasWaitingConsumer()){
                //生产消息
                queue.tryTransfer(produce());
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
