package io.github.fengzaiyao.leetcode.力扣热题100.v5._08_二叉树;

import io.github.fengzaiyao.leetcode.model.TreeNode;

// https://leetcode.cn/problems/diameter-of-binary-tree/

public class _05_二叉树的直径 {

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        doFind(root);
        return max;
    }

    public int doFind(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = doFind(root.left);
        int r = doFind(root.right);
        max = Math.max(max, l + r);
        return Math.max(l, r) + 1;
    }
}
