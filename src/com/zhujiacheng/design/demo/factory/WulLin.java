package com.zhujiacheng.design.demo.factory;

/**
 * @Author Mr zhu
 * @Date 2020/8/22 10:47
 */
public class WulLin implements Car{

    @Override
    public Car getCar() {
        return new WulLin();
    }
}
