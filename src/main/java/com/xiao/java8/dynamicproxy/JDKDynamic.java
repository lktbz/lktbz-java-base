package com.xiao.java8.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 媒婆小姐姐有能耐，帮小伙子找对象
 */
public class JDKDynamic  implements InvocationHandler {
    /**
     * jdk 代理就是代理接口。在运行时，动态生成新的Littleboy .class，在jvm 中运行，从而达到动态修改的目的
     */
    private  IGood boy;
   public  Object getObject(IGood good){
       this.boy=good;
       return Proxy.newProxyInstance(getClass().getClassLoader(),good.getClass().getInterfaces(),this);
   }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       before();
        Object o = method.invoke(this.boy, args);
        after();
        return o;
    }
    private void after() {
        System.out.println("媒婆成功的带坏了小妹妹，终于可以了,两个人谈恋爱了。。。。");

    }
    private void before() {
        System.out.println("媒婆jdk疯狂使用各种技能。。。。。。");
    }
}
