package com.xiao.java8.enumapi;

public class EnumMethodDemo {
    enum  Color {RED,GREEN,BLUE;}
    enum  Size {BID,MIDDLE,SMALL}

    public static void main(String[] args) {
        System.out.println("遍历所有的枚举");
        for ( Color c:Color.values()) {
            System.out.println(c.toString()+"-->ordinal:---> 在枚举中的位置"+c.ordinal());
        }
        System.out.println("all size");
        for ( Size c:Size.values()) {
            System.out.println(c.toString()+"-->ordinal:---> 在枚举中的位置"+c.ordinal());
        }
        Color s=Color.GREEN;
        System.out.println("color is "+s);
        System.out.println("color is "+s.name());
        System.out.println("green getDeclaringClass(): "+s.getDeclaringClass());
        System.out.println("color  hashCode "+s.hashCode());

    }
}
