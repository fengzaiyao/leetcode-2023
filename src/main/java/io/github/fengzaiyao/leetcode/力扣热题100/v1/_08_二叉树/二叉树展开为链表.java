package io.github.fengzaiyao.leetcode.力扣热题100.v1._08_二叉树;

import io.github.fengzaiyao.leetcode.model.TreeNode;

// https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/?envType=study-plan-v2&id=top-100-liked

public class 二叉树展开为链表 {

    private TreeNode pre;

    // 右 左 中
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        if (pre != null) {
            root.left = null;
            root.right = pre;
        }
        pre = root;
    }
}
