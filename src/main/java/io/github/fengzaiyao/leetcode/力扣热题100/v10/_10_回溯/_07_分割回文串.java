package io.github.fengzaiyao.leetcode.力扣热题100.v10._10_回溯;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/palindrome-partitioning/?envType=study-plan-v2&id=top-100-liked

public class _07_分割回文串 {

    public static void main(String[] args) {
        _07_分割回文串 test = new _07_分割回文串();
        System.out.println(test.partition("aab"));
    }

    public List<List<String>> partition(String s) {
        if ("".equals(s)) {
            return new ArrayList<>();
        }
        List<List<String>> ans = new ArrayList<>();
        doPartition(ans, new ArrayList<>(), s, 0);
        return ans;
    }

    public void doPartition(List<List<String>> ans, List<String> path, String s, int begin) {
        if (begin == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 1; i + begin <= s.length(); i++) {
            String substring = s.substring(begin, begin + i);
            if (!isHuiWen(substring)) {
                continue;
            }
            path.add(substring);
            doPartition(ans, path, s, begin + i);
            path.remove(path.size() - 1);
        }
    }

    private boolean isHuiWen(String substring) {
        int l = 0;
        int r = substring.length() - 1;
        while (l < r) {
            if (substring.charAt(l) != substring.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
