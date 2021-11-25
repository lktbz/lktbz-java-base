package com.xiao.java8.JUC;

/**
 * @Auther: lktbz
 * @Date: 2019/7/26 16:23
 * @Description: 这个是线程池中的拒绝策略，当现在任务量过多，处理办法
 *
 *
 * 在默认ThreadPoolExecutor.AbortPolicy ，
 *
 * 被拒绝的任务的处理程序，抛出一个 RejectedExecutionException 。
 * 在ThreadPoolExecutor.CallerRunsPolicy中，
 * 一个被拒绝的任务的处理程序，直接在 execute方法的调用线程中运行被拒绝的任务，除非执行程序已被关闭，否则这个任务被丢弃。
 * 在ThreadPoolExecutor.DiscardPolicy中 ，
 * 简单地删除无法执行的任务。
 *被拒绝的任务的处理程序静默地丢弃被拒绝的任务。
 * 在ThreadPoolExecutor.DiscardOldestPolicy中 ，
 * 被拒绝的任务的处理程序，丢弃最旧的未处理请求，然后重试 execute ，除非执行程序被关闭，在这种情况下，任务被丢弃。
 */
public class ThreadPoolExecutor {
}
