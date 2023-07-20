package io.github.fengzaiyao.leetcode.力扣热题100.v1._08_二叉树;

import io.github.fengzaiyao.leetcode.model.TreeNode;

// https://leetcode.cn/problems/maximum-depth-of-binary-tree/?envType=study-plan-v2&id=top-100-liked

public class 二叉树的最大深度 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l_deep = maxDepth(root.left);
        int r_deep = maxDepth(root.right);
        return Math.max(l_deep, r_deep) + 1;
    }
}
