package com.xiao.java8.guava.collection;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import org.junit.Test;

import java.util.*;

public class MapDemo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("aa", 123);
        map.put("bb", 321);
        //foreach
        map.forEach((k, v) -> System.out.println(k + "====" + v));
//        foreach
        for (Map.Entry<String, Integer> s : map.entrySet()) {
            System.out.println(s.getKey() + "====" + s.getValue());
        }
        //迭代器模式
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        iterator.forEachRemaining((o1) -> System.out.println(o1.getKey()));
        iterator.forEachRemaining(o1 -> System.out.println(o1.getValue()));
        //变形
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator1 = entrySet.iterator();
        while (iterator1.hasNext()) {
            Integer value = iterator1.next().getValue();
            String key = iterator1.next().getKey();
            System.out.println("获取到的值为：" + value + "获取到的key为:" + key);
        }
    }

    /**
     * guava 解决集合嵌套问题
     */
    @Test
    public void test01() {
        Multimap<Integer, Integer> map = HashMultimap.create();
        map.put(1, 2);
        map.put(1, 3);
        map.put(1, 4);
        map.put(2, 4);
        map.put(2, 3);
        map.put(2, 1);
        map.put(2, 5);
        System.out.println(map);
        Collection<Integer> integers = map.get(1);
        System.out.println(integers);
    }

    /**
     * {
     * "date":"2018-01-31",
     * "name":"wuzhong",
     * "socre":0.8
     * },
     * {
     * "date":"2018-01-30",
     * "name":"wuzhong",
     * "socre":0.9
     * },
     * {
     * "date":"2018-01-31",
     * "name":"wuzhong2",
     * "socre":0.8
     * }
     * 根据给定的数据，以name 方式进行匹配
     */
    //
    @Test
    public void test02() {
        List<Item> ars = Lists.newArrayList();
        Item item = new Item();
        item.setName("wuzhong");
        item.setScore(0.8);
        item.setDate(new Date());
        Item item1 = new Item();
        item1.setName("wuzhong");
        item1.setScore(0.8);
        item1.setDate(new Date());
        Item item2 = new Item();
        item2.setName("wuzhong2");
        item2.setScore(0.8);
        item2.setDate(new Date());
        ars.add(item);
        ars.add(item1);
        ars.add(item2);
        Multimap<String,Item>multimap= ArrayListMultimap.create();
        for (Item is:ars
             ) {
           multimap.put(is.getName(),is);
        }

        System.out.println(multimap);
    }
}