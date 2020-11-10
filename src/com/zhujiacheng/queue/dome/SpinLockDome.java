package com.zhujiacheng.queue.dome;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/*
* 自旋锁的dome
* 优点:不会阻塞不用等待
* 缺点:如果一直匹配不带就会一直自旋，浪费cpu资源
* */
public class SpinLockDome {

    //原子引用默认值为null,因为里面放的是线程
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock() {

        Thread thread = Thread.currentThread();

        System.out.println(Thread.currentThread().getName() + "\t myLock ))");
        //如果期望值为null,就修改成thread
        while (!atomicReference.compareAndSet(null, thread)) {

        }

    }

    public void myUnLock() {

        Thread thread = Thread.currentThread();

        //解锁
        atomicReference.compareAndSet(thread,null);

        System.out.println(Thread.currentThread().getName() + "\t myUnLock ))");

    }


    public static void main(String[] args) {

        SpinLockDome spinLockDome = new SpinLockDome();

        new Thread(()->{

            spinLockDome.myLock();

            try {
                //暂停5秒
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            spinLockDome.myUnLock();

        },"AA").start();


        try {
            //暂停1秒
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{

            spinLockDome.myLock();

            spinLockDome.myUnLock();

        },"BB").start();

    }

}
