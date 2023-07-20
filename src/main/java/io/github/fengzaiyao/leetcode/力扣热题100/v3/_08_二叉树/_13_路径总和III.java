package io.github.fengzaiyao.leetcode.力扣热题100.v3._08_二叉树;

import io.github.fengzaiyao.leetcode.model.TreeNode;

// https://leetcode.cn/problems/path-sum-iii/

public class _13_路径总和III {

    private int count = 0;

    public int pathSum(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }
        doPathSum(root, targetSum - root.val);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return count;
    }

    private void doPathSum(TreeNode root, long targetSum) {
        if (root == null) {
            return;
        }
        if (targetSum == 0) {
            count++;
        }
        if (root.left != null) {
            doPathSum(root.left, targetSum - root.left.val);
        }
        if (root.right != null) {
            doPathSum(root.right, targetSum - root.right.val);
        }
    }
}
