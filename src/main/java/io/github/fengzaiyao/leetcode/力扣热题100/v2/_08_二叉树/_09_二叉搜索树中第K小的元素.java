package io.github.fengzaiyao.leetcode.力扣热题100.v2._08_二叉树;

import io.github.fengzaiyao.leetcode.model.TreeNode;

// https://leetcode.cn/problems/kth-smallest-element-in-a-bst/

public class _09_二叉搜索树中第K小的元素 {

    private int ret = -1;

    private int kth = -1;

    public int kthSmallest(TreeNode root, int k) {
        kth = k;
        doSearch(root);
        return ret;
    }

    public void doSearch(TreeNode root) {
        if (root == null) {
            return;
        }
        doSearch(root.left);
        if (--kth == 0) {
            ret = root.val;
        }
        doSearch(root.right);
    }
}
