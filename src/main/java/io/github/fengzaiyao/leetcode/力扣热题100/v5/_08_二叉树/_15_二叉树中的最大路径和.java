package io.github.fengzaiyao.leetcode.力扣热题100.v5._08_二叉树;

import io.github.fengzaiyao.leetcode.model.TreeNode;

// https://leetcode.cn/problems/binary-tree-maximum-path-sum/?envType=study-plan-v2&id=top-100-liked

public class _15_二叉树中的最大路径和 {

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        doMaxPathSum(root);
        maxPathSum(root.left);
        maxPathSum(root.right);
        return max;
    }

    public int doMaxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = Math.max(doMaxPathSum(root.left), 0);
        int r = Math.max(doMaxPathSum(root.right), 0);
        max = Math.max(max, root.val + l + r);
        return Math.max(l, r) + root.val;
    }
}
