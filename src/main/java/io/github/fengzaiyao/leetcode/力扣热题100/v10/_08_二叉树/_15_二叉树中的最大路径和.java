package io.github.fengzaiyao.leetcode.力扣热题100.v10._08_二叉树;

import io.github.fengzaiyao.leetcode.model.TreeNode;

// https://leetcode.cn/problems/binary-tree-maximum-path-sum/?envType=study-plan-v2&id=top-100-liked

public class _15_二叉树中的最大路径和 {

    private int maxPath = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        doPathSum(root);
        maxPathSum(root.left);
        maxPathSum(root.right);
        return maxPath;
    }

    public int doPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = Math.max(0, doPathSum(root.left));
        int r = Math.max(0, doPathSum(root.right));
        maxPath = Math.max(maxPath, l + r + root.val);
        return Math.max(l, r) + root.val;
    }
}
