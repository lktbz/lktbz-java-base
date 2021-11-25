package com.xiao.java8.reflect.formal;

import java.util.List;

/**
 * @Description 类的包获取
 * @Author lktbz
 * @Date 2021/06/25
 */
public class ClassDemo {
    public static void main(String[] args) {
        Supper<String , List<Integer>>supper=new Supper<String, List<Integer>>();
        Class<? extends Supper> aClass = supper.getClass();
        System.out.println("name->" +aClass.getName());
        System.out.println("simpleName->" +aClass.getSimpleName());
        System.out.println("canonicalName->" +aClass.getCanonicalName());

        System.out.println("======================================");
        String[][] strings = new String[1][1];
        System.out.println("name->" + strings.getClass().getName());
        System.out.println("canonicalName->" + strings.getClass().getCanonicalName());
        System.out.println("simpleName->" + strings.getClass().getSimpleName());
        /**
         * getName()：用于获取类在Java虚拟机中的类名表示。
         * getCanonicalName()：用于获取全类名，包括包路径，包路径以点号分隔。
         * getSimpleName()：用于获取类名，不包括包路径
         */
    }

    private  static class Supper<K,V>{
        private K key;
        private V value;

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Supper{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}
