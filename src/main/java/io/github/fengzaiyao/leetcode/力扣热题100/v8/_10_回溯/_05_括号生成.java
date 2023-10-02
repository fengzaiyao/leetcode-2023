package io.github.fengzaiyao.leetcode.力扣热题100.v8._10_回溯;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/generate-parentheses/

public class _05_括号生成 {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        doGenerate(ans, "", n, n);
        return ans;
    }

    public void doGenerate(List<String> ans, String path, int l, int r) {
        if (l == 0 && r == 0) {
            ans.add(path);
            return;
        }
        if (l > 0) {
            doGenerate(ans, path + "(", l - 1, r);
        }
        if (r > 0 && l < r) {
            doGenerate(ans, path + ")", l, r - 1);
        }
    }
}
