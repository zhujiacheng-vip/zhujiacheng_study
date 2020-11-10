package com.zhujiacheng.collection.dome;

/**
 * @Author Mr zhu
 * @Date 2020/9/1 16:57
 */
public class MaxMeony {


/*
    假设你有一个数组，其中第 i\i i 个元素是股票在第i\ii 天的价格。你有一次买入和卖出的机会。（只有买入了股票以后才能卖出）。请你设计一个算法来计算可以获得的最大收益。
*/

    public int maxProfit(int[] prices){

        //判断数组是否为空
        if(prices==null||prices.length==0){

            return 0;

        }

        //定义一个最大利润的变量，默认从第一天开始开始买入
        int profit = 0, buy = prices[0];

        for (int i = 0; i < prices.length; i++) {

            //买入和整个数组价格最低的差价最小的
            int min = Math.min(buy, prices[i]);

            //利润和数组价格最高的差价最大的
            profit = Math.max(profit, prices[i]-min);

        }

        //返回最大利润
        return profit;

    }

}
