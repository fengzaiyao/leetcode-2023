package io.github.fengzaiyao.leetcode.力扣热题100.v7._14_贪心算法;

// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/?envType=study-plan-v2&id=top-100-liked

public class _01_买卖股票的最佳时机 {

    public int maxProfit(int[] prices) {
        int maxSum = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxSum = Math.max(maxSum, prices[i] - minPrice);
        }
        return maxSum;
    }
}
