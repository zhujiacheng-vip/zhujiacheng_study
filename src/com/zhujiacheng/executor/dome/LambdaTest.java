package com.zhujiacheng.executor.dome;


import java.util.Collection;
import java.util.concurrent.TimeUnit;

class LoadLock implements Runnable{

    private String lockA;

    private String lockB;

    public LoadLock(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {

        synchronized (lockA){

            System.out.println(Thread.currentThread().getName()+"我是锁A"+lockA+"我要获取锁B"+lockB);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lockB){

                System.out.println(Thread.currentThread().getName()+"我是锁B"+lockB+"我要获取锁A"+lockA);

            }

        }


    }
}

public class    LambdaTest {

    public static void main(String[] args) {

        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new LoadLock(lockA,lockB),"AAA").start();

        new Thread(new LoadLock(lockB,lockA),"BBB").start();

    }

}