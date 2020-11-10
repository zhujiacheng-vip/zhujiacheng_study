package com.zhujiacheng.queue.dome;

import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/*
* 信号灯
* */
public class SemaphoreDemo {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(1);

        for (int i = 0; i < 10; i++) {

            new Thread(()->{

                try {
                    //锁上
                    semaphore.acquire();

                    System.out.println(Thread.currentThread().getName()+"\t抢到车位");

                    TimeUnit.MILLISECONDS.sleep(300);

                    System.out.println(Thread.currentThread().getName()+"\t停车3秒离开");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    //释放锁
                    semaphore.release();

                }

            },String.valueOf(i)).start();

        }
        

    }

}
