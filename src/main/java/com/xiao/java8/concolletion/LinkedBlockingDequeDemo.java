package com.xiao.java8.concolletion;

import java.util.NoSuchElementException;
import java.util.concurrent.LinkedBlockingDeque;

public class LinkedBlockingDequeDemo {
    private  static   LinkedBlockingDeque<String> linkedBlockingDeque=null;
    public static void main(String[] args) {
        linkedBlockingDeque =new LinkedBlockingDeque<String>();
        linkedBlockingDeque.add("aaa");
        linkedBlockingDeque.add("bb");
        linkedBlockingDeque.add("dd");
        linkedBlockingDeque.add("eee");
        //使用take 发现，被阻塞了
         /**for (int i=0;i<10;i++){
           String take = null;
           try {
               take = linkedBlockingDeque.take();
           } catch (InterruptedException e) {
               e.printStackTrace();
               System.out.println(e.getMessage());
           }
           System.out.println(i+"获取到的值为："+take);
       }**/
        /**
         * 抛出去异常，循环方法还在继续执行


        for (int i=0;i<10;i++){
            String take = null;
            try {
                take = linkedBlockingDeque.remove();
            } catch (NoSuchElementException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
            System.out.println(i+"获取到的值为："+take);
        }
         */

        /**
         * 如果会返回一个true 或者false
         */
        for (int i=0;i<10;i++){
            String take = null;
            try {
                take = linkedBlockingDeque.poll();
            } catch (NoSuchElementException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
            System.out.println(i+"获取到的值为："+take);
        }



    }

}
