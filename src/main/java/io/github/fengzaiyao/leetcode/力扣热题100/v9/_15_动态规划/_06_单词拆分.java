package io.github.fengzaiyao.leetcode.力扣热题100.v9._15_动态规划;

import java.util.Arrays;
import java.util.List;

// https://leetcode.cn/problems/word-break/

public class _06_单词拆分 {

    public static void main(String[] args) {
        System.out.println(wordBreak("applepenapple", Arrays.asList("apple", "pen")));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean dp[] = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                int wLen = word.length();
                if (i >= wLen && word.equals(s.substring(i - wLen, i))) {
                    dp[i] = dp[i] || dp[i - wLen];
                }
            }
        }
        return dp[len];
    }
}
