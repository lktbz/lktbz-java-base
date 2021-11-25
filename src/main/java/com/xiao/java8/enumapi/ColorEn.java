package com.xiao.java8.enumapi;

/**
 * 创建枚举类，变异成.class 文件后，在使用javap 命令查看其本质
 */
public enum ColorEn {
    RED,YELLO,GREEN;
}
/**
 * 执行完命令
 public final class com.xiao.java8.enumapi.ColorEn extends java.lang.Enum<com.xiao.java8.enumapi.ColorEn> {
 public static final com.xiao.java8.enumapi.ColorEn RED;
 public static final com.xiao.java8.enumapi.ColorEn YELLO;
 public static final com.xiao.java8.enumapi.ColorEn GREEN;
 public static com.xiao.java8.enumapi.ColorEn[] values();
 public static com.xiao.java8.enumapi.ColorEn valueOf(java.lang.String);
 static {};
 }
**/
