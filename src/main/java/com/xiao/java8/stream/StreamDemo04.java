package com.xiao.java8.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Classname StreamDemo04
 * @Description stream  Collections 流的高级用法
 * @Date 2021/6/14
 * @Created by lktbz
 */
public class StreamDemo04 {
 public  static  List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
   @Test
   public void test01(){
//       集合操作中新增java8stream 方法
     Collections.sort(numbers);
       for (Integer number : numbers) {
           System.out.print(number);
       }


   }
}
