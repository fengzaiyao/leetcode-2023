package io.github.fengzaiyao.leetcode.力扣热题100.v7._08_二叉树;

import io.github.fengzaiyao.leetcode.model.TreeNode;

// https://leetcode.cn/problems/symmetric-tree/

public class _04_对称二叉树 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return doIsSymmetric(root.left, root.right);
    }

    public boolean doIsSymmetric(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        }
        if (l == null || r == null) {
            return false;
        }
        if (l.val != r.val) {
            return false;
        }
        return doIsSymmetric(l.left, r.right) && doIsSymmetric(l.right, r.left);
    }
}
