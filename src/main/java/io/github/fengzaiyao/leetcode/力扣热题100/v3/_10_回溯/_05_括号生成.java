package io.github.fengzaiyao.leetcode.力扣热题100.v3._10_回溯;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/generate-parentheses/

public class _05_括号生成 {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        doPath(ans, "", n, n);
        return ans;
    }

    public static void doPath(List<String> ans, String path, int l, int r) {
        if (l == 0 && r == 0) {
            ans.add(path);
            return;
        }
        if (l > 0) {
            doPath(ans, path + "(", l - 1, r);
        }
        if (r > 0 && l < r) {
            doPath(ans, path + ")", l, r - 1);
        }
    }
}
