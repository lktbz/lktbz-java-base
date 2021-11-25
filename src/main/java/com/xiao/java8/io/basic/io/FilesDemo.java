package com.xiao.java8.io.basic.io;

import java.io.File;

/**
 * @Description TODO
 * @Author lktbz
 * @Date 2021/07/08
 */
public class FilesDemo {
    public static void main(String[] args) {
        File file=new File("file.txt");
        String name = file.getName();
        System.out.println(name);
        String property = System.getProperty("user.dir");
        System.out.println(property);
        //修改当前系统工作目录
        System.setProperty("usr.dir","d:\\mydir");
     
    }
}
