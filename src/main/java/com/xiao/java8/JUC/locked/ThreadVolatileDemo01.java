package com.xiao.java8.JUC.locked;

/**
 * @ClassName Demo01
 * @Description volatile 使用 ,避免数据不一致性
 * @Author lktbz
 * @Date 2021/1/10
 */
public class ThreadVolatileDemo01 {
    /**
     * 两个线程修改 a 同时保持顺序递增
     */
//    private static    int  a=100;
    private static  volatile  int  a=104;
    public static void main(String[] args) throws InterruptedException {
        ThreadVolatileDemo01 demo01=new ThreadVolatileDemo01();
        Thread[] threads = new Thread[2];
        for (int i = 0; i <2 ; i++) {
            threads[i]=new ThreadVolatileDemo(demo01);
        }
        for (int i = 0; i <2 ; i++) {
            threads[i].start();
        }
        for (int i = 0; i <2 ; i++) {
            threads[i].join();
        }

    }
    public int getA(){
        return a;
    }
    public void incrA(){
         ++a;
    }

    public static class ThreadVolatileDemo  extends Thread   {
       private ThreadVolatileDemo01 demo01;

        public ThreadVolatileDemo(ThreadVolatileDemo01 demo01) {
            this.demo01 = demo01;
        }
        @Override
        public void run() {
            int oldA = demo01.getA();
            System.out.println("[Thread " + Thread.currentThread().getName() + "]: Old value = " + oldA);
            demo01.incrA();
            int newA = demo01.getA();
            System.out.println("[Thread " + Thread.currentThread().getName() + "]: New value = " + newA);
        }
    }

    /**
     *  第一代版本的volatile demo 现在进行修改
        */
    public static  void oldMethod(){
        new Thread(()->{
            while (a<10000){
                a++;
                System.out.println("thread-1=="+a);
            }
        }).start();
        new Thread(()->{
            while (a<10000){
                a++;
                System.out.println("thread-2=="+a);
            }
        }).start();
        //线程休息几秒
        // Thread.sleep(2000);
        System.out.println("经过线程修改获取最后的值为"+a);
    }
}
