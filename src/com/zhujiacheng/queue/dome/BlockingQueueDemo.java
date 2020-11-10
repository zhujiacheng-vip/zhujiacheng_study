package com.zhujiacheng.queue.dome;

/*
 * 阻塞队列
 * */

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {

        /*
         * 对列里面能装多少就只能装那么多
         * */
        BlockingQueue blockingQueue = new ArrayBlockingQueue(5);

        /*System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));

        System.out.println(blockingQueue.element());

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());*/

        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a"));

        System.out.println(blockingQueue.peek());

       /* System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());*/

        blockingQueue.put("1");

    }

}
