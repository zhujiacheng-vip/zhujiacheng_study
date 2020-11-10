package com.zhujiacheng.collection.dome;


import org.junit.Test;
import sun.applet.AppletClassLoader;


import java.sql.Connection;
import java.util.*;
import java.util.concurrent.*;

public class CollectionDemoTest {

    public static void main(String[] args) {
        
        String s = new String();

        s.split(",");

        BlockingQueue blockingQueue = new LinkedBlockingQueue<Runnable>(10);

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        /*Vector vector = new Vector(100);*/

      /*  Set set = new HashSet();*/

        /*List<String> list = new LinkedList<>();*/

        List list = new ArrayList();

       /*List list = new CopyOnWriteArrayList();*/

        /*Map map = new HashMap();*/

       //写时复制
       /*Set set = new CopyOnWriteArraySet();*/

        Map map = new ConcurrentHashMap();

       /* List list = Collections.unmodifiableList(list1);*/

        for (int i = 1; i < 10; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(1, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();

        }

/*

        list.forEach(string -> {

            System.out.println(string);

        });

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("用时" + System.currentTimeMillis() + "秒");
*/


    }


}
