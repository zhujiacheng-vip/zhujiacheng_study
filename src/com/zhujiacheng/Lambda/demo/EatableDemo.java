package com.zhujiacheng.Lambda.demo;

/**
 * @Author Mr zhu
 * @Date 2020/11/9 23:00
 */
public class EatableDemo {

    public static void main(String[] args) {

        //匿名内部类
      /*  useEtable(new Eatable() {
            @Override
            public void eat() {
                System.out.println("一天一苹果一次少个我");
            }
        });*/


        //lambda表达式
        useEtable(()->{

            System.out.println("一天一苹果一天少个我");

        });

    }

    private static void  useEtable(Eatable e){

        e.eat();

    }


}
