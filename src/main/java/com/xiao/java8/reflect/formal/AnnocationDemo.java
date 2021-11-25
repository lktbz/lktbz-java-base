package com.xiao.java8.reflect.formal;

import java.lang.annotation.*;

/**
 * @Description AnnotatedElement 接口学习
 * @Author lktbz
 * @Date 2021/06/25
 */
public class AnnocationDemo {
    /**
     * 父类注解
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Inherited
    @Documented
    @Target(ElementType.TYPE)
    private @interface SupperAnnotation {

        String value() default "SupperAnnotation";
    }

    /**
     * 子类注解
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @Target(ElementType.TYPE)
    private @interface SubAnnotation {

        String value() default "SubAnnotation";
    }
    @SupperAnnotation
    private static class Supper{

    }
    @SubAnnotation
    private  static class Sub extends Supper{

    }
    public static void main(String[] args) {
      Class<?>clazz=  Sub.class;
        System.out.println("-----getAnnotations-----");
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation:annotations) {
            System.out.println(annotation.toString());
        }

        System.out.println("-----getDeclaredAnnotation-->SupperAnnotation-----");
        SupperAnnotation declaredSupperAnnotation = clazz.getDeclaredAnnotation(SupperAnnotation.class);
        System.out.println(declaredSupperAnnotation);
        System.out.println("-----getAnnotation-->SupperAnnotation-----");
        SupperAnnotation supperAnnotation = clazz.getAnnotation(SupperAnnotation.class);
        System.out.println(supperAnnotation);
        System.out.println("-----getDeclaredAnnotation-->SubAnnotation-----");
        SubAnnotation declaredSubAnnotation = clazz.getDeclaredAnnotation(SubAnnotation.class);
        System.out.println(declaredSubAnnotation);

        System.out.println("-----getDeclaredAnnotationsByType-->SubAnnotation-----");
        SubAnnotation[] declaredSubAnnotationsByType = clazz.getDeclaredAnnotationsByType(SubAnnotation.class);
        for (SubAnnotation subAnnotation : declaredSubAnnotationsByType) {
            System.out.println(subAnnotation);
        }
        System.out.println("-----getDeclaredAnnotationsByType-->SupperAnnotation-----");
        SupperAnnotation[] declaredSupperAnnotationsByType = clazz.getDeclaredAnnotationsByType(SupperAnnotation.class);
        for (SupperAnnotation supperAnnotation1 : declaredSupperAnnotationsByType) {
            System.out.println(supperAnnotation1);
        }
        System.out.println("-----getAnnotationsByType-->SupperAnnotation-----");
        SupperAnnotation[] supperAnnotationsByType = clazz.getAnnotationsByType(SupperAnnotation.class);
        for (SupperAnnotation supperAnnotation2 : supperAnnotationsByType) {
            System.out.println(supperAnnotation2);
        }

    }
}
