package io.github.fengzaiyao.leetcode.力扣热题100.v8._03_滑动窗口;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.cn/problems/find-all-anagrams-in-a-string/?envType=study-plan-v2&envId=top-100-liked

public class _02_找到字符串中所有字母异位词 {

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        int[] chs = new int[26];
        int[] chp = new int[26];
        for (char ch : p.toCharArray()) {
            chp[ch - 'a']++;
        }
        List<Integer> ans = new ArrayList<>();
        int r = 0;
        int l = 0;
        while (r < s.length()) {
            chs[s.charAt(r) - 'a']++;
            if (r + 1 >= p.length()) {
                if (Arrays.equals(chs, chp)) {
                    ans.add(l);
                }
                chs[s.charAt(l) - 'a']--;
                l++;
            }
            r++;
        }
        return ans;
    }
}
