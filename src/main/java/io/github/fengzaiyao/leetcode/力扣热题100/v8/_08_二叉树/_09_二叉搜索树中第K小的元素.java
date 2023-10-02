package io.github.fengzaiyao.leetcode.力扣热题100.v8._08_二叉树;

import io.github.fengzaiyao.leetcode.model.TreeNode;

// https://leetcode.cn/problems/kth-smallest-element-in-a-bst/

public class _09_二叉搜索树中第K小的元素 {

    private int kth = -1;

    private Integer ret = null;

    public int kthSmallest(TreeNode root, int k) {
        kth = k;
        doKthSmallest(root);
        return ret;
    }

    public void doKthSmallest(TreeNode root) {
        if (root == null) {
            return;
        }
        doKthSmallest(root.left);
        if (--kth == 0) {
            ret = root.val;
            return;
        }
        doKthSmallest(root.right);
    }
}
