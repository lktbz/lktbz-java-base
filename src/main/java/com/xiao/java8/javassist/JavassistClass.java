package com.xiao.java8.javassist;

/**
 * 这是需要生成的java 类
 */
public class JavassistClass {
    private String name="default";
    public JavassistClass(){
        name="me";
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void execute(){
        System.out.println(name);
        System.out.println("execute ok");
    }
}
