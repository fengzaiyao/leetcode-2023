package io.github.fengzaiyao.leetcode.力扣热题100.v1._08_二叉树;

import io.github.fengzaiyao.leetcode.model.TreeNode;

// https://leetcode.cn/problems/kth-smallest-element-in-a-bst/?envType=study-plan-v2&id=top-100-liked

public class 二叉搜索树中第K小的元素 {

    private Integer result;

    private Integer k_num;

    public int kthSmallest(TreeNode root, int k) {
        k_num = k;
        calcKthSmallest(root);
        return result;
    }

    public void calcKthSmallest(TreeNode root) {
        if (root == null) {
            return;
        }
        calcKthSmallest(root.left);
        if (--k_num == 0) {
            result = root.val;
            return;
        }
        calcKthSmallest(root.right);
    }
}
