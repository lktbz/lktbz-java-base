package com.xiao.java8.JUC.locked;

/**
 * @ClassName Demo07
 * @Description 独享获取锁方式二：通过组合
 * @Author lktbz
 * @Date 2021/1/10
 *
 * 结论：
 * 通过对象synchronized 在开发中使用总结：
 *      public synchronized void show (){
 * 	    //TODO
 *       }
 *       对于方法级别的锁，锁住的是当前实例对象的锁  锁的范围有点小
 *
 *          public  static synchronized void show (){
 *  * 	    //TODO
 *  *        }
 *          静态方法锁
 *          与类同时存在，其锁住所有实例中的锁，锁的范围比较大
 *
 *
 *
 *    同步代码块大致有三种使用途径，可以实现类级锁也可以实现对象锁：
 *    第一种，实现类级锁：
 *
        public static void main(String[] args) {
        synchronized(SynClass.class){
        //TODO
        }
        }

 *
 *
 */
public class Demo07 {
    //    定义两个对象锁
    private Object lock1 = new Object();
    private Object lock2 = new Object();
    private static int c1 = 0;
    public void increment(int c) {
        System.out.println("线程：" + Thread.currentThread().getName() + "；尝试获取锁");
        synchronized (lock1) {
            System.out.println("线程：" + Thread.currentThread().getName() + "；获取了锁");
            c1++;
            getValue();
        }
        System.out.println("线程：" + Thread.currentThread().getName() + "；释放了锁");
    }
    public void dencrement(int c) {
        System.out.println("线程：" + Thread.currentThread().getName() + "；尝试获取锁");
        synchronized (lock2) {
            System.out.println("线程：" + Thread.currentThread().getName() + "；获取了锁");
            c1--;
            getValue();
        }
        System.out.println("线程：" + Thread.currentThread().getName() + "；释放了锁");
    }
    private  void getValue(){
        System.out.println("c 的值为"+c1);
    }
    public static void main(String[] args) {

        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                new Demo07().increment(c1);
            }, "王五").start();
            new Thread(() -> {
                new Demo07().increment(c1);
            }, "lisi").start();
            new Thread(() -> {
                new Demo07().dencrement(c1);
            }, "zs").start();
            new Thread(() -> {
                new Demo07().increment(c1);
            }, "oo").start();
            new Thread(() -> {
                new Demo07().dencrement(c1);
            }, "gg").start();
        }
    }
}
