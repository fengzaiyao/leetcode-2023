package io.github.fengzaiyao.leetcode.力扣热题100.v1._10_回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// https://leetcode.cn/problems/letter-combinations-of-a-phone-number/?envType=study-plan-v2&id=top-100-liked

public class 电话号码的字母组合 {

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
        List<String> result = new ArrayList<>();
        doLetterCombinations(digits, result, new ArrayList<>(), 0);
        return result;
    }

    public void doLetterCombinations(String digits, List<String> result, List<Character> path, int begin) {
        if (begin == digits.length()) {
            // char 数组转化为 String
            char[] chs = new char[path.size()];
            for (int i = 0; i < path.size(); i++) {
                chs[i] = path.get(i);
            }
            result.add(new String(chs));
            return;
        }
        List<Character> chs = map.get(digits.charAt(begin));
        for (Character ch : chs) {
            path.add(ch);
            doLetterCombinations(digits, result, path, begin + 1);
            path.remove(path.size() - 1);
        }
    }
}
