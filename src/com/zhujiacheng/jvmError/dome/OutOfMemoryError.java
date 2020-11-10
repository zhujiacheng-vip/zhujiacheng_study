package com.zhujiacheng.jvmError.dome;

import java.util.Random;

/**
 * @Author Mr zhu
 * @Date 2020/8/23 20:08
 * GC回收的太少，毫无意义，所以就会报Error
 */
public class OutOfMemoryError {

    public static void main(String[] args) {

        String a = "zhujiacheng";
       //先配置堆的大小为10mb
        while (true){

            a +=a+ new Random().nextInt(111111)+new Random(222);

        }


    }

}
