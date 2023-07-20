package io.github.fengzaiyao.leetcode.力扣热题100.v5._10_回溯;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/generate-parentheses/

public class _05_括号生成 {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        doGenerate(ans, "", n, n);
        return ans;
    }

    public static void doGenerate(List<String> ans, String curr, int l, int r) {
        if (l == 0 && r == 0) {
            ans.add(curr);
            return;
        }
        if (l > 0) {
            doGenerate(ans, curr + "(", l - 1, r);
        }
        if (r > 0 && l < r) {
            doGenerate(ans, curr + ")", l, r - 1);
        }
    }
}
