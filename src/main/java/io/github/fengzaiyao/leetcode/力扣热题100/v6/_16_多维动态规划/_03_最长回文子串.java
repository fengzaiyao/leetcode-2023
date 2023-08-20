package io.github.fengzaiyao.leetcode.力扣热题100.v6._16_多维动态规划;

// https://leetcode.cn/problems/longest-palindromic-substring/

public class _03_最长回文子串 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }

    public static String longestPalindrome(String s) {
        String ans = null;
        for (int i = 0; i < 2 * s.length() - 1; i++) {
            int l = i / 2;
            int r = (i % 2) + l;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (ans == null || ans.length() <= (r - l + 1)) {
                    ans = s.substring(l, r + 1);
                }
                l--;
                r++;
            }
        }
        return ans;
    }
}
