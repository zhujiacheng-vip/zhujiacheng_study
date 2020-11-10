package com.zhujiacheng.jvmError.dome;

import sun.misc.VM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Mr zhu
 * @Date 2020/8/23 20:15
 */
public class OutOfMemeoryErrorDemo {

    public static void main(String[] args) {

        //查看最大可用内存的大小
        long l = VM.maxDirectMemory()/1024/1024/1024;

        System.out.println(l);

      /*  int i =0;

        List<String> list = new ArrayList<>();

        try {
            while (true){

                list.add(String.valueOf(i).intern());

            }
        } catch (Exception e) {
            System.out.println("**************i:"+i);
            e.printStackTrace();

            throw e;

        }
*/
    }

}
