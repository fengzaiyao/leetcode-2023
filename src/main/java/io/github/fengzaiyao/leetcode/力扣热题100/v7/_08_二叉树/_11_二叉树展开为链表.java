package io.github.fengzaiyao.leetcode.力扣热题100.v7._08_二叉树;

import io.github.fengzaiyao.leetcode.model.TreeNode;

// https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/

public class _11_二叉树展开为链表 {

    // 右左中

    private TreeNode pre;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}
