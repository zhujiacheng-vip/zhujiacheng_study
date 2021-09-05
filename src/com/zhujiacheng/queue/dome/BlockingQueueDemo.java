package com.zhujiacheng.queue.dome;

/*
 * 阻塞队列
 * */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class BlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {

        /*
         * 对列里面能装多少就只能装那么多
         * */
        /*BlockingQueue blockingQueue = new ArrayBlockingQueue(5);

        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));

        System.out.println(blockingQueue.element());

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());

        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a"));

        System.out.println(blockingQueue.peek());

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());

        blockingQueue.put("1");*/

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }

        //定义阻塞队列的大小
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(list.size());

        //把数据同步进去
        arrayBlockingQueue.addAll(list);

        //循环取数据(效率很低)
        List<List<Integer>> list2 = new ArrayList<>();
        List<Integer> listCopy = new ArrayList<>();
        while (true) {
            Integer take = (Integer) arrayBlockingQueue.take();
            if (null == take)
                break;
            listCopy.add(take);
            if (list.size() == 1000) {
                list2.add(list);
            }
        }

        System.err.println(list2);

    }

    public void find2(){

        ConcurrentSkipListMap concurrentSkipListMap = new ConcurrentSkipListMap<>();

        ConcurrentSkipListSet concurrentSkipListSet = new ConcurrentSkipListSet<>();



    }


}
