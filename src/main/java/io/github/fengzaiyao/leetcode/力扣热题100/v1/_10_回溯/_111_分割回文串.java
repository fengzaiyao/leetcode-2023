package io.github.fengzaiyao.leetcode.力扣热题100.v1._10_回溯;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/palindrome-partitioning/?envType=study-plan-v2&id=top-100-liked

public class _111_分割回文串 {

    public static void main(String[] args) {
        _111_分割回文串 test = new _111_分割回文串();
        System.out.println(test.partition("aab"));
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        doPartition(result, new ArrayList<>(), 0, s);
        return result;
    }

    public void doPartition(List<List<String>> result, List<String> path, Integer start, String s) {
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int len = 1; start + len <= s.length(); len++) {
            // start + len 代表此次截取字符串的 end，同时也是下一个递归的 start
            String substr = s.substring(start, start + len);
            if (!isHuiWen(substr)) {
                continue;
            }
            path.add(substr);
            doPartition(result, path, start + len, s);
            path.remove(path.size() - 1);
        }
    }

    public boolean isHuiWen(String string) {
        int l = 0;
        int r = string.length() - 1;
        while (l < r) {
            if (string.charAt(l++) != string.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}
