package com.zhujiacheng.GC;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Mr zhu
 * @Date 2020/9/10 18:48
 */
/*
* GC的Demo
*
* */
public class demo {

    public static void main(String[] args) {

       List list = new ArrayList();

       list.add("qq");

        for (int i = 0; i < list.size(); i++) {

            System.out.println("::");

        }

    }

}
