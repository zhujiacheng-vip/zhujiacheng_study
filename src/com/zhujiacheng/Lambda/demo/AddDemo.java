package com.zhujiacheng.Lambda.demo;

/**
 * @Author Mr zhu
 * @Date 2020/11/10 22:15
 */
public class AddDemo {

    public static void main(String[] args) {

     useAddavle((int a,int b)->{

         return a-b;

     });

         //省略模式
        useAddavle((a,b)->{

            return a-b;

        });

    }

    private static void useAddavle(Addable addable){

        int add = addable.add(5, 10);

        System.out.println(add);

    }

}
