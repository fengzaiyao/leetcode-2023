package io.github.fengzaiyao.leetcode.力扣热题100.v4._08_二叉树;

import io.github.fengzaiyao.leetcode.model.TreeNode;

// https://leetcode.cn/problems/kth-smallest-element-in-a-bst/

public class _09_二叉搜索树中第K小的元素 {

    private int curK = -1;

    private int curVal = -1;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        curK = k;
        doKthSmallest(root);
        return curVal;
    }

    private void doKthSmallest(TreeNode root) {
        if (root == null) {
            return;
        }
        doKthSmallest(root.left);
        if (--curK == 0) {
            curVal = root.val;
        }
        doKthSmallest(root.right);
    }
}
