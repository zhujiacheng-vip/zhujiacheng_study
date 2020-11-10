package com.zhujiacheng.staticproxy.service;

/**
 * @Author Mr zhu
 * @Date 2020/9/20 19:57
 */
public class TaoBao implements UsbSell{

    private UsbKingFatory usbKingFatory = new UsbKingFatory();

    @Override
    public float Sell(int count) {

        float sell = usbKingFatory.Sell(2);

        return sell+20;
    }
}
