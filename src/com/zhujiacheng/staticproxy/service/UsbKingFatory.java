package com.zhujiacheng.staticproxy.service;

/**
 * @Author Mr zhu
 * @Date 2020/9/20 19:54
 */
public class UsbKingFatory implements UsbSell{
    @Override
    public float Sell(int count) {
        return 50*count;
    }
}
