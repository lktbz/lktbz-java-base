package com.xiao.java8.concolletion;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) {
        new CopyOnWriteArrayListDemo().run();
    }
    /**
     * 读线程
     */
    private  static  class readThread implements Runnable{
        List<String> list;
        public readThread(List<String> list) {
        this.list = list;
        }
        public void run() {
            for (String str : list) {
                System.out.println(str);
            }
        }
    }
    /**
     * 写线程
     */
    private  static  class writeThread implements Runnable{
        List<String> list;
        int index;

        public writeThread(List<String> list,int index) {
            this.list = list;
            this.index=index;
        }

        public void run() {
         list.remove(index);
         list.add(index,"write"+index);
        }

    }

    public void run(){
        final  int NUM=100000;
        CopyOnWriteArrayList<String> alii = new CopyOnWriteArrayList<String>();
//        List<String>alii=new ArrayList<String>();
        for (int i=0;i<NUM;i++){
            alii.add("main"+i);
        }
        //线程池
        ExecutorService executorService = Executors.newFixedThreadPool(NUM);
        for (int i=0;i<NUM;i++){
            executorService.submit(new readThread(alii) );
            executorService.submit(new writeThread(alii,i));
        }
    }

}
