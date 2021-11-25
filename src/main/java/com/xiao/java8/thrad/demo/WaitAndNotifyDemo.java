package com.xiao.java8.thrad.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: lktbz
 * @Date: 2019/7/22 23:26
 * @Description: 创建一个生产者与消费者模型，
 */
public class WaitAndNotifyDemo {
    private  int MAX=10;
    private List<String>queue= new ArrayList<>(10);
    /**
     * 消费者
     * @return
     */
    public  String get() throws InterruptedException {
        synchronized (queue){
            while (queue.size()==0){
                queue.wait();
                System.out.println("没有数据只能阻塞掉");
            }
            String s = queue.remove(queue.size()-1);
            queue.notifyAll();
            return s;
        }
    }
    /**
     * 生产者
     */
    public  void  put(String s){
        synchronized (queue){
            while (queue.size()==MAX){
                System.out.println("生产的产品太多，现在需要取消生产");
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            queue.add(s);
            queue.notifyAll();
        }
    }

    public static void main(String[] args) {
        WaitAndNotifyDemo blockingQueue=new WaitAndNotifyDemo();
        new Thread(() -> {
            int i = 0;
            while (true) {
                try {
                    i++;
                    String s = blockingQueue.get();
                    System.out.println("消费：" + System.currentTimeMillis() + ":" + s);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();


        new Thread(() -> {
            int i = 0;
            while (true) {
                try {
                    blockingQueue.put(String.valueOf(i));
                    System.out.println("生产：" + System.currentTimeMillis() + ":" + i);

                    Thread.sleep(100);

                    i++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();

    }
}
