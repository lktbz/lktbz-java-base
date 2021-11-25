package com.xiao.java8.lambda.news.pakgs;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author lktbz
 * @description: 方法引用
 * @date 2021/11/25
 */
public class LambdaExpressionmMethodRenfeExample {
    public List<String> google(String keyword) {
        return Arrays.asList("Search Result One","Search Result Two","Search Result Three");
    }
    public List<String> bing(String keyword) {
        return Arrays.asList("Search Result 1","Search Result 2","Search Result 3");
    }
    /**
     * 返回合适的搜索引擎
      * @param input
     * @param keyword
     * @return
     */
   public Callable<List<String>>getSearchEngine(char input, String keyword){
       if(input=='G') {
           return ()->this.google(keyword);
       }
       return ()->this.bing(keyword);
   }
    public static void main(String[] args) throws Exception {
        LambdaExpressionmMethodRenfeExample lm=new LambdaExpressionmMethodRenfeExample();
        Callable<List<String>> searchEngine = lm.getSearchEngine('w', "java");
        List<String> call = searchEngine.call();
        if(!call.isEmpty()){
            call.forEach(System.out::println);
        }
    }
}
