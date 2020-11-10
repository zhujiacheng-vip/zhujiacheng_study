package com.zhujiacheng.dynamicproxy.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author Mr zhu
 * @Date 2020/9/20 20:12
 */
public class TestApp {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        HelloService helloService = new HelloServiceImp();

        Method helloZhuJiaCheng = helloService.getClass().getMethod("helloZhuJiaCheng", String.class);

        Object lisi = helloZhuJiaCheng.invoke(helloService, "李四");

    }

}
