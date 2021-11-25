package com.xiao.java8.stream;

import java.util.function.LongConsumer;
import java.util.stream.LongStream;

/**
 * 并行流
 */
public class StreamDemo03 {
    public static void main(String[] args) {
        /**
         * 除了顺序流外，Java 8中也可以对集合对象调用parallelStream方法或者对顺序流调用parallel方法来生成并行流。
         * 并行流就是一个把内容分成多个数据块，并用不同的线程分别处理每个数据块的流。
         * 这样在使用流处理数据规模较大的集合对象时可以充分的利用多核CPU来提高处理效率。不过在一些情况下，并行流未必会比顺序流快，
         * 甚至会慢很多，所以了解如何高效的使用并行流也至关重要。此外，我们也可以调用流的sequential方法，将并行流转换为顺序流。
         */
        /**
         * 举个例子，对1到1000的整数求和，观察顺序流和并行流的处理时间：
         */

            StreamDemo03.test((n) -> LongStream.rangeClosed(1L, n).reduce(0L, Long::sum), 1000000000L);
             StreamDemo03.test((n) -> LongStream.rangeClosed(1L, n).parallel().reduce(0L, Long::sum), 1000000000L);

            }
            static void test(LongConsumer c, Long n) {
                long start = System.currentTimeMillis();
                c.accept(n);
                long end = System.currentTimeMillis();
                System.out.println("处理时间：" + (end - start) + "msc");


    }
}
