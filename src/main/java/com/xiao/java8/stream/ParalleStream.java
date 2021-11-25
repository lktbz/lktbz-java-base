package com.xiao.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @ClassName ParalleStream
 * @Description 并发的处理
 * @Author lktbz
 * @Date 2021/1/18
 */
public class ParalleStream {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i< 10; i++){
            list.add(i);
        }
        Stream<Integer> integerStream = list.parallelStream();
        Integer[] integers = integerStream.filter(i -> i % 2 == 0).toArray(Integer[]::new);
        System.out.println(integers);
    }
}
