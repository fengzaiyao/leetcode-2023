package io.github.fengzaiyao.leetcode.力扣热题100.v6._03_滑动窗口;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.cn/problems/find-all-anagrams-in-a-string/?envType=study-plan-v2&envId=top-100-liked

public class _02_找到字符串中所有字母异位词 {

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        int[] s_num = new int[26];
        int[] p_num = new int[26];
        for (char ch : p.toCharArray()) {
            p_num[ch - 'a']++;
        }
        List<Integer> ans = new ArrayList<>();
        int l = 0;
        int r = 0;
        while (r < s.length()) {
            s_num[s.charAt(r) - 'a']++;
            if (r + 1 >= p.length()) {
                if (Arrays.equals(s_num, p_num)) {
                    ans.add(l);
                }
                s_num[s.charAt(l) - 'a']--;
                l++;
            }
            r++;
        }
        return ans;
    }
}
