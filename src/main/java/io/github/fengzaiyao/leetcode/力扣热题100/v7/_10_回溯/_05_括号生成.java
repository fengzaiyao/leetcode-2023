package io.github.fengzaiyao.leetcode.力扣热题100.v7._10_回溯;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/generate-parentheses/

public class _05_括号生成 {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        doGenerateParenthesis(ans, "", n, n);
        return ans;
    }

    public void doGenerateParenthesis(List<String> ans, String string, int l, int r) {
        if (l == 0 && r == 0) {
            ans.add(string);
            return;
        }
        if (l > 0) {
            doGenerateParenthesis(ans, string + "(", l - 1, r);
        }
        if (r > 0 && r > l) {
            doGenerateParenthesis(ans, string + ")", l, r - 1);
        }
    }
}
