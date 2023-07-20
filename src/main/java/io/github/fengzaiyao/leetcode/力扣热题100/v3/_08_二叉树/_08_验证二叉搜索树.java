package io.github.fengzaiyao.leetcode.力扣热题100.v3._08_二叉树;

import io.github.fengzaiyao.leetcode.model.TreeNode;

// https://leetcode.cn/problems/validate-binary-search-tree/

public class _08_验证二叉搜索树 {

    private TreeNode pre = null;

    private boolean valid = true;

    public boolean isValidBST(TreeNode root) {
        doValid(root);
        return valid;
    }

    public void doValid(TreeNode root) {
        if (root == null) {
            return;
        }
        doValid(root.left);
        if (pre != null && root.val <= pre.val) {
            valid = false;
        }
        pre = root;
        doValid(root.right);
    }

}
