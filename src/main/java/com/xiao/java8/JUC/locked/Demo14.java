package com.xiao.java8.JUC.locked;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName Demo14
 * @Description 读写锁官方demo 01
 * @Author lktbz
 * @Date 2021/1/12
 *
 * 官方demo01 分析：
 * 缓存案例  代码实现步骤
 *  首先创建读写锁
 *  创建缓存对象容器
 *  验证缓存是否存在
 *     加读锁
 *     验证缓存是否存在
 *     存在
 *          直接读取数据，在释放锁
 *     不存在
 *       释放读锁，将锁变为写锁
 *       添加缓存数据到容器中
 *       重点： 读锁可以降级为写锁，而读锁不能升级为写锁
 *         释放写锁
 *
 *
 *
 **/
public class Demo14 {
//    缓存对象
static class CachedData {
//       1 缓存的数据
        Object data;
//      2  可见的缓存验证
        volatile boolean cacheValid;
        final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
//      3  处理缓存数据
        void processCachedData() {
            //4加入读锁
            rwl.readLock().lock();
//             4.1不存在数据 缓存数据
            if (!cacheValid) {
                // Must release read lock before acquiring write lock
                //释放读锁，
                rwl.readLock().unlock();
                //加写锁
                rwl.writeLock().lock();
                try {
                    // Recheck state because another thread might have
                    // acquired write lock and changed state before we did.
                    if (!cacheValid) {
                        data = new Integer(1);
                        cacheValid = true;
                    }
                    // Downgrade by acquiring read lock before releasing write lock
//                    释放写锁之前，需要加读锁
                    rwl.readLock().lock();
                } finally {
                    rwl.writeLock().unlock(); // Unlock write, still hold read
                }
            }
            try {
                // 4。1存在缓存数据，直接打印数据
                System.out.println(data);
            } finally {
                //4.2释放读锁
                rwl.readLock().unlock();
            }
        }
    }

    public static void main(String[] args) {
         new CachedData().processCachedData();
    }
}
