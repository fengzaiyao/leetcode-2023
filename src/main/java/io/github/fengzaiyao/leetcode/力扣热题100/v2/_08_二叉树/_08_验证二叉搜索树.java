package io.github.fengzaiyao.leetcode.力扣热题100.v2._08_二叉树;

import io.github.fengzaiyao.leetcode.model.TreeNode;

// https://leetcode.cn/problems/validate-binary-search-tree/

public class _08_验证二叉搜索树 {

    private TreeNode pre;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean l = isValidBST(root.left);
        if (pre != null && pre.val >= root.val) {
            return false;
        }
        pre = root;
        boolean r = isValidBST(root.right);
        return l && r;
    }

}
