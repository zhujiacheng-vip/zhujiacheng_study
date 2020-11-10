package com.zhujiacheng.jvm.demo;


import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.*;

/**
 * @Author Mr zhu
 * @Date 2020/8/19 22:04
 */
public class JvmDemo {

    public static void main(String[] args) throws Exception {

       //强引用死都不会回收OOM也不会回收的
/*

       Object obj = new Object();

       Object obj1 = obj;

       obj =null;

       System.gc();

        System.out.println(obj1);
*/

       /* //弱引用，内存不足时会回收
        Object object = new Object();

        SoftReference<Object> softReference = new SoftReference<Object>(object);

        object = null;

        System.gc();

        try {
        //配置堆的大小
            Byte[] bytes = new Byte[30*1024*1024];

        }catch (Exception e){

        }finally {
            System.out.println(softReference.get());

        }

        System.out.println(object);

        System.out.println(softReference.get());*/


       /* //弱引用只要GC就回收
        Object object = new Object();

        WeakReference weakReference = new WeakReference<>(object);

        object = null;

        System.gc();

        System.out.println(object);

        System.out.println(weakReference.get());*/

      /*  MyWeekHashMap();*/

        referenceQueueTest();

    }

    private static void MyWeekHashMap() {

        WeakHashMap<Integer, String> weakHashMap = new WeakHashMap<>();

        Integer key = new Integer(2);

        weakHashMap.put(key,"WeekHashMap");

        key = null;

        System.out.println(weakHashMap);

        System.gc();

        System.out.println(weakHashMap.size());

    }


    public static void MyHashMap(){
        /*//读取大量的图片在磁盘里影响性能，在内存里又容易OOM，就用弱引用
        WeakHashMap weakHashMap = new WeakHashMap();*/

        HashMap<Integer, String> hashMap = new HashMap<>();

        Integer key = new Integer(1);

        hashMap.put(key,"HashMap");

        key = null;

        System.out.println(hashMap);

        System.gc();

        System.out.println(hashMap.size());

    }


    public static void referenceQueueTest(){

        Object object = new Object();

        ReferenceQueue referenceQueue = new ReferenceQueue();

        WeakReference weakReference = new WeakReference(object,referenceQueue);

        System.out.println(object);

        System.out.println(weakReference.get());

        System.out.println(referenceQueue.poll());

        System.gc();

        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(object);

        System.out.println(weakReference.get());

        System.out.println(referenceQueue.poll());


    }

}






