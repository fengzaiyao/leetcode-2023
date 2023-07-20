package io.github.fengzaiyao.leetcode.力扣热题100.v3._08_二叉树;

import io.github.fengzaiyao.leetcode.model.TreeNode;

// https://leetcode.cn/problems/diameter-of-binary-tree/

public class _05_二叉树的直径 {

    private int maxDeep = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        doDeep(root);
        return maxDeep;
    }

    public int doDeep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = doDeep(root.left);
        int r = doDeep(root.right);
        // 两边都要肯定比只取一边大
        maxDeep = Math.max(maxDeep, l + r);
        return Math.max(l, r) + 1;
    }
}
