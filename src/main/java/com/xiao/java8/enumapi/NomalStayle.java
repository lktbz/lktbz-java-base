package com.xiao.java8.enumapi;

/**
 * @Classname NomalStayle
 * @Description  没有使用枚举之前正常的写法
 * @Date 2021/6/4
 * @Created by lktbz
 */
public class NomalStayle {
    private  static final  int SPRING=1;
    private  static final  int SUMMER=2;
    private  static final  int AUTUMN=3;
    private  static final  int WINTER=4;

    /**
     * 根据传入的季节返回其特定的String 值
     * @param season
     * @return
     */
    public String getChineseSeason(int season){
        StringBuffer buffer=new StringBuffer();
        switch (season){
            case NomalStayle.SPRING:
                buffer.append("春天");
                break;
            case NomalStayle.SUMMER:
                buffer.append("夏天");
                break;
            case NomalStayle.AUTUMN:
                buffer.append("秋天");
                break;
            case NomalStayle.WINTER:
                buffer.append("冬天");
                break;
            default:
                buffer.append("没有这个季节");
                break;
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        //正常场景
        System.out.println(new NomalStayle().getChineseSeason(NomalStayle.SUMMER));
        //这个却是不正常的场景，这
        //就导致了类型不安全问题
        System.out.println(new NomalStayle().getChineseSeason(7));
    }
}
