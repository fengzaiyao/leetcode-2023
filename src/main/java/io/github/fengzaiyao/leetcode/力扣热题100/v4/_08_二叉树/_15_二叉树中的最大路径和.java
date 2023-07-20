package io.github.fengzaiyao.leetcode.力扣热题100.v4._08_二叉树;

import io.github.fengzaiyao.leetcode.model.TreeNode;

// https://leetcode.cn/problems/binary-tree-maximum-path-sum/?envType=study-plan-v2&id=top-100-liked

public class _15_二叉树中的最大路径和 {

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        doPathSum(root);
        maxPathSum(root.left);
        maxPathSum(root.right);
        return maxSum;
    }

    private int doPathSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = Math.max(doPathSum(node.left), 0);
        int r = Math.max(doPathSum(node.right), 0);
        maxSum = Math.max(maxSum, l + r + node.val);
        return Math.max(l, r) + node.val;
    }
}
