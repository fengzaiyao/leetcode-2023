package io.github.fengzaiyao.leetcode.力扣热题100.v4._08_二叉树;

import io.github.fengzaiyao.leetcode.model.TreeNode;

// https://leetcode.cn/problems/validate-binary-search-tree/

public class _08_验证二叉搜索树 {

    private TreeNode pre = null;

    private boolean valid = true;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        doIsValidBST(root);
        return valid;
    }

    private void doIsValidBST(TreeNode root) {
        if (root == null) {
            return;
        }
        doIsValidBST(root.left);
        if (pre != null && pre.val >= root.val) {
            valid = false;
        }
        pre = root;
        doIsValidBST(root.right);
    }

}
