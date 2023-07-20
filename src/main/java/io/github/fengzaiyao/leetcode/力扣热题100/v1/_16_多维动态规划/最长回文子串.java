package io.github.fengzaiyao.leetcode.力扣热题100.v1._16_多维动态规划;

// https://leetcode.cn/problems/longest-palindromic-substring/

public class 最长回文子串 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }

    public static String longestPalindrome(String s) {
        int ans_l = 0;
        int ans_r = 0;
        for (int center = 0; center < 2 * s.length() - 1; center++) {
            int l = center / 2;
            int r = l + center % 2;
            while (l >= 0 && r <= s.length() - 1 && s.charAt(l) == s.charAt(r)) {
                // 如果大于当前最大的回文长度
                if ((r - l + 1) > (ans_r - ans_l + 1)) {
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
