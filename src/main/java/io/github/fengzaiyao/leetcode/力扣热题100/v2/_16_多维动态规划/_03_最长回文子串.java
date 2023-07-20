package io.github.fengzaiyao.leetcode.力扣热题100.v2._16_多维动态规划;

// https://leetcode.cn/problems/longest-palindromic-substring/

public class _03_最长回文子串 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }

    public static String longestPalindrome(String s) {
        int ans_l = -1;
        int ans_r = -1;
        for (int center = 0; center < 2 * s.length() - 1; center++) {
            int l = center / 2;
            int r = l + (center % 2);
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l >= ans_r - ans_l) {
                    ans_l = l;
                    ans_r = r;
                }
                l--;
                r++;
            }
        }
        return s.substring(ans_l, ans_r + 1);
    }
}
