package com.xiao.java8.function;

/**
 * java为我们内置的函数式接口
 */

import com.xiao.java8.lambda.Apple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 函数式接口	         函数描述符	                   原始类型特化
 * Predicate	         T->boolean	                    IntPredicate,LongPredicate, DoublePredicate
 * Consumer 	          T->void	                    IntConsumer,LongConsumer, DoubleConsumer
 * Function<T,R>	     T->R	I                       ntFunction, IntToDoubleFunction, IntToLongFunction,
 *                                                      LongFunction, LongToDoubleFunction,  LongToIntFunction,
 *                                                      DoubleFunction, ToIntFunction, ToDoubleFunction, ToLongFunction
 * Supplier	              ()->T	                         BooleanSupplier,IntSupplier, LongSupplier,
 *                                                        DoubleSupplier
 * UnaryOperator	    T->T	                        IntUnaryOperator, LongUnaryOperator, DoubleUnaryOperator
 * BinaryOperator	    (T,T)->T	                     IntBinaryOperator, LongBinaryOperator, DoubleBinaryOperator
 * BiPredicate<L,R>	    (L,R)->boolean
 * BiConsumer<T,U>	    (T,U)->void                     ObjIntConsumer, ObjLongConsumer, ObjDoubleConsumer
 * BiFunction<T,U,R>	(T,U)->R	                       ToIntBiFunction<T,U>, ToLongBiFunction<T,U>, ToDoubleBiFunction<T,U>
 */
class FunctionAllDemo {
    public static void main(String[] args) {
        /**
         * Predicate
         * java.util.function.Predicate<T>接口定义了一个名叫test的抽象方法，
         * 它接受泛型T对象，并返回一个boolean，函数描述符为(T) -> boolean举几个例
         */
        //偶数判断
        Predicate<Integer> is=(in)->in%2==0;
        boolean test = is.test(16);
        System.out.println(test);
        // 判断字符串的长度是否为0
        Predicate<String>isempty=String::isEmpty;
        boolean test1 = isempty.test("");
        System.out.println(test1);
        /**
         * java.util.function.Predicate<T>接口还定义了三个默认方法：
         * and，negate和or，对应“与”，“非”和“或”操作，这样我们便可以复合Lambda表达式了
         */
        // 判断是偶数，并且大于30
        Predicate<Integer> isEven3 = (in) -> in % 2 == 0;
        isEven3.and((in) -> in > 30).test(40); // true

//      //奇数判断
        Predicate<Integer> isEven2 = (in) -> in % 2 == 0;
        Predicate<Integer> isOdd = isEven2.negate();
        isOdd.test(17); // true

        /**
         * Consumer
         * 定义了一个名叫accept的抽象方法，它接受泛型T的对象，
         * 没有返回(void)，函数描述符为(T) -> void。其还提供了一个默认方法andThen。举个例子：
         */
        Consumer<Apple> printAppleColor = (a)-> System.out.println(a.getColor());
        printAppleColor.accept(new Apple("red",17)); // red
        printAppleColor.andThen((a) -> System.out.println(a.getWeight())).accept(new Apple("red", 17)); // red 17.0
        /**
         * Supplier
         * 定义了一个名叫get的抽象方法，它不接收参数，返回泛型T的对象，函数描述符为() -> T。举个例子：
         */
        Supplier<Person> personSupplier = Person::new;
        personSupplier.get();   // new Person

      //  Functions


       /**
        java.util.function.Function<T, R>接口定义了一个叫作apply的方法，
        它接受一个泛型T的对象，并返回一个泛型R的对象，函数描述符为(T) -> R。举个例子：
        **/
        Function<Apple, Double> getAppleWeight = (a) -> {
            return a.getWeight();
        };
//        getAppleWeight.apply(new Apple(17)); // 17.0
        //Functions接口还提供了两个抽象方法compose和andThen，从源码可以看出两者的根本区别。举个compose例子：

        Function<Integer, Integer> f = (x) -> x + 1;
        Function<Integer, Integer> g = (x) -> x * 2;
        f.compose(g).apply(2); // 5
       /** 过程为：f(g(2))，也就是1+(2*2)。

        举个andThen的例子：
        **/
        Function<Integer, Integer> ff = (x) -> x + 1;
        Function<Integer, Integer> gg = (x) -> x * 2;
        ff.andThen(gg).apply(2); // 6
        /**过程为：g(f(2))，也就是(2+1)*2。

        原始类型特化
        在学习Function接口的时候，我们定义了f函数：

        Function<Integer, Integer> f = (x) -> x + 1;
        x的类型为Integer类型，1为int类型，返回值为Integer类型，整个过程实际上为Integer.valueOf(x.intValue() + 1)。虽然编译器可以自动帮我们完成拆装箱，但这会造成不必要的性能消耗。考虑到了这一点，Java8为我们提供了int类型的Function接口：IntFunction:

        @FunctionalInterface
        public interface IntFunction<R> {
            R apply(int value);
        }
        所以f最好重构为：

        IntFunction<Integer> f = (x) -> x + 1;
        剩余的原始类型特化函数式接口可参考上面的表格。
        */
       /** Java8中增强的Comparator
        在Java8之前，Comparator接口用于实现简单的比较排序算法。比如有如下List：
        */
        List<Double> list = new ArrayList<>();
        list.add(12.3);
        list.add(100.2);
        list.add(3.14);
        list.add(27.7);
        list.add(-9.8);
//        使用Comparator接口对其从小到大排序：

        Collections.sort(list, new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return o1.compareTo(o2);
            }
        });
//        Comparator接口也是一个函数式接口，函数描述符为(T,T) -> int，Java8中可以使用Lambda改造上面的排序方法：

        Collections.sort(list, (o1, o2) -> o1.compareTo(o2));
//        Java8对List提供了sort方法，可以替代Collections.sort，所以上面的代码可以简化为：

        list.sort((o1, o2) -> o1.compareTo(o2));
//        使用方法的引用来进一步简化：

        list.sort(Double::compareTo);
//        Java8对Comparator进行了增强，加入了一些实用的默认方法，比如对排序结果反转：

        Comparator<Double> comparator = Double::compareTo;
        list.sort(comparator.reversed());
    }}
