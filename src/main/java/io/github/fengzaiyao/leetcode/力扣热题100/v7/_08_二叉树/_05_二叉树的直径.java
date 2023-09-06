package io.github.fengzaiyao.leetcode.力扣热题100.v7._08_二叉树;

import io.github.fengzaiyao.leetcode.model.TreeNode;

// https://leetcode.cn/problems/diameter-of-binary-tree/

public class _05_二叉树的直径 {

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        doDiameter(root);
        return max;
    }

    public int doDiameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = doDiameter(root.left);
        int r = doDiameter(root.right);
        max = Math.max(max, l + r);
        return Math.max(l, r) + 1;
    }
}
