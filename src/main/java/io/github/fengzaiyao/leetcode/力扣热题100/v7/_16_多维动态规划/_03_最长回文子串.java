package io.github.fengzaiyao.leetcode.力扣热题100.v7._16_多维动态规划;

// https://leetcode.cn/problems/longest-palindromic-substring/

public class _03_最长回文子串 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }

    public static String longestPalindrome(String s) {
        String result = null;
        for (int len = 0; len < 2 * s.length() - 1; len++) {
            int l = len / 2;
            int r = l + (len % 2);
            while (l >= 0 && r <= s.length() - 1 && s.charAt(l) == s.charAt(r)) {
                if (result == null || result.length() < r - l + 1) {
                    result = s.substring(l, r + 1);
                }
                l--;
                r++;
            }
        }
        return result;
    }
}
