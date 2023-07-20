package io.github.fengzaiyao.leetcode.力扣热题100.v3._16_多维动态规划;

// https://leetcode.cn/problems/longest-palindromic-substring/?envType=study-plan-v2&envId=top-100-liked

public class _03_最长回文子串 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }

    public static String longestPalindrome(String s) {
        int ansL = -1;
        int ansR = -1;
        for (int len = 0; len < s.length() * 2 - 1; len++) {
            int l = len / 2;
            int r = l + (len % 2);
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l >= ansR - ansL) {
                    ansL = l;
                    ansR = r;
                }
                l--;
                r++;
            }
        }
        return s.substring(ansL, ansR - 1);
    }
}
