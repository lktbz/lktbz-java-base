package com.xiao.java8.JUC;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: lktbz
 * @Date: 2019/7/26 18:07
 * @Description:
 * 使用场景描述：
 *    作为男人，电脑上必须有苍老师的爱情动作片。
 *    这种片子必须藏得非常隐蔽，隐蔽到什么程度呢？
 *    自己都忘了把它藏哪里了，这可咋办啊？编写多线程程序，
 *    针对每一个硬盘分区，启动一个线程，搜索该硬盘分区上的所有文件，
 *    找名字中含有“苍老师”的文件。由于这些片子都是集中存放，
 *    因此，我只需要找到一个，就无需在继续寻找。例如，某线程在D盘找到了一个苍老师的文件，
 *    则此线程立刻终结，同时，处理C盘，E盘的线程也应该立刻终结，
 *    因为既然D盘找到了，其他盘搜索就毫无意义了，肯定没有结果
 */
public class ExecutorsServiceInvokeAny {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10);
        List<Callable<String>> list = new ArrayList<>();

        //针对每一个硬盘分区，定义一个任务，查找名字中包含有“苍老师”的文件
        FileSystem fs = FileSystems.getDefault();
        for(Path root : fs.getRootDirectories()) {
            if(Files.isDirectory(root)) {
                list.add(new FileFinder("苍老师", root));
            }
        }

        //使用invokeAny()方法，当任意一个线程找到结果之后，立刻终结所有线程
        try {
            System.out.println(es.invokeAny(list));
        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }

        es.shutdown();
    }

}


//定义一个文件查找类，实现Callable接口，可作为线程启动
//同时继承自SimpleFileVisitor，目的是成为一个FileVIsitor，
//在Nio 2中新出现的遍历文件夹方法，需要一个FileVIsitor作为访问器
class FileFinder extends SimpleFileVisitor<Path> implements Callable<String>{

    private String key_word;
    private Path path;
    private String result;

    public FileFinder(String key_word, Path path) {
        super();
        this.key_word = key_word;
        this.path = path;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
            throws IOException {
        if(file.toString().contains(key_word)) {
            //若找到了指定的文件，则结束遍历
            result = file.toString();
            return FileVisitResult.TERMINATE;
        }else {
            return FileVisitResult.CONTINUE;
        }
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc)
            throws IOException {
        // 这个方法必须重载，因为遇到系统文件后，可能会被拒绝访问并抛出异常
        // 重载了这个方法后，遇到问题直接跳过，就不会抛出异常了
        return FileVisitResult.SKIP_SUBTREE;
    }

    @Override
    public String call() throws Exception {
        try {
            Files.walkFileTree(path, this);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(result == null) {
            //若没找到，则抛出一个异常
            //该异常的作用就是告诉invokeAny()函数，此线程未能找到合适的结果
            //invokeAny()函数会很好的处理该异常，这是该函数的正常处理机制
            throw new Exception("没找到");
        }
        return result;
    }


}
