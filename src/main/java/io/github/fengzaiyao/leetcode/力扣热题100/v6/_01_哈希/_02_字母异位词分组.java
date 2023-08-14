package io.github.fengzaiyao.leetcode.力扣热题100.v6._01_哈希;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

// https://leetcode.cn/problems/group-anagrams/?envType=study-plan-v2&id=top-100-liked

public class _02_字母异位词分组 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // 统计字符出现的次数
            int[] chsNum = new int[26];
            for (char ch : str.toCharArray()) {
                chsNum[ch - 'a']++;
            }
            // 拼接key
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < chsNum.length; i++) {
                builder.append(i + 'a').append(chsNum[i]);
            }
            // 放入对应list
            String key = builder.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}
