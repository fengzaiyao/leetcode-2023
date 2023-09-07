package io.github.fengzaiyao.leetcode.力扣热题100.v7._10_回溯;

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
        for (int len = 1; begin + len <= s.length(); len++) {
            String substring = s.substring(begin, begin + len);
            if (!isHuiWen(substring)) {
                continue;
            }
            path.add(substring);
            doPartition(ans, path, s, begin + len);
            path.remove(path.size() - 1);
        }
    }

    private boolean isHuiWen(String string) {
        int l = 0;
        int r = string.length() - 1;
        while (l < r) {
            if (string.charAt(l) != string.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
