package com.xiao.java8.enumapi;

/**
 * @Classname SeasonClass
 * @Description 将英文季节转换成中文季节
 * @Date 2021/6/4
 * @Created by lktbz
 */
public class SeasonClass {
    public  String changeSeason(Season season){
        StringBuffer buffer=new StringBuffer();
        switch (season){
            case SPRING:
                buffer.append("春天的枚举常量为"+season.name()+"数据表示方式为："+season.getCode());
                break;
            case AUTUMN:
                buffer.append("秋天的枚举常量为"+season.name()+"数据表示方式为："+season.getCode());
                break;
            case SUMMER:
                buffer.append("夏天的枚举常量为"+season.name()+"数据表示方式为："+season.getCode());
                break;
            case WINNER:
                buffer.append("冬天的枚举常量为"+season.name()+"数据表示方式为："+season.getCode());
                break;
            default:
                buffer.append("地球上没有的季节啦啦啦。。。");
                break;
        }
        return buffer.toString();
    }
    public void  doSomething(){
        for (Season s : Season.values()) {
            System.out.println(changeSeason(s));
        }
        //出错 编译时
//        System.out.println(changeSeason(5));
    }

    public static void main(String[] args) {
        SeasonClass season=new SeasonClass();
        season.doSomething();
    }
}
