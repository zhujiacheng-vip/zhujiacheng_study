package com.zhujiacheng.Lambda.demo;

import org.junit.Test;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

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

        BinaryOperator<Long> add = (x, y) -> x + y;

    }


    @Test
    public static void Test() {

    }



}
