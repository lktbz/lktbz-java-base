package com.xiao.java8.enumapi;

/**
 * switch
 */
public class StateMachineDemo {
   public  enum  Signal{
       RED,GREEN,YELLLO
   }

   public static String getTrraficInstance(Signal signal){
      String  instruct="信号灯故障";
       switch (signal){
           case RED:
                instruct="红灯停";
                break;
           case GREEN:
               instruct="绿灯行";
                break;
           case YELLLO:
                instruct="请注意" ;
                break;
           default:
                break;
       }
       return instruct;
   }

    public static void main(String[] args) {
        System.out.println(getTrraficInstance(Signal.RED));
    }
}
