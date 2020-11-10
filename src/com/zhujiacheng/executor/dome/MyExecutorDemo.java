package com.zhujiacheng.executor.dome;
/*
* 线程池
* 查看cpu的核数
 System.out.println(Runtime.getRuntime().availableProcessors());
*
* 1.常用线程池
*       //执行一个长期的任务,性能好很多
        ExecutorService threadPool1 = Executors.newFixedThreadPool();

        //一个任务一个线程执行的任务场景
        ExecutorService threadPool2 = Executors.newSingleThreadExecutor();

        //适用:执行很多短期异步的小程序或者负载较轻的服务器
        ExecutorService threadPool3 = Executors.newCachedThreadPool();
*
* */

import java.util.concurrent.*;

public class MyExecutorDemo {

    public static void main(String[] args) {

        //一池5线程
        //ExecutorService threadPoll = Executors.newFixedThreadPool(5);

        //一池1线程
        //ExecutorService threadPoll = Executors.newSingleThreadExecutor();

        //一池N个线程，根据实际情况来创建线程
       ExecutorService threadPoll = Executors.newCachedThreadPool();

;

        try {
            //10个用户的请求
            for (int i = 0; i <10 ; i++) {

                threadPoll.execute(()->{

                    System.out.println(Thread.currentThread().getName()+"\t办理业务");

                });

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPoll.shutdown();
        }

    }

}
