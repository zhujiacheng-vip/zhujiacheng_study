package com.zhujiacheng.design.demo.factory;

/**
 * @Author Mr zhu
 * @Date 2020/8/22 10:49
 */
public class Consumer {

    public static void main(String[] args) {

        Car car = new Tesila();

        System.out.println(car);

        Car car1 = new WulLin();

        System.out.println(car1);


    }

}
