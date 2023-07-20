package io.github.fengzaiyao.leetcode.力扣热题100.v3._08_二叉树;

import io.github.fengzaiyao.leetcode.model.TreeNode;

// https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/

public class _07_111_将有序数组转换为二叉搜索树 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return doBuildTree(0, nums.length - 1, nums);
    }

    private TreeNode doBuildTree(int l, int r, int[] nums) {
        if (l > r) {
            return null;
        }
        int mid = (l + r) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = doBuildTree(l, mid - 1, nums);
        node.right = doBuildTree(mid + 1, r, nums);
        return node;
    }
}
