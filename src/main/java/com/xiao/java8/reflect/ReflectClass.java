package com.xiao.java8.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
@Orange(getName = "3333",getValue = "4444")
public class ReflectClass {

    @Banana(length ="60",price = "88888")
    private String somrthing="测试属性上的注解";

    /**
     * 反射获取 方法上注解的值
     */
    @Apple(color = "红色", number = "5555")
    public void method1(){
        // ...
    }

    /**
     * 方法参数测试
     * @param param1
     * @param param2
     */
    public void method2(@Cherry("1111") String param1, @Cherry("2222") String param2) {
        System.out.println(param1 + param2);
    }

    public static void main(String[] args)throws  Exception {
//        createObject();
//        reflectConstructor();
//        reflectPrivateFields();
//        reflectPrivateMethod();
//        reflectAnnocationClass();
//        reflectAnnocationFiled();
//        reflectAnnocationMethod();
//        reflectAnnocationMethodParams();
    }
    //创建对象
    public static Object createObject() throws Exception{
        Class<?> clazz = Class.forName("com.xiao.java8.reflect.Book");
//       java 9淘汰 Object o = clazz.newInstance();
        Book o = (Book) clazz.getDeclaredConstructor().newInstance();
        o.setAuthor("lktbz");
        o.setName("高级java 必备痛苦经历。。。。");
        System.out.println(o.toString());
        return o;
    }
    //反射拿到构造
    public static void reflectConstructor() throws Exception{
        Class<?> clazz = Class.forName("com.xiao.java8.reflect.Book");
        Constructor<?> constructor = clazz.getDeclaredConstructor(String.class, String.class);
        constructor.setAccessible(true);
        Book bks = (Book) constructor.newInstance("hh", "12");
        System.out.println(bks.toString());
    }
    //反射拿到 私有属性
    public  static void reflectPrivateFields() throws Exception{
        Class<?> clazz = Class.forName("com.xiao.java8.reflect.Book");
        Object o = clazz.getDeclaredConstructor().newInstance();
        Field tag = clazz.getDeclaredField("TAG");
        tag.setAccessible(true);
        String tar = (String) tag.get(o);
        System.out.println(tar);
    }
    //反射拿到方法
    public  static void reflectPrivateMethod() throws Exception{
        Class<?> clazz = Class.forName("com.xiao.java8.reflect.Book");
        Method clazzDeclaredMethod = clazz.getDeclaredMethod("declaredMethod", int.class);
        clazzDeclaredMethod.setAccessible(true);
        Object o = clazz.newInstance();
        String s=(String) clazzDeclaredMethod.invoke(o,0);
        System.out.println(s);
    }
    //反射拿到注解(类上)

    public  static void reflectAnnocationClass() throws Exception{
        Class<ReflectClass> clazz = ReflectClass.class;
        if(clazz.isAnnotationPresent(Orange.class)){
            Orange annotation = clazz.getAnnotation(Orange.class);
            System.out.println ("注解上的name为;"+ annotation.getName()+"--->注解上的valus"+annotation.getValue());
        }
    }
    //反射拿到属性变量上的值
    public  static void reflectAnnocationFiled() throws Exception{
        Class<ReflectClass> clazz = ReflectClass.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field fs:declaredFields) {
            if(fs.isAnnotationPresent(Banana.class)){
                Banana annotation = fs.getAnnotation(Banana.class);
                System.out.println("反射属性上的值一--->"+annotation.length()+"：--->值二为："+annotation.price());
            }
        }
    }
    //反射拿到方法上的值
    public  static void reflectAnnocationMethod() throws Exception{
        ReflectClass re=new ReflectClass();
        Class<? extends ReflectClass> aClass = re.getClass();
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method ms:declaredMethods) {
                if(ms.isAnnotationPresent(Apple.class)){
                    Apple annotation = ms.getAnnotation(Apple.class);
                    System.out.println("方法上的注解值为："+annotation.color()+"另一个注解为："+annotation.number());
                };
        }
    }
    //获取方法参数的值
    public  static void reflectAnnocationMethodParams() throws Exception{
        Class<ReflectClass> clazz = ReflectClass.class;
        Method method2 = clazz.getDeclaredMethod("method2", String.class, String.class);
//        需要进行判断
        Annotation[][] parameterAnnotations = method2.getParameterAnnotations();
        if(parameterAnnotations.length!=0 || parameterAnnotations!=null){
            String [] paramName=new String[parameterAnnotations.length];
            int i=0;
            for (Annotation[] anno1:parameterAnnotations) {
                for (Annotation anno:anno1){
                    if(anno instanceof Cherry){
                        Cherry cherry =(Cherry) anno;
                        paramName[i]=cherry.value();
                    }
                }
            }
            for (String s:paramName) {
                System.out.println("方法参数的值为："+s);
            }
        }

    }

}
