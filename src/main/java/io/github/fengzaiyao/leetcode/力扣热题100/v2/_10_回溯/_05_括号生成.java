package io.github.fengzaiyao.leetcode.力扣热题100.v2._10_回溯;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/generate-parentheses/

public class _05_括号生成 {

    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        doGenerate(ret, n, n, "");
        return ret;
    }

    public void doGenerate(List<String> ret, int l, int r, String string) {
        if (l == 0 && r == 0) {
            ret.add(string);
            return;
        }
        if (l > 0) {
            doGenerate(ret, l - 1, r, string + "(");
        }
        if (r > 0 && l < r) {
            doGenerate(ret, l, r - 1, string + ")");
        }
    }
}
