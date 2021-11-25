package com.xiao.java8.reflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD,ElementType.TYPE})
public @interface Alias {

    //注解成员，default表示默认值
    public String value() default "";

    //注解成员，是否参与代码生成
    public boolean isGenerator() default true;

}

