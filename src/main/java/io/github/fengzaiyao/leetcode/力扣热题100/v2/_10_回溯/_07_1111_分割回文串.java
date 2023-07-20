package io.github.fengzaiyao.leetcode.力扣热题100.v2._10_回溯;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/palindrome-partitioning/?envType=study-plan-v2&id=top-100-liked

public class _07_1111_分割回文串 {

    public static void main(String[] args) {
        _07_1111_分割回文串 test = new _07_1111_分割回文串();
        System.out.println(test.partition("aab"));
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ret = new ArrayList<>();
        doPartition(s, ret, new ArrayList<>(), 0);
        return ret;
    }

    public void doPartition(String s, List<List<String>> ret, List<String> path, int begin) {
        if (begin == s.length()) {
            ret.add(new ArrayList<>(path));
            return;
        }
        for (int len = 1; begin + len <= s.length(); len++) {
            String substring = s.substring(begin, begin + len);
            if (isHuiWen(substring)) {
                path.add(substring);
                doPartition(s, ret, path, begin + len);
                path.remove(path.size() - 1);
            }
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
