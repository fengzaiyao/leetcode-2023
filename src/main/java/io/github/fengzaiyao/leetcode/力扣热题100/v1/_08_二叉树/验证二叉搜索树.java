package io.github.fengzaiyao.leetcode.力扣热题100.v1._08_二叉树;

import io.github.fengzaiyao.leetcode.model.TreeNode;

// https://leetcode.cn/problems/validate-binary-search-tree/?envType=study-plan-v2&id=top-100-liked

public class 验证二叉搜索树 {

    private TreeNode pre;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean l_bool = isValidBST(root.left);
        if (pre != null && root.val <= pre.val) {
            return false;
        }
        pre = root;
        boolean r_bool = isValidBST(root.right);
        return l_bool && r_bool;
    }
}
