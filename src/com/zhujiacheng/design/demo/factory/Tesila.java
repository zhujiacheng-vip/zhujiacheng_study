package com.zhujiacheng.design.demo.factory;

/**
 * @Author Mr zhu
 * @Date 2020/8/22 10:46
 */
public class Tesila implements Car{


    @Override
    public Car getCar() {
        return new Tesila();
    }
}
