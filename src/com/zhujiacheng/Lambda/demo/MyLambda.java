package com.zhujiacheng.Lambda.demo;

import org.junit.Test;

/**
 * @Author Mr zhu
 * @Date 2020/8/25 10:02
 */
public class MyLambda {

    public static void main(String[] args) {

        Runnable noArguments = () -> System.out.println("Hello World");

        Runnable runnable = ()->{

            System.out.print("Hello"); System.out.println(" World");

        };

    }


    @Test
    public static void Test() {



    }



}
