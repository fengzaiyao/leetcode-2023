package io.github.fengzaiyao.leetcode.力扣热题100.v4._08_二叉树;

import io.github.fengzaiyao.leetcode.model.TreeNode;

// https://leetcode.cn/problems/diameter-of-binary-tree/

public class _05_二叉树的直径 {

    private int maxDeep = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        doCalc(root);
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        return maxDeep;
    }

    private int doCalc(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = doCalc(root.left);
        int r = doCalc(root.right);
        maxDeep = Math.max(maxDeep, l + r);
        return Math.max(l, r) + 1;
    }
}
