package com.xiao.java8.lambda;


/**
 * 什么是lambda ，lambda 特征是什么？
 *Lambda表达式可以直接以内联的形式为函数式接口的抽象方法提供实现，并把整个表达式作为函数式接口的实例。
 * 什么是函数式接口？
 * 简单来说就是只包含一个抽象方法的接口，允许有默认的实现（使用default关键字描述方法）
 * 函数式接口建议使用@FunctionalInterface注解标注，虽然这不是必须的，但是这样做更符合规范
 */
public class Lambda01 {
    public static void main(String[] args) {
        /**
         * java8之前写线程
         */
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("java 8之前 线程写法");
//            }
//        }).start();
        /**
         * java 8 lambda 表达式写法
         * 无参数的lambda 写法
         */
//        new Thread(()-> System.out.println("这是java8 in lambda")).start();
        /**
         *  lambda 表达式基本语法
         *  p 代表参数
         *  ex 代表将要执行
         *  （p）-> ex
         *    or
         *    (p)->{
         *        sta
         *    }
         */

        /**
         * 官方 demo
         */
       /** (String s)->s.length();
        (String s)->{return  s.length();}
        ()-> System.out.println("hello");
        ()->{}
        ()->17
        (int x,int y)->{
            System.out.println(x);
            System.out.println(y);
        }**/

        /**
         * lambda 使用场景
         *
         * 1：实现的对象是函数式接口的抽象方法；
         *
         * 2：函数式接口的抽象方法的函数描述符和Lambda表达式的函数描述符一致。
            以上两个才可以使用lambda表达式
         */
         //1 函数式接口
        /**
         * @FunctionalInterface
         * public interface Runnable {
         *     public abstract void run();
         * }
         * 这个接口只有一个抽象方法，并且使用@FunctionalInterface注解标注。
         *
         * 接口现在还可以拥有默认方法（即在类没有对方法进行实现时，其主体为方法提供默认实现的方法）。
         * 哪怕有很多默认方法，只要接口只定义了一个抽象方法，它就仍然是一个函数式接口
         */
        //2函数描述符
        /**
         * 函数描述符其实也可以理解为方法的签名。比如上述的Runnable抽象方法不接受参数，
         * 并且返回void，所以其函数描述符为() -> void。而() ->
         *
         * System.out.println("hello")Lambda表达式也是不接受参数，并且返回void，即其函数描述符也是() -> void。
         * 所以代码Runnable r = () -> System.out.println("hello");是合法的。
         */

//        //编写一个类型转换的函数式接口TransForm<T,R>
//        TransForm<String ,Integer>t =(String s)->Integer.valueOf(s);
//        System.out.println("转换后的参数为："+t.transFrom("1234"));
//        //进一步简化
//        TransForm<String ,Integer>t1=(s)->Integer.valueOf(s);
//        System.out.println("转换后的参数为："+t1.transFrom("1234"));
//
//        //最终简化
//        TransForm<String ,Integer>T2=Integer::valueOf;
//        System.out.println(T2.transFrom("1221"));
        //上面这句是方法引用，参考c++
        /**
         * 参照下面例子
                Lambda表达式                           等效方法引用
        (String s) -> System.out.println(s)	           System.out::println
        (str, i) -> str.substring(i)          	       String::substring
        () -> Thread.currentThread().dumpStack()	   Thread.currentThread()::dumpStack
         */

        /**
        符号::除了出现在方法的引用外，
        它还常见于构造函数的引用中。为了演示什么是构造函数的引用，我们创建一个新的函数式接口：
         **/
        //lambda02 使用apple 改了构造函数，所以注释掉
//        Generator<String ,Apple> ah=Apple::new;
//        ah.create("black");
//        System.out.println(ah.toString());
//        /**
//         * 等价于
//         */
//        Generator<String,Apple>ab=(a)->new Apple(a);
//        ab.create("yello");
        /**
         * lambda 访问变量
         * Lambda表达式可以访问局部final变量，成员变量和静态变量。
         */
//        String hello="lamba hello";
//        Runnable runnable = () -> System.out.println(hello);
//        /**
//         * 点进去发现是函数式接口
//         */
//        runnable.run();
    }
}
