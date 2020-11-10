package com.zhujiacheng.collection.dome;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author Mr zhu
 * @Date 2020/8/24 15:10
 */
public class MyTest {

    public static void main(String[] args) {

        String[] arr = {"曾","校","进","曾"};

        Map<String, Integer> map = new HashMap<>();

        Set set = new HashSet();

        Integer num = 1;

        for (int i = 0; i < arr.length; i++) {

                if(set.contains(arr[i])){

                    Integer integer = map.get(arr[i]);

                    integer++;

                    map.put(arr[i],integer);

                }else if(!set.contains(arr[i])){

                    set.add(arr[i]);

                  map.put(arr[i],num);

                }


        }


        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()){

            Map.Entry<String, Integer> next = iterator.next();

            System.out.println("key==="+next.getKey()+"=====value======"+next.getValue());

        }

    }

}
