package com.zhujiacheng.Lambda.demo;

/**
 * @Author Mr zhu
 * @Date 2020/11/10 22:05
 */
public class FlyableDemo {

    public static void main(String[] args) {

        //匿名内部类
        /*useFlyable(new Flyable() {
            @Override
            public void fly(String s) {
                System.out.println(s);
                System.out.println("我要上天");
            }
        });*/

        //lambda
        useFlyable((String s)->{

            System.out.println(s);

        });

        useFlyable(s->{

            System.out.println(s);

        });

    }


   private static void useFlyable(Flyable flyable){


        flyable.fly("我爱你");

   }

}
