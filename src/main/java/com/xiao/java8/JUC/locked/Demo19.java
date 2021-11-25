package com.xiao.java8.JUC.locked;

/**
 * @ClassName Demo19
 * @Description Future
 * @Author lktbz
 * @Date 2021/1/14
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * 场景：
 *   现在想吃火锅，
 *   家里只有锅，没有菜了，其中媳妇又特别想吃虾滑，没办法只能出去买菜，然后回来烧水，在洗菜
 *   然后上电开始煮。
 *
 *  这一切并没有问题，因为就该这么去做，为了提升效率，
 *  使用多线程方式，我在买菜APP上提交一个订单，让他们给我准备好菜品，并给我送过来，我回来后检查
 *  是不是有我媳妇爱吃的虾滑，没有的话我在去别的店里买或者媳妇体量我，说不吃了。
 */
public class Demo19 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service= Executors.newFixedThreadPool(1);
        System.out.println("想吃火锅了");
        Future submit = service.submit(new HotVegetables());
        System.out.println("准备吃火锅的各种调味料");
        System.out.println("准备刷锅");
        System.out.println("锅中加入水，火锅底料，等待这把菜送过来");
        /**
         * 直接接受到返回结果，才会执行，不然一直阻塞
         */
        List<String> veList= (List<String>) submit.get();
        //检查菜品
        if(!veList.contains("虾滑")){
            System.out.println("媳妇不好意思，没有虾滑，就这样吃吧");
        }
        System.out.println("开始吃火锅中");
        /**
         * 取消执行
         */
        service.shutdown();
    }

    /**
     * 火锅类
     */
    static class HotVegetables implements Callable {
        @Override
        public List<String> call() throws Exception {
            System.out.println("拿起手机下单选菜中");
            //商店有的产品
            List<String> storeList = Arrays.asList("白菜", "粉条", "鸭血", "豆腐", "虾滑", "羊肉卷");
            /**
             * 返回的菜品
             */
            List<String> callBackList=new ArrayList<>();
            for (String veg: storeList) {
                if(!veg.equals("虾滑"))
                  callBackList.add(veg);
            }
            //模拟骑手送达时间
            Thread.sleep(5000);
            System.out.println("此次配送的菜有:"+callBackList);
            return callBackList;
        }
    }
}
