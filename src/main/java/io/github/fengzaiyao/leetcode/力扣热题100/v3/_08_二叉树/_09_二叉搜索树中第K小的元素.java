package io.github.fengzaiyao.leetcode.力扣热题100.v3._08_二叉树;

import io.github.fengzaiyao.leetcode.model.TreeNode;

// https://leetcode.cn/problems/kth-smallest-element-in-a-bst/

public class _09_二叉搜索树中第K小的元素 {

    private int val = 0;

    private int curK = 0;

    public int kthSmallest(TreeNode root, int k) {
        curK = k;
        doFind(root);
        return val;
    }

    public void doFind(TreeNode root) {
        if (root == null) {
            return;
        }
        doFind(root.left);
        if (--curK == 0) {
            val = root.val;
        }
        doFind(root.right);
    }
}
