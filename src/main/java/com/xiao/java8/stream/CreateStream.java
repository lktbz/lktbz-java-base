package com.xiao.java8.stream;

import java.util.*;
import java.util.stream.Stream;

/**
 * @ClassName CreateStream
 * @Description 创建流的方式
 * @Author lktbz
 * @Date 2021/1/18
 */
public class CreateStream {
    public static void main(String[] args) {


//        第一种
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 4);
        integerStream.forEach(System.out::println);
//        第二种方式
        Stream<Integer> integerStream1 = Stream.of(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        integerStream1.forEach(System.out::println);

//        第三种方式
        List<Integer>list=new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            list.add(i);
        }

        list.stream().forEach(System.out::println);

        Arrays.asList("a","b","c","d").stream();
         Map<String ,Object> mps=new HashMap<>();
         mps.put("zs","xiao");
         mps.put("shd","sds");
        Stream<Map<String, Object>> mps1 = Stream.of(mps);

    }
}
