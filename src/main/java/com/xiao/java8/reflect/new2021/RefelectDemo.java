package com.xiao.java8.reflect.new2021;

import org.junit.Test;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 反射demo
 * @Author lktbz
 * @Date 2021/06/19
 */
public class RefelectDemo {
    @Test
    public void givenObject_whenGetsFieldNamesAtRuntime_thenCorrect() {
        Object person = new Person();
        Field[] declaredFields = person.getClass().getDeclaredFields();
        List<String> filedNames=new ArrayList<>();
        for (Field field : declaredFields
        ) {
            filedNames.add(field.getName());
        }
        System.out.println(filedNames);

    }

    /**
     *   获取 class
     * className 例子
     */
    @Test
    public void givenObject_whenGetsClassName_thenCorrect() {
        Object goat=new Goat("goat");
        Class<?> aClass = goat.getClass();
        System.out.println(aClass.getSimpleName());
        System.out.println(aClass.getName()); //包含路径的name
        System.out.println(aClass.getCanonicalName());

    }

    /**
     * 获取  class
     * @throws ClassNotFoundException
     */
    @Test
    public void givenClassName_whenCreatesObject_thenCorrect() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.xiao.java8.reflect.new2021.Goat");
        System.out.println(aClass.getName());
        System.out.println(aClass.getSimpleName());
        System.out.println(aClass.getCanonicalName());
    }

    /**
     * 类的修饰符获取 ,获取类的修饰属性
     * Modifier
     */
    @Test
    public void givenClass_whenRecognisesModifiers_thenCorrect() throws ClassNotFoundException {
        Class<?> ac = Class.forName("com.xiao.java8.reflect.new2021.Goat");
        Class<?> an = Class.forName("com.xiao.java8.reflect.new2021.Animal");
       int goatMods =    ac.getModifiers();
        int animalMods =   an.getModifiers();
        System.out.println(Modifier.isPublic(goatMods));
        System.out.println(Modifier.isPublic(animalMods));
        System.out.println(Modifier.isAbstract(animalMods));
        System.out.println(Modifier.isInterface(animalMods));
    }

    /**
     * 获取类的包名
     */
    @Test
    public void givenClass_whenGetsPackageInfo_thenCorrect() {
        Goat goat = new Goat("goat");
        Class<? extends Goat> aClass = goat.getClass();
        Package aPackage = aClass.getPackage();
        System.out.println(aPackage.getName());
    }

    /**
     * 获取父类
     */
    @Test
    public void givenClass_whenGetsSuperClass_thenCorrect() {
        Goat goat = new Goat("goat");
        String str = "any string";
        Class<?> goatClass = goat.getClass();
        Class<?> superclass = goatClass.getSuperclass();
        System.out.println(superclass.getSimpleName());
        System.out.println(superclass.getSuperclass().getSimpleName());
    }

    /**
     * 获取实现接口
     */
    @Test
    public void givenClass_whenGetsImplementedInterfaces_thenCorrect() throws ClassNotFoundException {
        Class<?> ac = Class.forName("com.xiao.java8.reflect.new2021.Goat");
        Class<?> an = Class.forName("com.xiao.java8.reflect.new2021.Animal");
        Class<?>[] interfaces = ac.getInterfaces();
        Class<?>[] interfaces1 = an.getInterfaces();
        System.out.println(interfaces.length);
        System.out.println(interfaces1.length);
        System.out.println(interfaces[0].getSimpleName());
        System.out.println(interfaces1[0].getSimpleName());
    }

    /**
     * 构造器
     */
    @Test
    public void givenClass_whenGetsConstructor_thenCorrect() throws ClassNotFoundException {
        Class<?> ac = Class.forName("com.xiao.java8.reflect.new2021.Goat");
        Constructor<?>[] constructors = ac.getConstructors();
        System.out.println(constructors.length);
        for (Constructor cons:constructors
             ) {
            System.out.println(cons.getName());
            System.out.println(cons.getParameterCount());
            System.out.println(cons.getAnnotatedReturnType());
        }
    }

    /**
     * 字段属性
     */
    @Test
    public void givenClass_whenGetsFields_thenCorrect() throws ClassNotFoundException {
        Class<?> an = Class.forName("com.xiao.java8.reflect.new2021.Animal");
        for (Field field : an.getDeclaredFields()) {
            System.out.println(field.getName());
            System.out.println(field.getType());
        }
    }

    /**
     * method
     */
    @Test
    public void givenClass_whenGetsMethods_thenCorrect() throws ClassNotFoundException {
        Class<?> an = Class.forName("com.xiao.java8.reflect.new2021.Animal");
        for (Method method : an.getDeclaredMethods()) {

            System.out.println(method.getName());
            System.out.println(method.getReturnType());
            System.out.println(method.getParameterTypes());
            System.out.println(method.getParameters());
        }
    }

    /**
     * 构造函数
     */
    @Test
    public void givenClass_whenInstantiatesObjectsAtRuntime_thenCorrect() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> bird = Class.forName("com.xiao.java8.reflect.new2021.Bird");
        //拿到构造器
        Constructor<?> constructor = bird.getConstructor();
        Constructor<?> constructor2 = bird.getConstructor(String.class);
        Constructor<?> constructor3 = bird.getConstructor(String.class,boolean.class);
        Bird bird1  = (Bird) constructor.newInstance();
        Bird bird2 = (Bird) constructor2.newInstance("Weaver bird");
        Bird bird3 = (Bird) constructor3.newInstance("dove", true);
        System.out.println(bird1.toString());
        System.out.println(bird2.toString());
        System.out.println(bird3.toString());

    }
    @Test
    public void testMethodInvke() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> goab = Class.forName("com.xiao.java8.reflect.new2021.Goat");
        Method eats = goab.getDeclaredMethod("eats");
        Goat la = new Goat("la");
        String invoke =(String) eats.invoke(la);
        System.out.println(invoke);
    }


}
