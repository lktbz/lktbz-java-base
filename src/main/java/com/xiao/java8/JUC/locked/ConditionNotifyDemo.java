package com.xiao.java8.JUC.locked;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Classname ConditionNotifyDemo
 * @Description TODO
 * @Date 2021/5/28
 * @Created by lktbz
 */
public class ConditionNotifyDemo implements Runnable {
    private Lock lock;
    private Condition condition;

    public ConditionNotifyDemo(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        System.out.println("   begin  signal ");
        lock.lock();
        try {

            condition.signal();
             System.out.println("  end signal");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
