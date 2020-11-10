package com.zhujiacheng.collection.dome;

/**
 * @Author Mr zhu
 * @Date 2020/9/1 16:48
 * 找出数组里面最大的数
 */
public class MaxNumber {

    public static void main(String[] args) {

       int[] arr  = {1, 4, 2,6};

        int tong = 0;

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j <arr.length-1 ; j++) {

                if(arr[i]>arr[j]){

                    arr[j] = arr[i];

                    tong = arr[j];

                    arr[i] = tong;

                }

            }

        }

        System.out.println(tong);

    }

}
