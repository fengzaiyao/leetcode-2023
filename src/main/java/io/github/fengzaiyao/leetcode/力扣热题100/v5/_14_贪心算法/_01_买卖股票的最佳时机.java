package io.github.fengzaiyao.leetcode.力扣热题100.v5._14_贪心算法;

// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/?envType=study-plan-v2&id=top-100-liked

public class _01_买卖股票的最佳时机 {

    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return max;
    }
}
