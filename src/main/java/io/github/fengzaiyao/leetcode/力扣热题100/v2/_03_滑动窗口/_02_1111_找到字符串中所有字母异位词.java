package io.github.fengzaiyao.leetcode.力扣热题100.v2._03_滑动窗口;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _02_1111_找到字符串中所有字母异位词 {

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd","abc"));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] sArr = new int[26];
        int[] pArr = new int[26];
        for (char ch : p.toCharArray()) {
            pArr[ch - 'a']++;
        }
        int l = 0;
        int r = 0;
        while (r < s.length()) {
            sArr[s.charAt(r) - 'a']++;
            if (r - l + 1 >= p.length()) {
                if (Arrays.equals(sArr, pArr)) {
                    ans.add(l);
                }
                sArr[s.charAt(l) - 'a']--;
                l++;
            }
            r++;
        }
        return ans;
    }
}
