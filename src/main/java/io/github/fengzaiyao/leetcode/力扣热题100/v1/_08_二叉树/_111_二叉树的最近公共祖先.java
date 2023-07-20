package io.github.fengzaiyao.leetcode.力扣热题100.v1._08_二叉树;

// https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/?envType=study-plan-v2&id=top-100-liked

import io.github.fengzaiyao.leetcode.model.TreeNode;

public class _111_二叉树的最近公共祖先 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right == null) {
            return left;
        }
        if (left == null && right != null) {
            return right;
        }
        if (left != null && right != null) {
            return root;
        }
        return null;
    }
}
