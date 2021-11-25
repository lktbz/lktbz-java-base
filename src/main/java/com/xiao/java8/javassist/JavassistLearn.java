package com.xiao.java8.javassist;

import javassist.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JavassistLearn {
    public static void main(String[] args) throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, IOException {
        //创建类池
        ClassPool aDefault = ClassPool.getDefault();
        //创建类
        CtClass ctClass = aDefault.makeClass("com.xiao.java8.lktbz2");
        StringBuffer sb=null;
        //参数1属性类型，2属性名称 3所属类
        CtField ctField=new CtField(aDefault.get("java.lang.String"),"name",ctClass);
        //设置修饰
        ctField.setModifiers(Modifier.PRIVATE);
        //设置getset
        ctClass.addMethod(CtNewMethod.setter("setName",ctField));
        ctClass.addMethod(CtNewMethod.getter("getName",ctField));
        //设置name 的默认值
        ctClass.addField(ctField, CtField.Initializer.constant("default"));

        //构造函数
        CtConstructor constructor =new CtConstructor(new CtClass[]{},ctClass);
        sb=new StringBuffer();
        sb.append("{\n name=\"me\";\n}");
        constructor.setBody(sb.toString());
        ctClass.addConstructor(constructor);

        //创建方法
        CtMethod ctMethod=new CtMethod(CtClass.voidType,"execute",new CtClass[]{},ctClass);
        ctMethod.setModifiers(Modifier.PUBLIC);
        sb=new StringBuffer();
        sb.append("{\n System.out.println(name); ");
        sb.append("\n System.out.println(\"execute ok\");");
        sb.append("\n return ;");
        sb.append("\n}");
        ctMethod.setBody(sb.toString());
        ctClass.addMethod(ctMethod);
        Class<?> aClass = ctClass.toClass();
        Object o = aClass.newInstance();
        Method execute = o.getClass().getMethod("execute", new Class[]{});
        //调用字节码生成类的execute方法
        execute.invoke(o,new Object[]{});
    }
}
