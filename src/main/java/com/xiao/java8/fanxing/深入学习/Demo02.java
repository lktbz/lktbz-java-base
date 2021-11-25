package com.xiao.java8.fanxing.深入学习;

/**
 * @Classname Demo02
 * @Description 泛型类，接口使用
 * @Date 2021/6/5
 * @Created by lktbz
 */
public class Demo02 {
    /**
     * 当属性不确定时？那我类的声明上是否需要告知外界使用者呢？
     * 是否可以使用上述的思路去解释GenerClass<F> 后面带的F呢？
     * @param <F>
     */
    public class GenerClass<F>{
        /**
         * 定义泛型的属性
         */
        private F ele;

        public GenerClass(F ele) {
            this.ele = ele;
        }

        /**
         *泛型的方法
         * @return F
         */
        public F getContent(){
            return ele;
        }
        /**
         *泛型的方法
         * @return
         */
        public void setContent(F ele){
            this.ele=ele;
        }


    }

    /**
     *  接口上不写T，idea 上会提示性信息。
     *  接口使用泛型
     * @param <T>
     */
    public  interface GenerInterface<T> {
        void doSomeThing(T t);
    }
}
