package com.xiao.java8.JUC.locked;

/**
 * @ClassName Demo08
 * @Description 死锁Demo
 * @Author lktbz
 * @Date 2021/1/10
 */
public class Demo08 {
    static class Friend {
        private final String name;
        public Friend(String name) {
            this.name = name;
        }
        public String getName() {
            return this.name;
        }

        /**
         *  加锁的方法bow--->调用加锁的方法 bowBack
         * @param bower
         */
        public synchronized void bow(Friend bower) {
            System.out.format("%s: %s"
                            + "  has bowed to me!%n",
                    this.name, bower.getName());
            bower.bowBack(this);
        }
        public synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s"
                            + " has bowed back to me!%n",
                    this.name, bower.getName());
        }
    }
    /**
     * 从代码中可以发现，两处互相引用
     * @param args
     */
    public static void main(String[] args) {
        final Friend alphonse =
                new Friend("Alphonse");
        final Friend gaston =
                new Friend("Gaston");
        new Thread(new Runnable() {
            public void run() { alphonse.bow(gaston); }
        }).start();
        new Thread(new Runnable() {
            public void run() { gaston.bow(alphonse); }
        }).start();
    }
}
