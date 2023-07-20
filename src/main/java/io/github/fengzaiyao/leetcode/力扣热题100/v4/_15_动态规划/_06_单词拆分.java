package io.github.fengzaiyao.leetcode.力扣热题100.v4._15_动态规划;

import java.util.Arrays;
import java.util.List;

// https://leetcode.cn/problems/word-break/

public class _06_单词拆分 {

    public static void main(String[] args) {
        System.out.println(wordBreak("applepenapple", Arrays.asList("apple", "pen")));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                if (i >= word.length() && word.equals(s.substring(i - word.length(), i))) {
                    dp[i] = dp[i] || dp[i - word.length()];
                }
            }
        }
        return dp[s.length()];
    }
}
