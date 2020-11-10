package com.zhujiacheng.jvmError.dome;

/**
 * @Author Mr zhu
 * @Date 2020/8/23 20:02
 */
public class StackOverflowErrorDemo {

    public static void main(String[] args) {

        //1024kb
        StackOverflowError();
        
    }

    //递归调用
    public static void StackOverflowError() {

        StackOverflowError();

    }

}
