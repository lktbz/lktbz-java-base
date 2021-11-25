package com.xiao.java8.stream;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *    简介：
 *    Stream 用于对集合对象进行各种非常便利、高效的聚合操作，或者大批量数据操作。Stream API 借助于Lambda 表达式，
 *    极大的提高编程效率和程序可读性。同时它提供串行和并行两种模式进行汇聚操作，
 *    并发模式能够充分利用多核处理器的优势。通过下面的例子我们可以初步体会到使用 Stream 处理集合的便利性。
 */
public class StreamDemo01 {
    public static void main(String[] args) {
        //有如下一个List，现要从中筛选出以J开头的元素，然后转换为大写，
        // 最后输出结果。Java 8之前我们是这样做的：
//        java8之前
        List<String> stringList = Arrays.asList("Java", "JavaScript", "python", "PHP", "C#", "Golang", "Swift");
//        List<String>js=new ArrayList<>();
//        for (String s:stringList) {
//            if (s.startsWith("J")){
//                js.add(s.toUpperCase());
//            }
//        }
//        for (String  jss:js
//             ) {
//            System.out.println(jss);
//        }
        /**
         * java 8 Stream 使用, 替换掉上面
         */
        stringList.stream().filter(s->s.startsWith("#"))
                .map(String::toUpperCase)
                .forEach(System.out::println);

        /**
         * 上面的例子中，集合使用stream方法创建了一个流，然后使用filter和map方法来处理这个集合，
         * 它们统称为中间操作。中间操作都会返回另一个流，以便于将各种对集合的操作连接起来形成一条流水线。
         * 最后我们使用了forEach方法迭代筛选结果，这种位于流的末端，对流进行处理并且生成结果的方法称为终端操作。
         *
         * 总而言之，流的使用一般包括三件事情：
         *
         * 一个数据源（如集合）来执行一个查询；
         *
         * 一个中间操作链，形成一条流的流水线；
         *
         * 一个终端操作，执行流水线，并能生成结果。
         */
//        #中间操作
        /**
         * streams接口支持·filter方法，该方法接收一个Predicate<T>，
         * 函数描述符为T -> boolean，用于对集合进行筛选，返回所有满足的元素：
         */
         stringList.stream()
            .filter(s -> s.contains("#"))
            .forEach(System.out::println);

        /**
         * distinct方法用于排除流中重复的元素，类似于SQL中的distinct操作。
         * 比如筛选中集合中所有的偶数，并排除重复的结果：
         */
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
              .filter(i-> i%2==0)
              .distinct()
              .forEach(System.out::println);
        /**
         * skip(n)方法用于跳过流中的前n个元素，如果集合元素小于n
         * ，则返回空流。比如筛选出以J开头的元素，并排除第一个：
         */
        stringList.stream()
                .filter(s ->s.startsWith("J") )
                .skip(1)
                .forEach(System.out::println);
        /**
         * limit(n)方法返回一个长度不超过n的流，
         * 比如下面的例子将输出Java JavaScript python,PHP：
         */
        System.out.println("============================");
        stringList.stream()
                .limit(4)
                .forEach(System.out::println);
        /**
         * 过滤掉J开头的，只显示一个数
         */
        stringList.stream()
                .filter(s->s.startsWith("J"))
                .limit(1)
                .forEach(System.out::println);

        /**
         * map方法接收一个函数作为参数。这个函数会被应用到每个元素上，并将其映射成一个新的元素。如：
         */
        System.out.println("============================");
        stringList.stream()
                .map(String::length)
                .forEach(System.out::println);
        System.out.println("============================");

        /**
         * map还支持将流特化为指定原始类型的流，如通过mapToInt，mapToDouble和mapToLong方法，可以将流转换为IntStream，
         * DoubleStream和LongStream。特化后的流支持sum，min和max方法来对流中的元素进行计算。比如：
         */
        List<Integer> numbers1 = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        IntStream intStream = numbers1.stream().mapToInt(a -> a);
        System.out.println(intStream.sum()); // 16

        System.out.println("============================");
        /**
         * flatMap用于将多个流合并成一个流，俗称流的扁平化。这么说有点抽象，
         * 举个例子，比如现在需要将list中的各个元素拆分为一个个字母，并过滤掉重复的结果，你可能会这样做
         */
        stringList.stream()
                .map(s -> s.split(""))
                .distinct()
                .forEach(System.out::println);
        /**
         * 这明显不符合我们的预期。实际上在map(s -> s.split(""))操作后，
         * 返回了一个Stream<String[]>类型的流，所以输出结果为每个数组对象的句柄，而我们真正想要的结果是Stream<String>！
         *
         * 在Stream中，可以使用Arrays.stream()方法来将数组转换为流，改造上面的方法：
         */
        System.out.println("============================");
        stringList.stream()
                .map(s -> s.split(""))
                .map(Arrays::stream)
                .distinct()
                .forEach(System.out::println);
        System.out.println("============================");
        /**
         * 因为上面的流经过map(Arrays::stream)处理后，将每个数组变成了一个新的流，
         * 返回结果为流的数组Stream<String>[]，所以输出是各个流的句柄。
         * 我们还需将这些新的流连接成一个流，使用flatMap来改写上面的例子：
         */
        stringList.stream()
                .map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .forEach(s -> System.out.print(s + " "));

        System.out.println("============================");
//        终端操作
        /**
         * anyMatch方法用于判断流中是否有符合判断条件的元素，
         * 返回值为boolean类型。比如判断list中是否含有SQL元素：
         */
        stringList.stream()
                .anyMatch(s -> "SQL".equals(s)); // false
        /**
         * allMatch方法用于判断流中是否所有元素都满足给定的判断条件，
         * 返回值为boolean类型。比如判断list中是否所有元素长度都不大于10：
         */
        System.out.println("============================");
        stringList.stream()
                .allMatch(s -> s.length() <= 10); // true
        /**
         * noneMatch方法用于判断流中是否所有元素都不满足给定的判断条件，
         * 返回值为boolean类型。比如判断list中不存在长度大于10的元素：
         */
        stringList.stream()
                .noneMatch(s -> s.length() > 10); // true
        System.out.println("============================");
        /**
         * findAny方法用于返回流中的任意元素的Optional类型，
         * 例如筛选出list中任意一个以J开头的元素，如果存在，则输出它
         */
        stringList.stream()
                .filter(s -> s.startsWith("J"))
                .findAny()
                .ifPresent(System.out::println); // Java
        /**
         * findFirst方法用于返回流中的第一个元素的Optional类型，
         * 例如筛选出list中长度大于5的元素，如果存在，则输出第一个：
         */
        stringList.stream()
                .filter(s -> s.length() > 5)
                .findFirst()
                .ifPresent(System.out::println); // JavaScript

        /**
         * reduce函数从字面上来看就是压缩，缩减的意思，
         * 它可以用于数字类型的流的求和，求最大值和最小值。如对numbers中的元素求和：
         */
        List<Integer> numbers3 = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers3.stream()
                .reduce(0, Integer::sum); // 16

//        reduce函数也可以不指定初始值，但这时候将返回一个Optional对象，比如求最大值和最小值：
        numbers3.stream()
                .reduce(Integer::max)
                .ifPresent(System.out::println); // 4

        numbers3.stream()
                .reduce(Integer::min)
                .ifPresent(System.out::println); // 1


        /**
         * forEach用于迭代流中的每个元素，最为常见的就是迭代输出，如：
         */
        stringList.stream().forEach(System.out::println);
        /**
         * count方法用于统计流中元素的个数，比如：
         */
        stringList.stream().count(); // 9

        /**
         * collect方法用于收集流中的元素，并放到不同类型的结果中，比如List、Set或者Map。举个例子：
         * 如果需要以Set来替代List，只需要使用Collectors.toSet()
         */
        List<String> filterList = stringList.stream()
                .filter(s -> s.startsWith("J")).collect(Collectors.toList());
        /**
         * 流的构建方式
         */
//        数值范围构建
        /**
         * IntStream和LongStream对象支持range和rangeClosed方法来构建数值流。这两个方法都是第一个参数接受起始值，
         * 第二个参数接受结束值。但range是不包含结束值的，而rangeClosed则包含结束值。比如对1到100的整数求和：
         */
        IntStream.rangeClosed(1, 100).sum(); // 5050
//        由值构建
        /**
         * 静态方法Stream.of可以显式值创建一个流。它可以接受任意数量的参数。
         * 例如，以下代码直接使用Stream.of创建了一个字符串流:
         * 也可以使用Stream.empty()构建一个空流：
         */
        Stream<String> s = Stream.of("Java", "JavaScript", "C++", "Ruby");
        Stream<Object> emptyStream = Stream.empty();
//        由数组构建
        /**
         *静态方法Arrays.stream可以通过数组创建一个流。它接受一个数组作为参数。例如：
         */
        int[] arr = {1, 2, 3, 4, 5};
        IntStream intStreams = Arrays.stream(arr);

//        由文件生成流
        /**
         * java.nio.file.Files中的很多静态方法都会返回一个流。
         * 例如Files.lines方法会返回一个由指定文件中的各行构成的字符串流。比如统计一个文件中共有多少个字
         */
        long wordCout = 0L;
        try (Stream<String> lines = Files.lines(Paths.get("file.txt"), Charset.defaultCharset())) {
            wordCout = lines.map(l -> l.split(""))
                    .flatMap(Arrays::stream)
                    .count();
        } catch (Exception ignore) {}

//        由函数构造
        /**
         * Stream API提供了两个静态方法来从函数生成流：Stream.iterate和Stream.generate。
         * 这两个操作可以创建所谓的无限流。比如下面的例子构建了10个偶数：
         */
        Stream.iterate(0, n -> n + 2)
                .limit(10).forEach(System.out::println);
        /**
         * iterate方法接受一个初始值（在这里是0），还有一个依次应用在每个产生的新值上的Lambda（UnaryOperator类型）。
         * 这里，我们使用Lambda n -> n + 2，返回的是前一个元 素加上2。因此，iterate方法生成了一个所有正偶数的流：
         * 流的第一个元素是初始值0。然后加上2来生成新的值2，再加上2来得到新的值4，以此类推。
         *
         * 与iterate方法类似，generate方法也可让你按需生成一个无限流。但generate不是依次对每个新生成的值应用函数，
         * 比如下面的例子生成了5个0到1之间的随机双精度数：
         */
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }

}
