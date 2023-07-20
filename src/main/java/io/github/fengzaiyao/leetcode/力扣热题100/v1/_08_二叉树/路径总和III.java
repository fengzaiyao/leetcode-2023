package io.github.fengzaiyao.leetcode.力扣热题100.v1._08_二叉树;

// https://leetcode.cn/problems/path-sum-iii/?envType=study-plan-v2&id=top-100-liked

import io.github.fengzaiyao.leetcode.model.TreeNode;

public class 路径总和III {

    private int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        doPathSum(root, targetSum);
        return count;
    }

    private void doPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        int target = targetSum - root.val;
        if (target == 0) {
            count++;
        }
        doPathSum(root.left, target);
        doPathSum(root.right, target);
    }
}
