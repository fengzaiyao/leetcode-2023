package io.github.fengzaiyao.leetcode.力扣热题100.v7._01_哈希;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.cn/problems/group-anagrams/?envType=study-plan-v2&id=top-100-liked

public class _02_字母异位词分组 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // 拼接key
            int[] chs = new int[26];
            for (char ch : str.toCharArray()) {
                chs[ch - 'a']++;
            }
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < chs.length; i++) {
                builder.append((char) (i + 'a')).append(chs[i]);
            }
            // 找到对应key所在的list
            String key = builder.toString();
            List<String> stringArr = map.getOrDefault(key, new ArrayList<>());
            stringArr.add(str);
            map.put(key, stringArr);
        }
        return new ArrayList<>(map.values());
    }
}
