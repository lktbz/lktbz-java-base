package com.xiao.java8.enumapi;

/**
 * @Classname EnumUseDemo
 * @Description 枚举使用方式总结
 * @Date 2021/6/4
 * @Created by lktbz
 */
public class EnumUseDemo {

    /**
     * 常量
     */
    public enum Color {
        RED, GREEN, BLANK, YELLOW
    }
    /**
     * switch
     */
    enum Signal {
        GREEN, YELLOW, RED
    }
    public class TrafficLight {
        Signal color = Signal.RED;
        public void change() {
            switch (color) {
                case RED:
                    color = Signal.GREEN;
                    break;
                case YELLOW:
                    color = Signal.RED;
                    break;
                case GREEN:
                    color = Signal.YELLOW;
                    break;
            }
        }
    }

    /**
     *     添加新方法
     */

    public  enum ColorEnum{
        RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);
        private String name;
        private int index;

        ColorEnum(String name, int index) {
            this.name = name;
            this.index = index;
        }

//       根据传入的index,获取对应的name
        public String byIndex(int index){
            for (ColorEnum co : values()) {
                if(co.getIndex()==index){
                    return co.name;
                }
            }
            return null;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }
    /**
     *  覆盖枚举的方法
     */
    public enum OverRideColor{
        RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);
        // 成员变量
        private String name;
        private int index;
        // 构造方法
        private OverRideColor(String name, int index) {
            this.name = name;
            this.index = index;
        }

        @Override
        public String toString() {
            return this.index+"_"+this.name;
        }

    }
    /**
     * 实现接口
     */
    public interface Behaviour {
        void print();
        String getInfo();
    }
    public  enum  ColorInterface implements Behaviour{
        RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);
        // 成员变量
        private String name;
        private int index;
        // 构造方法
        private ColorInterface(String name, int index) {
            this.name = name;
            this.index = index;
        }

        @Override
        public void print() {
            System.out.println(this.index+":"+this.name);
        }

        @Override
        public String getInfo() {
            return this.name;
        }
    }
    /**
     * 接口内实现枚举
     */
    public interface Food {
        enum Coffee implements Food{
            BLACK_COFFEE,DECAF_COFFEE,LATTE,CAPPUCCINO
        }
        enum Dessert implements Food{
            FRUIT, CAKE, GELATO
        }
    }
    public static void main(String[] args) {
        //测试实现接口的调用
        ColorInterface.RED.print();
        System.out.println(ColorInterface.RED.getInfo());
    }
}
