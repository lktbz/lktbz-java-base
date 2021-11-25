package com.xiao.java8.strings;

import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

/**
 * @Description spring 中utils
 * @Author lktbz
 * @Date 2021/06/30
 */
public class SpringStringDemo {
    public static void main(String[] args) {
        People people=new People();
        people.setName("zs");
        String sd="";
        String sdd="lktbv";
        System.out.println("对象是否为空"+ StringUtils.isEmpty(people));
        System.out.println("对象是否为空"+ ObjectUtils.isEmpty(people));
        System.out.println("sd是否为空"+ StringUtils.isEmpty(sd));
        System.out.println("sdd是否为空"+ StringUtils.isEmpty(sdd));
        System.out.println("sd是否为空"+ StringUtils.hasLength(sd));
        System.out.println("sdd是否为空"+ StringUtils.hasLength(sdd));
        System.out.println("sd是否为空"+ StringUtils.hasText(sd));
        System.out.println("sdd是否为空"+ StringUtils.hasText(sdd));
        String []s = new String[10];
        s[0]="hello";
//        String[] zs = StringUtils.addStringToArray(s, "zs");
//        for (String ss:zs) { System.out.println(ss);
//        }
    }
}
