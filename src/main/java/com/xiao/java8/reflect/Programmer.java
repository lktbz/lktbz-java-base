package com.xiao.java8.reflect;
@ProGender(gender = "女")
public class Programmer {
    private String name;
    private String proLang;
    @ProGender(gender = "女")
    public String pmName;

    public Programmer(){
        System.out.println("public 无参数构造器");
    }

    private Programmer(int num){
        System.out.println("private 一个Int类型参数构造器");
    }
    @ProGender(gender = "太监")
    public Programmer(String proLang){
        this.name="ss007";
        this.proLang=proLang;
        System.out.println("public 一个String类型参数构造器");
    }

    public Programmer(String name,String proLang){
        this.name=name;
        this.proLang=proLang;
        System.out.println("public 两个String类型参数构造器");
    }


    public void work(){
        System.out.println(String.format("%s:在使用 %s 开发语言工作。", name,proLang));
    }

    private void workForModifiedDemand(String pName){
        System.out.println( pName+" fuck you PM: "+pmName);
    }
}

