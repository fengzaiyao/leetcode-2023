package io.github.fengzaiyao.leetcode.力扣热题100.v1._08_二叉树;

import io.github.fengzaiyao.leetcode.model.TreeNode;

// https://leetcode.cn/problems/symmetric-tree/?envType=study-plan-v2&id=top-100-liked

public class 对称二叉树 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return doSymmetric(root.left, root.right);
    }

    public boolean doSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null && right != null) {
            return false;
        }
        if (left != null && right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return doSymmetric(left.left, right.right) && doSymmetric(left.right, right.left);
    }
}
