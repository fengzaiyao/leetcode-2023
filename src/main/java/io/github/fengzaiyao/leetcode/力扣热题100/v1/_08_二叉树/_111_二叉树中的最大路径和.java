package io.github.fengzaiyao.leetcode.力扣热题100.v1._08_二叉树;

import io.github.fengzaiyao.leetcode.model.TreeNode;

// https://leetcode.cn/problems/binary-tree-maximum-path-sum/?envType=study-plan-v2&id=top-100-liked

public class _111_二叉树中的最大路径和 {

    private Integer maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        doPathSum(root);
        return maxSum;
    }

    public int doPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l_sum = Math.max(0, doPathSum(root.left));
        int r_sum = Math.max(0, doPathSum(root.right));
        maxSum = Math.max(maxSum, l_sum + r_sum + root.val);
        return Math.max(l_sum, r_sum) + root.val;
    }
}
