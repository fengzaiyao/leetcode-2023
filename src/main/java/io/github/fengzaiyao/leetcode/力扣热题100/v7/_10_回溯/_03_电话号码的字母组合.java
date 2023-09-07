package io.github.fengzaiyao.leetcode.力扣热题100.v7._10_回溯;

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
        if ("".equals(digits)) {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        doLetter(ans, new StringBuilder(), 0, digits);
        return ans;
    }

    public void doLetter(List<String> ans, StringBuilder path, int begin, String digits) {
        if (begin == digits.length()) {
            ans.add(path.toString());
            return;
        }
        List<Character> chs = map.get(digits.charAt(begin));
        for (Character ch : chs) {
            path.append(ch);
            doLetter(ans, path, begin + 1, digits);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
