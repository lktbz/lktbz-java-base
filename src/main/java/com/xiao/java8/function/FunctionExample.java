package com.xiao.java8.function;

import java.util.function.Function;
/**
 * @ClassName FunctionExample
 * @Description 函数接口值Function
 * @Author lktbz
 * @Date 2021/1/18
 */
public class FunctionExample {
    /** @FunctionalInterface
    public interface Function<T, R> {
     * Applies this function to the given argument.
     *
     * @return the function result
    R apply(T t);
      将T类型转换成R类型
     */
    public static void main(String[] args) {
       // demo01();
        //demo02();
//        demo03();
//        demo04();
//         demo05();
         demo06();
    }
    //多级链式调用
    public static void demo06(){
        Function<String,String> toLowerCasefunc = (x)->x.toLowerCase();  // function one
        Function<String,String> removeHyphenFunc = (x)->x.replace("-", ""); // function two
        Function<String,String> reverseStringFunc = (x)->{                  // function three
            StringBuilder sb = new StringBuilder(x);
            return sb.reverse().toString();
        };
        String output = toLowerCasefunc.andThen(removeHyphenFunc)
                .andThen(reverseStringFunc)
                .apply("Mother---Nature");
        System.out.println("Output: "+output);

    }
    //链式调用
    public static void demo05(){
        Function<String,String> toLowerCasefunc = (x)->x.toLowerCase();  // function one
        Function<String,String> removeHyphenFunc = (x)->x.replace("-", ""); // fu
        String apply = toLowerCasefunc.andThen(removeHyphenFunc)
                .apply("Mother---Nature");
        System.out.println(apply);

    }
    //函数的长度
    public static void demo04(){
        Function<String ,Integer>func=(x)->x.length();
        Integer apply = func.apply(" Mother Nature");
        System.out.println(apply);
    }
    //链式调用
    public static void demo03(){
        Function<Integer,Integer>name=e->e*2;
        Function<Integer,Integer>squre=e->e*e;
        //先执行3*2 在执行6*6
        Integer apply = name.andThen(squre).apply(3);
        System.out.println("andThen value is"+apply);
        //先执行3*3 在执行9*2
        Integer apply1 = name.compose(squre).apply(3);
        System.out.println("compose value is"+apply1 );
    }
    /**
     * 将dto 数据类型转换成PO类型
     */
    public static void demo02(){
        MsssageDTO dto=new MsssageDTO();
        dto.setMessageName("zs");
        dto.setMessageId("2");
        dto.setFalse(true);
       Function<MsssageDTO,MsaagePO>message=(msssageDTO ->{
           MsaagePO msaagePO = new MsaagePO();
           msaagePO.setMessageId(Integer.valueOf(msssageDTO.getMessageId()));
           msaagePO.setName(msssageDTO.getMessageName());
           msaagePO.setPassword("zssdsd");
            return msaagePO;
       });
        MsaagePO apply = message.apply(dto);
        System.out.println(apply.toString());
    }
    public static void demo01(){
        int value=10;
        //定义需要转换类型
       Function<Integer,String> person=(values)->{return  String.valueOf(values);};
       //调用转换函数
        String apply = person.apply(value);
//        打印
        System.out.println("转换后的值为"+apply);
    }
}
