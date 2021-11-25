package com.xiao.java8.JUC.locked;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Classname ConditionWaitDemo
 * @Description TODO
 * @Date 2021/5/28
 * @Created by lktbz
 */
public class ConditionWaitDemo implements Runnable {
    private Lock lock;
    private Condition condition;

    public ConditionWaitDemo(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        System.out.println("   begin await  ");
        lock.lock();
        try {
            condition.await();
            System.out.println("   end await  ");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
