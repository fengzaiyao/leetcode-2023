package io.github.fengzaiyao.leetcode.力扣热题100.v10._10_回溯;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/generate-parentheses/

public class _05_括号生成 {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        doGenerate(n, n, ans, "");
        return ans;
    }

    public void doGenerate(int l, int r, List<String> ans, String path) {
        if (l == 0 && r == 0) {
            ans.add(path);
            return;
        }
        if (l > 0) {
            doGenerate(l - 1, r, ans, path + "(");
        }
        if (l < r && r > 0) {
            doGenerate(l, r - 1, ans, path + ")");
        }
    }
}
