package com.zhujiacheng.executor.dome;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class MyTread implements Runnable {


    @Override
    public void run() {

    }
}

class MyTread2 implements Callable {


    @Override
    public Integer call() throws Exception {

        TimeUnit.SECONDS.sleep(5);

        return 1024;

    }
}

/*
 * Callable带返回值，Runnable不带返回值
 *
 * */

public class CallableDemo {

    public static void main(String[] args) throws Exception{

        FutureTask<Integer> futureTask = new FutureTask<>(new MyTread2());

        //多个线程共用一个futureTask只会执行一次
        //如果想多次执行，就要多个futureTask
        new Thread(futureTask,"AAA").start();

        new Thread(futureTask,"BBB").start();

        futureTask.get();//一般放到左后，如果没有计算完成会造成阻塞,计算完成后返回

        //判断是否算完,取反
        while (!futureTask.isDone()){



        }

        System.out.println(futureTask.get(2,TimeUnit.SECONDS));

    }

}
