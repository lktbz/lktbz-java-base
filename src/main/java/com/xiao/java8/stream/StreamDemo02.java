package com.xiao.java8.stream;

import java.util.*;

import static java.util.stream.Collectors.*;

public class StreamDemo02 {
    public static void main(String[] args) {
        List<Dish> list = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH) );
        /**
         * collectors.maxBy和Collectors.minBy用来计算流中的最大或最小值，比如按卡路里的大小来筛选出卡路里最高的食材：
         */
        list.stream()
                .collect(maxBy(Comparator.comparingInt(Dish::getCalories)))
                .ifPresent(System.out::println);
        /**
         * Collectors.summingInt可以用于求和，参数类型为int类型。
         * 相应的基本类型对应的方法还有Collectors.summingLong和Collectors.summingDouble。比如求所有食材的卡路里
         */
        list.stream().collect(summingInt(Dish::getCalories)); // 4200

        /**
         * Collectors.averagingInt方法用于求平均值，参数类型为int类型。
         * 相应的基本类型对应的方法还有Collectors.averagingLong和Collectors.averagingDouble。比如求所有食材的平均卡路里:
         */
        list.stream().collect(averagingInt(Dish::getCalories)); // 466.6666666666667
//        Collectors.summarizingInt方法可以一次性返回元素个数，最大值，最小值，平均值和总和：
        IntSummaryStatistics iss = list.stream().collect(summarizingInt(Dish::getCalories));
        /**
         * 同样，相应的summarizingLong和summarizingDouble方法有相关的
         * LongSummaryStatistics和DoubleSummaryStatistics类型，适用于收集的属性是原始类型long或double的情况
         */
        System.out.println(iss); // IntSummaryStatistics{count=9, sum=4200, min=120, average=466.666667, max=800}

        /**
         * Collectors.joining方法会把流中每一个对象应用toString方法得到的所有字符串连接成一个字符串。如：
         */
        list.stream().map(Dish::getName).collect(joining());
// porkbeefchickenfrench friesriceseason fruitpizzaprawnssalmon
//        内部拼接采用了StringBuilder。除此之外，也可以指定拼接符：

        list.stream().map(Dish::getName).collect(joining("，"));
// pork，beef，chicken，french fries，rice，season fruit，pizza，prawns，salmon
        /**
         * Collectors.reducing方法可以实现求和，最大值最小值筛选，拼接等操作。上面介绍的方法在编程上更方便快捷，
         * 但reducing的可读性更高，实际使用哪种我觉得还是看个人喜好。举个使用reducing求最大值的例子
         */
        list.stream().collect(reducing(0, Dish::getCalories, Integer::max)); // 800

        list.stream().map(Dish::getCalories).collect(reducing(0, Integer::max)); // 800

        /**
         * 分组功能类似于SQL里的group by，可以对流中的元素按照指定分组规则进行分组。
         * Collectors.groupingBy方法可以轻松的完成分组操作。比如现在对List中的食材按照类型进行分组：
         */
        Map<Dish.Type, List<Dish>> dishesByType = list.stream().collect(groupingBy(Dish::getType));
        System.out.println(dishesByType);
        /**
         * 我们也可以自定义分组规则，比如按照卡路里的高低分为高热量，正常和低热量：
         *
         * 首先定义一个卡路里高低的枚举类型
         * CaloricLevel
         */
        Map<CaloricLevel, List<Dish>> dishesByCalories = list.stream().collect(
                groupingBy(d -> {
                    if (d.getCalories() <= 400) {return CaloricLevel.DIET;}
                    else if(d.getCalories() <= 700) { return CaloricLevel.NORMAL;}
                    else {return CaloricLevel.FAT;}
                })
        );
        System.out.println(dishesByCalories);

        /**
         * Collectors.groupingBy支持嵌套实现多级分组，比如将食材按照类型分类，然后再按照卡路里的高低分类：
         */
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesGroup = list.stream().collect(
                groupingBy(Dish::getType, groupingBy(d -> {
                            if (d.getCalories() <= 400){ return CaloricLevel.DIET;}
                            else if (d.getCalories() <= 700){ return CaloricLevel.NORMAL;}
                            else{return CaloricLevel.FAT;}
                        })
                ));
        System.out.println(dishesGroup);
/**
        实际上，第二个参数除了Collectors.groupingBy外，也可以传递其他规约操作，规约的结果类型对应Map里的第二个泛型。举些例子，将食材按照类型分，然后统计各个类型对应的数量：

        Map<Dish.Type, Long> dishesCountByType = list.stream().collect(groupingBy(Dish::getType,counting()));
        System.out.println(dishesCountByType);
        因为Collectors.counting方法返回Long类型，所以Map第二个泛型也必须指定为Long。输出结果：{OTHER=4, FISH=2, MEAT=3}。

        或者对食材按照类型分，然后选出卡路里最高的食物：

        Map<Dish.Type, Optional<Dish>> map = list.stream().collect(groupingBy(
                Dish::getType, maxBy(Comparator.comparing(Dish::getCalories))
        ));
        System.out.println(map);
        输出结果：{OTHER=Optional[pizza], MEAT=Optional[pork], FISH=Optional[salmon]}。如果不希望输出结果包含Optional，可以使用Collectors.collectingAndThen方法：

        Map<Dish.Type, Dish> map = list.stream().collect(groupingBy(
                Dish::getType, collectingAndThen(maxBy(Comparator.comparing(Dish::getCalories)), Optional::get)
        ));
        System.out.println(map);
        输出结果：{OTHER=pizza, FISH=salmon, MEAT=pork}。

        常与Collectors.groupingBy组合使用的方法还有Collectors.mapping。Collectors.mapping方法接受两个参数：一个函数对流中的元素做变换，另一个则将变换的结果对象收集起来，比如对食材按照类型分类，然后输出各种类型食材下卡路里等级情况：

        Map<Dish.Type, HashSet<CaloricLevel>> map = list.stream().collect(groupingBy(
                Dish::getType, mapping(
                        d -> {
                            if (d.getCalories() <= 400) return CaloricLevel.DIET;
                            else if (d.getCalories() <= 700) return CaloricLevel.NORMAL;
                            else return CaloricLevel.FAT;
                        }, toCollection(HashSet::new)
                )
        ));
        System.out.println(map);
        Collectors.toCollection方法可以方便的构造各种类型的集合。输出结果：{FISH=[DIET, NORMAL], MEAT=[DIET, NORMAL, FAT], OTHER=[DIET, NORMAL]}。
        **/

        /**
         * 分区类似于分组，只不过分区最多两种结果。Collectors.partitioningBy方法用于分区操作，接收一个Predicate<T>类型的Lambda表达式作为参数。比如将食材按照素食与否分类：
         *
         * Map<Boolean, List<Dish>> map = list.stream().collect(partitioningBy(Dish::isVegetarian));
         * System.out.println(map);
         * 输出结果：{false=[pork, beef, chicken, prawns, salmon], true=[french fries, rice, season fruit, pizza]}。
         *
         * Collectors.partitioningBy方法还支持传入分组函数或者其他规约操作，比如将食材按照素食与否分类，然后按照食材类型进行分类：
         *
         * Map<Boolean, Map<Dish.Type, List<Dish>>> map = list.stream().collect(
         *         partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));
         * System.out.println(map);
         * 输出结果：{false={MEAT=[pork, beef, chicken], FISH=[prawns, salmon]}, true={OTHER=[french fries, rice, season fruit, pizza]}}。
         *
         * 再如将食材按照素食与否分类，然后筛选出各自类型中卡路里含量最低的食材：
         *
         * Map<Boolean, Dish> map = list.stream().collect(
         *         partitioningBy(Dish::isVegetarian, collectingAndThen(
         *                 minBy(Comparator.comparing(Dish::getCalories)), Optional::get
         *         )));
         * System.out.println(map);
         * 输出结果：{false=prawns, true=season fruit}。s
         */

    }
    public enum CaloricLevel { DIET, NORMAL, FAT };
}
