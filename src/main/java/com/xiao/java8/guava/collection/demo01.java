package com.xiao.java8.guava.collection;

import com.google.common.collect.*;

import java.util.*;

/**
 * guava 创建优雅的创建集合方式
 */
public class demo01 {
    public static void main(String[] args) {
        /**
         * 创建
         */
        ArrayList<String> strings = Lists.newArrayList("z", "x", "c");
        //反转
        List<String> reverse = Lists.reverse(strings);
        System.out.println(reverse);
//        通过字符串生成
        List<Character> al= Lists.charactersOf("lktbz");
        System.out.println(al);
        /**
         * 将集合按照指定大小分块
         */
        ArrayList<String> strings1 = Lists.newArrayList("java", "php", "go", "python", "c#", "javascript");
        List<List<String>> lists = Lists.partition(strings1, 2);
        System.out.println(lists);

        /**
         * 删除list中重复项的技巧
         */
        ArrayList<String> strings2 = Lists.newArrayList("a", "p", "p", "l", "e");
        ImmutableList<String> list3 = ImmutableSet.copyOf(strings2).asList();
        System.out.println(list3);

        /**
         * 删除集合中null值
         *
         */
        ArrayList<String> strings3 = Lists.newArrayList("java", null, "python");
//        Iterables.removeIf(strings3, Objects::isNull);
        System.out.println(strings3);


        System.out.println("===================set============================");
        /**
         * set 创建和并
         */
        HashSet<Object> objects = Sets.newHashSet();
        ImmutableSet<String> of = ImmutableSet.of("s", "z", "c");
        ImmutableSet<String> of1 = ImmutableSet.of("s", "c", "e");
        Sets.SetView<String> union = Sets.union(of, of1);
        System.out.println(union);
        /**
         * 笛卡尔积
         */
        Set<Character> first = ImmutableSet.of('a', 'b');
        Set<Character> second = ImmutableSet.of('c', 'd');
        Set<List<Character>> result = Sets.cartesianProduct(first, second);

        System.out.println(result); // [[a, c], [a, d], [b, c], [b, d]]

        /**
         * 获取两个Set的交集
         */
        Set<Character> first2 = ImmutableSet.of('a', 'b', 'c');
        Set<Character> second2 = ImmutableSet.of('c', 'd', 'e');
        Set<Character> intersection = Sets.intersection(first2, second2);

        System.out.println(intersection); // [c]

//        获取两个Set的差集：
        Set<Character> first3 = ImmutableSet.of('a', 'b', 'c');
        Set<Character> second3 = ImmutableSet.of('c', 'd', 'e');
        Set<Character> difference = Sets.symmetricDifference(first3, second3);
        System.out.println(difference); // [a, b, d, e]
        HashMultiset<Object> objects1 = HashMultiset.create();

    }

}
