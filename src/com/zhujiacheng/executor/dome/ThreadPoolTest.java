package com.zhujiacheng.executor.dome;

import java.util.concurrent.*;

public class ThreadPoolTest {

    public static void main(String[] args) {

        ExecutorService threadPool = new ThreadPoolExecutor(2,5,1L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(6),Executors.defaultThreadFactory(),new ThreadPoolExecutor.DiscardPolicy());

        try {
            for (int i = 0; i < 10; i++) {

                threadPool.execute(()->{

                    System.out.println(Thread.currentThread().getName()+"我要去吃饭");

                });

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }


    }

}
