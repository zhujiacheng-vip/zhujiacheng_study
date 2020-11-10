package com.zhujiacheng.collection.dome;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Mr zhu
 * @Date 2020/9/2 9:03
 * 单例模式
 */
public class TestDemo {

    public static void changeStr(String str) {

        str += "是百年老店";

    }

    public static void main(String[] args) throws InterruptedException {

        String str = "吉祥航空";

        changeStr(str);

        System.out.println(str);

        List<String> list = new ArrayList<>();

        list.add("欢迎您");

        changeList(list);

        list.forEach(l -> {

            System.out.println(l);

        });

        Thread.sleep(Integer.MAX_VALUE);

    }


    public static void changeList(List<String> list) {

        int len = 2;

        int i =0;

        try {
            for (;i<len;i++){

                list.set(i,"欢迎您的到来");

            }
        } catch (Exception e) {

            list.add("HVC HO");

            System.out.println("经营理念");

            e.printStackTrace();
        } finally {

            System.out.println("百年老店");

            list.add("高价值航空公司");

        }


    }



}
