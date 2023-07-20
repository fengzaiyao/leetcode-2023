package io.github.fengzaiyao.leetcode.力扣热题100.v3._10_回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// https://leetcode.cn/problems/letter-combinations-of-a-phone-number/?envType=study-plan-v2&id=top-100-liked

public class _03_电话号码的字母组合 {

    private static HashMap<Character, List<Character>> map = new HashMap<>();

    static {
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if ("".equals(digits)) {
            return ans;
        }
        doPath(digits, 0, new StringBuilder(), ans);
        return ans;
    }

    public void doPath(String digits, int start, StringBuilder builder, List<String> ans) {
        if (start == digits.length()) {
            ans.add(builder.toString());
            return;
        }
        List<Character> chs = map.get(digits.charAt(start));
        for (Character ch : chs) {
            builder.append(ch);
            doPath(digits, start + 1, builder, ans);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
