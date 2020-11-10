package com.zhujiacheng.queue.dome;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/*
* 阻塞队列
* 如果不消费就不会生产，会阻塞
* */
public class SynchronousQueueDemo {

    public static void main(String[] args) {

        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();

        new Thread(()->{

            try {
                System.out.println(Thread.currentThread().getName()+"\t put1");
                blockingQueue.put("1");

                System.out.println(Thread.currentThread().getName()+"\t put1");
                blockingQueue.put("2");

                System.out.println(Thread.currentThread().getName()+"\t put1");
                blockingQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        },"AAA").start();


        new Thread(()->{

            try {
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println(Thread.currentThread().getName()+"\t"+blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println(Thread.currentThread().getName()+"\t"+blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }  /*try {
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println(Thread.currentThread().getName()+"\t"+blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/


        },"BBB").start();


    }

}
