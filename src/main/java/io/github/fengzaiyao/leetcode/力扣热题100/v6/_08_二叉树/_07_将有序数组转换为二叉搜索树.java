package io.github.fengzaiyao.leetcode.力扣热题100.v6._08_二叉树;

import io.github.fengzaiyao.leetcode.model.TreeNode;

// https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/

public class _07_将有序数组转换为二叉搜索树 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return doBuildTree(nums, 0, nums.length - 1);
    }

    public TreeNode doBuildTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = doBuildTree(nums, left, mid - 1);
        node.right = doBuildTree(nums, mid + 1, right);
        return node;
    }
}
