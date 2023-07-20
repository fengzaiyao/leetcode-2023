package io.github.fengzaiyao.leetcode.力扣热题100.v1._15_动态规划;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/pascals-triangle/

public class 杨辉三角 {

    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] dp = new int[numRows];
        dp[0] = 1;
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j >= 1; j--) {
                dp[j] = dp[j - 1] + dp[j];
            }
            // 插入结果
            List<Integer> retItem = new ArrayList<>();
            for (int k = 0; k < numRows; k++) {
                if (dp[k] == 0) {
                    continue;
                }
                retItem.add(dp[k]);
            }
            ans.add(retItem);
        }
        return ans;
    }
}
