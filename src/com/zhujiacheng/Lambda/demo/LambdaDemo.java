package com.zhujiacheng.Lambda.demo;

/**
 * @Author Mr zhu
 * @Date 2020/11/9 22:12
 */
public class LambdaDemo{

    public static void main(String[] args) {

      /*  MyRunnable myRunnable = new MyRunnable();

        Thread thread = new Thread(myRunnable);

        thread.start();*/
        /*
        * 匿名内部类
        * */

       /* new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("多线程启动了");

            }
        }).start();*/

        //lambda表达式改进
        new Thread(()->{

            System.out.println("多线程启动了");

        }).start();



    }

}
