package io.github.fengzaiyao.leetcode.力扣热题100.v5._08_二叉树;

import io.github.fengzaiyao.leetcode.model.TreeNode;

// https://leetcode.cn/problems/kth-smallest-element-in-a-bst/

public class _09_二叉搜索树中第K小的元素 {

    private int kth = -1;

    private int ans = Integer.MIN_VALUE;

    public int kthSmallest(TreeNode root, int k) {
        kth = k;
        findKthSmallest(root);
        return ans;
    }

    public void findKthSmallest(TreeNode root) {
        if (root == null) {
            return;
        }
        findKthSmallest(root.left);
        if (--kth == 0) {
            ans = root.val;
        }
        findKthSmallest(root.right);
    }
}
