package io.github.fengzaiyao.leetcode.力扣热题100.v2._08_二叉树;

import io.github.fengzaiyao.leetcode.model.TreeNode;

// https://leetcode.cn/problems/binary-tree-maximum-path-sum/

public class _15_1111_二叉树中的最大路径和 {

    private int maxPath = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        doPathSum(root);
        maxPathSum(root.left);
        maxPathSum(root.right);
        return maxPath;
    }

    private int doPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = Math.max(doPathSum(root.left), 0);
        int r = Math.max(doPathSum(root.right), 0);
        maxPath = Math.max(maxPath, l + r + root.val);
        return Math.max(l, r) + root.val;
    }
}
