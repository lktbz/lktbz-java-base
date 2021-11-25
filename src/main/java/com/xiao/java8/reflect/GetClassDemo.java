//package com.xiao.java8.reflect;
//
//import org.apache.dubbo.common.serialize.kryo.utils.ReflectionUtils;
//import org.springframework.beans.factory.config.BeanDefinition;
//import org.springframework.beans.factory.support.BeanDefinitionRegistry;
//import sun.reflect.Reflection;
//
//import java.lang.reflect.*;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @ClassName GetClassDemo
// * @Description 获取class 方式
// * @Author lktbz
// * @Date 2021/1/19
// */
//public class GetClassDemo {
//    public static void main(String[] args) throws ClassNotFoundException {
//        demo01();
//    }
//
//    public static void demo01() throws ClassNotFoundException {
//        /**
//         * 查看Class 类，
//         * 找出返回值类型为Class 的方法
//         */
//        Class<ConcreteClass> concreteClassClass = ConcreteClass.class;
//        /**
//         * 查看源码说，这个返回的对象，有锁
//         */
//        Class<? extends Class> aClass = ConcreteClass.class.getClass();
//        //没有锁。返回制定个的对象
//        Class<?> aClass1 = Class.forName("com.xiao.refelect.ConcreteClass");
////        类竟然拿到了？哪个推荐使用呢？进去源码看看，doc 上有什么？
////        System.out.println(aClass1.getName());
////        现在以及拿到了类的信息，现在开始对类进行操作
//
//        //获取其父类
//        Class<?> superclass = Class.forName("com.xiao.refelect.ConcreteClass").getSuperclass();
//        System.out.println(superclass.getName());
//
////        Class<? extends Class> aClass2 = aClass1.getClass();
////        System.out.println(aClass2);
//        //把 ConcreteClass class 加载类中全部的类
//        Class<?>[] declaredClasses = aClass1.getDeclaredClasses();
////        System.out.println(declaredClasses);
//
////        获取包名
//        String name = Class.forName("com.xiao.refelect.ConcreteClass").getPackage().getName();
////        System.out.println("name="+name);
////        获取类的修饰符
//        System.out.println( "类的修饰符为"+Modifier.toString(aClass1.getModifiers()));
////        获取class 上的泛型类型
//        TypeVariable<? extends Class<?>>[] typeParameters = Class.forName("java.util.HashMap").getTypeParameters();
//        for(TypeVariable<?> t : typeParameters)
//            System.out.println(t.getName()+",");
//        //获取实现接口
//        Type[] genericInterfaces = Class.forName("com.xiao.refelect.ConcreteClass").getGenericInterfaces();
//        for (Type t:genericInterfaces
//             ) {
//            System.out.println("接口为"+t.getTypeName());
//        }
////       获取方法
//        Method[] methods = aClass1.getMethods();
//        for (Method m:methods) {
//            if("notify".equals(m.getName())){
//                System.out.println("我找你的就是这个方法：--notify");
//            }else{
//                System.out.println("不是方法一览"+m.getName());
//            }
//        }
//        Method[] declaredMethods = aClass1.getDeclaredMethods();
//        for (Method md:declaredMethods
//             ) {
//            md.setAccessible(true);
//            System.out.println(md.getName());
//        }
//
//        Method[] methods1 = aClass1.getMethods();
//        for (Method m1:methods1) {
//            System.out.println(m1.getName()+"方法的返回值为："+m1.getReturnType());
//            System.out.println(m1.getName()+"是否存在泛型返回："+m1.getGenericReturnType());
//            System.out.println(m1.getName()+"方法的可见性为："+Modifier.toString(m1.getModifiers()));
//            System.out.println(m1.getName()+"方法的参数类型为："+m1.getTypeParameters());
//            System.out.println(m1.getName()+"方法的注解返回类型："+m1.getAnnotatedReturnType());
//            System.out.println(m1.getName()+"方法的注解返回类型："+m1.getAnnotatedReturnType());
//            System.out.println(m1.getName()+"桥接："+m1.isBridge());
//
//            //
////            System.out.println(m1.getName()+"桥接："+m1.invoke());
//
//        }
//        //构造函数
//        Constructor<?>[] constructors = aClass1.getConstructors();
//        for (Constructor con:constructors
//             ) {
//
//            System.out.println("构造"+con.toString());
//            System.out.println("参数为"+con.getParameters());
//        }
//        //获取属性 property
//        Field[] declaredFields = aClass1.getDeclaredFields();
//        for (Field f:declaredFields
//             ) {
//            System.out.println("属性名称为"+f.getName());
//        }
//
////        ReflectionUtils
//
//    }
//}
