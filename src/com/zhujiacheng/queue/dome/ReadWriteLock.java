package com.zhujiacheng.queue.dome;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//写个缓存的demo
class MyCache{//资源类

 private volatile Map<String,Object> map = new HashMap<>();

 //读写锁是一起的，里面的api会分成read锁和write锁
 private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

 //加lock也可以解决但是效率太低了
 //private Lock lock = new ReentrantLock();
    //写
    public void put(String key , Object value){

        rwLock.writeLock().lock();
        try {

            System.out.println(Thread.currentThread().getName()+"\t正在写入"+key);

            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            map.put(key,value);

            System.out.println(Thread.currentThread().getName()+"\t写入完成");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwLock.writeLock().unlock();
        }


    }

    //读
    public void get(String key){

        rwLock.readLock().lock();
        try {

            System.out.println(Thread.currentThread().getName()+"\t正在读取");

            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Object o = map.get(key);

            System.out.println(Thread.currentThread().getName()+"\t读完成"+o);


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwLock.readLock().unlock();
        }

    }

}

/*
* 读写锁，
* 读锁是可以共享的（共享锁）
* 写锁是互斥的（互斥锁）
* 写操作：原子+独占，整个过程必须是一个完整的过程
* */
public class ReadWriteLock {

    public static void main(String[] args) {

     MyCache myCache = new MyCache();

        for (int i = 1; i < 6; i++) {

            final int tempInt = i;

            new Thread(()->{
                //写
                myCache.put(tempInt+"",tempInt+"");

            },String.valueOf(i)).start();

        }

        for (int i = 1; i < 6; i++) {

            final int tempInt = i;

            new Thread(()->{
                //读
                myCache.get(tempInt+"");

            },String.valueOf(i)).start();

        }


    }

}
