package com.xiao.java8.JUC.locked;


import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName Demo12
 * @Description ReentrantLocks 重入锁
 * @Author lktbz
 * @Date 2021/1/12
 */
public class Demo12 {
//    公平与非公平测试
    //  private static ReentrantLock lock=new ReentrantLock();
    private static ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        new Demo12().TestIsFair();
    }
    /**
     * 公平与非公平测试
     */
    public void TestIsFair() {
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                new Demo12().Locks(lock);
            },"jjjj").start();
            new Thread(() -> {
                new Demo12().Locks(lock);
            },"lsssl").start();
            new Thread(() -> {
                new Demo12().Locks(lock);
            },"lll").start();
        }

    }

    public void Locks(ReentrantLock lock) {
        try {
            System.out.println("线程id" + Thread.currentThread().getId() + "-->name" + Thread.currentThread().getName() + "尝试获取锁");

//          lock.tryLock();//试图获取锁
            lock.lock();
            System.out.println("线程id" + Thread.currentThread().getId() + "-->name" + Thread.currentThread().getName() + "获取锁");
            System.out.println("线程"+ Thread.currentThread().getName()+"to do.............");

        } finally {
            lock.unlock();
            System.out.println("线程id" + Thread.currentThread().getId() + "-->name" + Thread.currentThread().getName() + "释放锁");
        }

    }
}
