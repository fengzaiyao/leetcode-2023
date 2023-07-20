package io.github.fengzaiyao.leetcode.力扣热题100.v1._08_二叉树;

import io.github.fengzaiyao.leetcode.model.TreeNode;

// https://leetcode.cn/problems/invert-binary-tree/?envType=study-plan-v2&id=top-100-liked

public class 翻转二叉树 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode l_node = invertTree(root.left);
        TreeNode r_node = invertTree(root.right);
        root.left = r_node;
        root.right = l_node;
        return root;
    }
}
