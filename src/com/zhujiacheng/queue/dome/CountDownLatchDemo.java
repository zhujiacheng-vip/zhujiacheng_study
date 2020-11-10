package com.zhujiacheng.queue.dome;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) throws Exception{

        //参数一定要跟线程的数量一致要不就一直阻塞
        CountDownLatch countDownLatch = new CountDownLatch(4);

        for (int i = 1; i < 5; i++) {

            new Thread(() -> {

                System.out.println(Thread.currentThread().getName() + "\t国，被灭了");

                countDownLatch.countDown();
                /*
                * 这里一定要跟枚举的个数一样，要不会报空指针
                * */
            },CountryEnum.forEach_CountryEnum(i).getReMessage()).start();

        }

        countDownLatch.await();

        System.out.println(Thread.currentThread().getName() + "=======秦国统一了");

    }


    public static void closeDoor() throws Exception{

        //参数一定要跟线程的数量一致要不就一直阻塞
        CountDownLatch countDownLatch = new CountDownLatch(5);

        for (int i = 0; i < 5; i++) {

            new Thread(() -> {

                System.out.println(Thread.currentThread().getName() + "\t上完自习，离开教室");

                countDownLatch.countDown();

            }, String.valueOf(i)).start();

        }

        countDownLatch.await();

        System.out.println(Thread.currentThread().getName() + "班长走了");

    }

}
