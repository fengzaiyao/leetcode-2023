package io.github.fengzaiyao.leetcode.力扣热题100.v1._10_回溯;

// https://leetcode.cn/problems/generate-parentheses/?envType=study-plan-v2&id=top-100-liked

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/generate-parentheses/?envType=study-plan-v2&id=top-100-liked

public class 括号生成 {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        doGenerateParenthesis(result, "", n, n);
        return result;
    }

    private static void doGenerateParenthesis(List<String> result, String str, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(str);
        }
        if (left > 0) {
            doGenerateParenthesis(result, str + "(", left - 1, right);
        }
        if (right > 0 && left < right) {
            doGenerateParenthesis(result, str + ")", left, right - 1);
        }
    }
}
