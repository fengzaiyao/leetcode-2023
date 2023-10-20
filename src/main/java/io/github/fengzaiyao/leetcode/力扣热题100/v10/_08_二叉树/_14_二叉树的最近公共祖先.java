package io.github.fengzaiyao.leetcode.力扣热题100.v10._08_二叉树;

import io.github.fengzaiyao.leetcode.model.TreeNode;

// https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/

public class _14_二叉树的最近公共祖先 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if (l == null && r != null) {
            return r;
        }
        if (l != null && r == null) {
            return l;
        }
        if (l != null && r != null) {
            return root;
        }
        return null;
    }
}
