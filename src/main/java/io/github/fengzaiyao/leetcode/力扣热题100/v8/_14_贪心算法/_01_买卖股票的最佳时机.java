package io.github.fengzaiyao.leetcode.力扣热题100.v8._14_贪心算法;

// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/?envType=study-plan-v2&id=top-100-liked

public class _01_买卖股票的最佳时机 {

    public int maxProfit(int[] prices) {
        int max = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(prices[i], minPrice);
            max = Math.max(max, prices[i] - minPrice);
        }
        return max;
    }
}
