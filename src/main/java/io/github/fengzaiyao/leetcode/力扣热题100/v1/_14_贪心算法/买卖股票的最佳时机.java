package io.github.fengzaiyao.leetcode.力扣热题100.v1._14_贪心算法;

// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/?envType=study-plan-v2&id=top-100-liked

public class 买卖股票的最佳时机 {

    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxVal = 0;
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxVal = Math.max(maxVal, prices[i] - minPrice);
        }
        return maxVal;
    }
}
