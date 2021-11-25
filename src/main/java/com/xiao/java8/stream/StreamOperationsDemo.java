package com.xiao.java8.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName StreamOperationsDemo
 * @Description stream 操作
 * @Author lktbz
 * @Date 2021/1/18
 */
public class StreamOperationsDemo {
    public static void main(String[] args) {
        List<String> memberNames = new ArrayList<>();
            memberNames.add("Amitabh");
            memberNames.add("Shekhar");
            memberNames.add("Aman");
            memberNames.add("Rahul");
            memberNames.add("Shahrukh");
            memberNames.add("Salman");
            memberNames.add("Yana");
            memberNames.add("Lokesh");
//            memberNames.stream().filter((s)->s.startsWith("A")).forEach(System.out::println);

        boolean a = memberNames.stream().allMatch((s -> s.startsWith("A")));
        System.out.println(a);
        boolean b = memberNames.stream().anyMatch((s -> s.startsWith("A")));
        System.out.println(b);

        boolean c = memberNames.stream().noneMatch((s -> s.startsWith("A")));
        boolean cs = memberNames.stream().noneMatch((s -> s.startsWith("1")));
        System.out.println(c);
        System.out.println(cs);


    }
}
