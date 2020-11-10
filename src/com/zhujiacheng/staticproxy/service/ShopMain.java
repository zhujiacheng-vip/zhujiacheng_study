package com.zhujiacheng.staticproxy.service;

/**
 * @Author Mr zhu
 * @Date 2020/9/20 19:59
 *
 * 代理类
 */
public class ShopMain {

    public static void main(String[] args) {

        TaoBao taoBao = new TaoBao();

        float sell = taoBao.Sell(1);

        System.out.println(sell);

    }

}
