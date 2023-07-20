package io.github.fengzaiyao.leetcode.力扣热题100.v1._08_二叉树;

import io.github.fengzaiyao.leetcode.model.TreeNode;

// https://leetcode.cn/problems/diameter-of-binary-tree/?envType=study-plan-v2&id=top-100-liked

public class 二叉树的直径 {

    private Integer maxDeep = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        doDeep(root);
        return maxDeep;
    }

    public int doDeep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l_deep = doDeep(root.left);
        int r_deep = doDeep(root.right);
        maxDeep = Math.max(maxDeep, l_deep + r_deep);
        return Math.max(l_deep, r_deep) + 1;
    }
}
