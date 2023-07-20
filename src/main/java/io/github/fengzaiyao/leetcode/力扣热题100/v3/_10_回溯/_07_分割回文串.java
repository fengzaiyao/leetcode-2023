package io.github.fengzaiyao.leetcode.力扣热题100.v3._10_回溯;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/palindrome-partitioning/?envType=study-plan-v2&id=top-100-liked

public class _07_分割回文串 {

    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        doPath(ans, new ArrayList<>(), 0, s);
        return ans;
    }

    public static void doPath(List<List<String>> ans, List<String> path, int start, String s) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int len = 1; start + len <= s.length(); len++) {
            String substring = s.substring(start, start + len);
            if (!isHuiWen(substring)) {
                continue;
            }
            path.add(substring);
            doPath(ans, path, start + len, s);
            path.remove(path.size() - 1);
        }
    }

    private static boolean isHuiWen(String text) {
        int l = 0;
        int r = text.length() - 1;
        while (l < r) {
            if (text.charAt(l) != text.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
