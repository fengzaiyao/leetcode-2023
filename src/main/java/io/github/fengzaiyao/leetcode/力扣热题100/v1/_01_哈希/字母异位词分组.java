package io.github.fengzaiyao.leetcode.力扣热题100.v1._01_哈希;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.cn/problems/group-anagrams/?envType=study-plan-v2&id=top-100-liked

public class 字母异位词分组 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> retMap = new HashMap<>();
        for (String str : strs) {
            // 1、计算key，例如 "arrc" => "a1r2c1"
            int[] chars = new int[26];
            for (char ch : str.toCharArray()) {
                chars[ch - 'a']++;
            }
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                builder.append((char) (i + 'a')).append(chars[i]);
            }
            // 2、放入对应map的list
            String key = builder.toString();
            List<String> retItemList = retMap.getOrDefault(key, new ArrayList<>());
            retItemList.add(str);
            retMap.put(key, retItemList);
        }
        return new ArrayList<>(retMap.values());
    }
}
