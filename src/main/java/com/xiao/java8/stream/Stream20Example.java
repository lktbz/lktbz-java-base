package com.xiao.java8.stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName Stream20Example
 * @Description Stream 20 个例子
 * @Author lktbz
 * @Date 2021/3/24
 */
public class Stream20Example {
   public static List<Person> personList = new ArrayList<Person>();
static {

    personList.add(new Person("Tom", 8900, "male", "New York"));
    personList.add(new Person("Jack", 7000, "male", "Washington"));
    personList.add(new Person("Lily", 7800, "female", "Washington"));
    personList.add(new Person("Anni", 8200, "female", "New York"));
    personList.add(new Person("Owen", 9500, "male", "New York"));
    personList.add(new Person("Alisa", 7900, "female", "New York"));
}

    /**
     * 循环与过滤操作
      */
    @Test
    public void test01(){
        List<Integer> list = Arrays.asList(7, 6, 9, 3, 8, 2, 1);
        // 筛选出大于6的元素
       // list.stream().filter(s->s>6).forEach(System.out::println);
//        查找出大于6的第一个元素
//        Optional<Integer> first = list.stream().filter(s -> s > 6).findFirst();
//        System.out.println(first.get());
        //随意匹配
        Optional<Integer> any = list.parallelStream().filter(s -> s > 6).findAny();
        System.out.println(any.get());
//        筛选员工中工资高于8000的人，并形成新的集合
        List<String> collect = personList.stream().filter(s -> s.getSalary() > 8000)
                .map(s -> s.getName())
                .collect(Collectors.toList());
        System.out.println(collect);


    }

    /**
     * 聚合操作
     */
    @Test
    public void test02(){
//        获取String集合中最长的元素。
        List<String> list = Arrays.asList("adnm", "admmt", "pot", "xbangd", "weoujgsd");
        Optional<String> max = list.stream().max(Comparator.comparing(String::length));
        System.out.println(max.get());

        List<Integer> list2 = Arrays.asList(7, 6, 9, 4, 11, 6);
//        自然排序
        Optional<Integer> max1 = list2.stream().max(Integer::compareTo);
        System.out.println(max1);
//        自定义排序
        Optional<Integer> max2 =  list2.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("普通排序"+max1);
        System.out.println("自定义排序"+max2);
//        获取员工工资最高的人。
        Optional<String> s = personList.stream()
                .max(Comparator.comparingInt(Person::getSalary))
                .map(Person::getName);
        System.out.println("员工工资最大的为"+s);

//        计算Integer集合中大于6的元素的个数。
        long count = list2.stream().filter(x -> x > 6).count();
        System.out.println("list中大于6的元素个数：" + count);
    }

    /**
     * 映射 将清洗出的数据，组成新的流
     */
    @Test
    public void test03(){
//        英文字符串数组的元素全部改为大写。整数数组每个元素+3。
        String[] strArr = { "abcd", "bcdd", "defde", "fTr" };
        List<String> collect = Arrays.stream(strArr).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect);
        List<Integer> intList = Arrays.asList(1, 3, 5, 7, 9, 11);
        List<Integer> collect1 = intList.stream().map(s -> s + 3).collect(Collectors.toList());
        System.out.println(collect1);

//        将员工的薪资全部增加1000。
        List<Person> collect2 = personList.stream()
                .map(p -> {
                    p.setSalary(p.getSalary() + 10000);
                         return p;
                })
                .collect(Collectors.toList());
//        方式二：
        System.out.println("一次改动前：" + personList.get(0).getName() + "-->" + personList.get(0).getSalary());
        System.out.println("一次改动后：" + collect2.get(0).getName() + "-->" + collect2.get(0).getSalary());

        List<Person> collect3 = personList.stream().map(person -> {
            Person newp = new Person(person.getName(), 0, "0", null, null);
            newp.setSalary(person.getSalary() + 1000);
            return newp;
        }).collect(Collectors.toList());
        System.out.println("二次改动前：" + personList.get(0).getName() + "-->" + collect2.get(0).getSalary());
        System.out.println("二次改动后：" + collect3.get(0).getName() + "-->" + collect3.get(0).getSalary());
    }

}
