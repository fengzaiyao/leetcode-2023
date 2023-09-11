package io.github.fengzaiyao.leetcode.力扣热题100.v7._03_滑动窗口;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.cn/problems/find-all-anagrams-in-a-string/?envType=study-plan-v2&envId=top-100-liked

public class _02_111_找到字符串中所有字母异位词 {

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] arrS = new int[26];
        int[] arrP = new int[26];
        for (char ch : p.toCharArray()) {
            arrP[ch - 'a']++;
        }
        int l = 0;
        int r = 0;
        while (r < s.length()) {
            arrS[s.charAt(r) - 'a']++;
            if (r + 1 >= p.length()) {
                if (Arrays.equals(arrS, arrP)) {
                    ans.add(l);
                }
                arrS[s.charAt(l) - 'a']--;
                l++;
            }
            r++;
        }
        System.out.println(Arrays.toString(arrS));
        System.out.println(Arrays.toString(arrP));
        return ans;
    }
}
