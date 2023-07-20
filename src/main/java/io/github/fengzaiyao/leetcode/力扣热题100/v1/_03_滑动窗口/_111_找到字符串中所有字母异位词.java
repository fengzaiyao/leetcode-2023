package io.github.fengzaiyao.leetcode.力扣热题100.v1._03_滑动窗口;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.cn/problems/find-all-anagrams-in-a-string/submissions/

public class _111_找到字符串中所有字母异位词 {

    public static void main(String[] args) {
        List<Integer> result = findAnagrams("cbaebabacd", "abc");
        System.out.println(result);
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] ch_s = new int[26];
        int[] ch_p = new int[26];
        for (char ch : p.toCharArray()) {
            ch_p[ch - 'a']++;
        }
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            ch_s[s.charAt(right) - 'a']++;
            if (right - left + 1 == p.length()) {
                // 出现的次数完全一样才可以！！！
                if (Arrays.equals(ch_s, ch_p)) {
                    result.add(left);
                }
                ch_s[s.charAt(left) - 'a']--;
                left++;
            }
            right++;
        }
        return result;
    }
}
