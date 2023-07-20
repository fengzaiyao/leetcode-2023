package io.github.fengzaiyao.leetcode.力扣热题100.v2._01_哈希;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.cn/problems/group-anagrams/?envType=study-plan-v2&id=top-100-liked

public class _02_字母异位词分组 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // 统计各个字符出现的次数
            int[] chars = new int[26];
            for (char ch : str.toCharArray()) {
                chars[ch - 'a']++;
            }
            // 构建唯一的key
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                builder.append((char) (i + 'a')).append(chars[i]);
            }
            // 加入 map
            String key = builder.toString();
            List<String> retItem = map.getOrDefault(key, new ArrayList<>());
            retItem.add(str);
            map.put(key, retItem);
        }
        return new ArrayList<>(map.values());
    }
}
