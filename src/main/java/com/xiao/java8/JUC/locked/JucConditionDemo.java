package com.xiao.java8.JUC.locked;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname JucConditionDemo
 * @Description TODO
 * @Date 2021/5/28
 * @Created by lktbz
 */
public class JucConditionDemo {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        ConditionWaitDemo cd= new ConditionWaitDemo(lock, condition);
        ConditionNotifyDemo cdn=  new ConditionNotifyDemo(lock, condition);
        new Thread(cd).start();
        new Thread(cdn).start();
    }
}
