package com.zhujiacheng.Lambda.demo;

/**
 * @Author Mr zhu
 * @Date 2020/11/16 22:32
 * lambda表达式使用注意事项
 */
public class InterDemo {

    public static void main(String[] args) {

        //使用lambdas必须要有接口，有且只有一个抽象方法
        useInter(()->

            System.out.println("我爱您啊")

        );

    }


    private static void useInter(Inter inter) {

        inter.show();

    }

}
