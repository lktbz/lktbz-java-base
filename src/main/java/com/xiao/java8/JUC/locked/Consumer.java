package com.xiao.java8.JUC.locked;

/**
 * @ClassName Consumer
 * @Description TODO
 * @Author lktbz
 * @Date 2021/1/13
 */
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
public class Consumer implements Runnable{
    private Queue<String> msg;
    private int maxSize;
    Lock lock;
    Condition condition;
    public Consumer(Queue<String> msg, int maxSize, Lock lock, Condition condition) {
        this.msg = msg;
        this.maxSize = maxSize;
        this.lock = lock;
        this.condition = condition;
    }
    @Override
    public void run() {
        int i=0;
        while(true){
            i++;
            lock.lock(); //synchronized
            //消费者进来的时候需要判断是有可用的消息，
            //没有可用的消息就等待状态
            while(msg.isEmpty()){
                System.out.println("消费者队列空了，先等待");
                try {
                    condition.await(); //阻塞线程并释放锁   wait
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("消费消息："+msg.remove());
            condition.signal(); //唤醒阻塞状态下的线程
            lock.unlock();
        }
    }
}
