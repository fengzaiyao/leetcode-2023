package io.github.fengzaiyao.leetcode.力扣热题100.v4._10_回溯;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/palindrome-partitioning/?envType=study-plan-v2&id=top-100-liked

public class _07_分割回文串 {

    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        doPartition(s, ans, new ArrayList<>(), 0);
        return ans;
    }

    public static void doPartition(String s, List<List<String>> ans, List<String> path, int begin) {
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
            doPartition(s, ans, path, begin + len);
            path.remove(path.size() - 1);
        }
    }

    public static boolean isHuiWen(String str) {
        int l = 0;
        int r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
