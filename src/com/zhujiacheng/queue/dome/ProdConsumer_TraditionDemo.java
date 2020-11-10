package com.zhujiacheng.queue.dome;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareData {//资源类

    private int number = 0;

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    public void increment() throws Exception {

        lock.lock();
        try {
            //判断(不能用if)
            while (number != 0) {

                //等待不能生产
                condition.await();

            }
            //加1
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);

            //通知唤醒
            condition.signalAll();

        } catch (Exception e) {

        } finally {
            lock.unlock();
        }

    }


    public void delcrement() throws Exception {

        lock.lock();
        try {
            //判断（不能用）
            while (number == 0) {

                //等待不能生产
                condition.await();

            }
            //加1
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);

            //通知唤醒
            condition.signalAll();

        } catch (Exception e) {

        } finally {
            lock.unlock();
        }

    }


}

/*
 * 传统的生产者消费者模型
 *
 * 题目：一个初始值为0的变量，两个线程交替操作，一个加一个减，来5轮
 *
 * 1 线程操作资源类（一切皆对象）
 *
 * 2 判断  干活  通知
 *
 * 3 防止虚假唤醒(多线程的判断要用while，不能用if)
 *
 * 4 synchronized和lock有什么区别？用新的lock有什么好处
 * 1，synchronized是java关键字属于jvm层面
 *    monitorenter(底层通过monitor对象来完成，其wait/notifiy等方法也依赖于monitor对象只有在同步代码块或方法中才能调用wait和notify等方法)
 *    monitorexit
 *
 * 2. lock是具体类（java.util.concurrent.locks.lock）是API层面的锁
 *
 * 3. 等待是否可以中断
 *     synchronized不可中断，除非正常执行完或者抛异常
 *     Reentrantlock可中断 ，设置超时时间try lock(long timeout , TimeUtil unit)
 *                          lockInterruptibly()放代码块中，调用interrupt()方法可以中断
 * */
public class ProdConsumer_TraditionDemo {

    public static void main(String[] args) {

        ShareData shareData = new ShareData();

        new Thread(()->{

            for (int i = 0; i <5 ; i++) {

                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        },"AAA").start();

        new Thread(()->{

            for (int i = 0; i <5 ; i++) {

                try {
                    shareData.delcrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        },"BBB").start();


    }

}
