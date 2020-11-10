package com.zhujiacheng.queue.dome;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyResource {

    //多线程的情况下要保证线程的可见性
    private volatile boolean flag = true; //默认开启生产+消费

    private AtomicInteger atomicInteger = new AtomicInteger();

    BlockingQueue<String> blockingQueue = null;

    //传参数一定要通用（保证各种情况下的适配和适用）
    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void myProd() throws Exception {
        String data = null;

        boolean retValue;

        //while判断
        while (flag) {

           data = atomicInteger.incrementAndGet()+"";

           retValue = blockingQueue.offer(data,2l, TimeUnit.SECONDS);

       if(retValue){

           System.out.println(Thread.currentThread().getName()+"\t插入成功");

       }else{

           System.out.println(Thread.currentThread().getName()+"\t插入失败");

       }

       TimeUnit.SECONDS.sleep(1);

        }

        System.out.println(Thread.currentThread().getName()+"\t停下来");

    }

    public void myConsumer() throws Exception {
        String data = null;

        String retValue;

        //while判断
        while (flag) {

            data = atomicInteger.incrementAndGet()+"";

            retValue = blockingQueue.poll(2L,TimeUnit.SECONDS);

            if(retValue==null&&retValue.equalsIgnoreCase("")){

                flag = false;

                System.out.println(Thread.currentThread().getName()+"消费队列"+retValue+"失败");

                return;

            }

            System.out.println(Thread.currentThread().getName()+"消费队列"+retValue+"成功");

            TimeUnit.SECONDS.sleep(1);

        }

        System.out.println(Thread.currentThread().getName()+"\t停下来");

    }

    public void stop(){

        this.flag = false;

    }

}

/*
 * 消息中间件的底层实现思想
 *
 * */

public class ProdConsumer_TraditionNewMqDemo {

    public static void main(String[] args) throws InterruptedException {

        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));

        new Thread(()->{

            System.out.println("生产线程启动");

            try {
                myResource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }

        },"生产线程").start();


        new Thread(()->{

            System.out.println("消费线程启动");

            try {
                myResource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }

        },"消费线程").start();

        TimeUnit.MILLISECONDS.sleep(5);

        System.out.println("老板叫停");

        myResource.stop();

    }

}
