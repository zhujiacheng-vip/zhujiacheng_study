package com.zhujiacheng.executor.dome;

import java.util.concurrent.*;

/*
 * 自定义线程池
 *
 * */
public class MyExecutorPoolDemo {

    public static void main(String[] args) {

        ExecutorService threadPool = new ThreadPoolExecutor(2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        try {
             //最大处理线程数+队列的容量
            for (int i = 1; i < 20; i++) {

                threadPool.execute(()->{

                    System.out.println(Thread.currentThread().getName()+"\t办理业务");

                });

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            threadPool.shutdown();

        }

    }

}
