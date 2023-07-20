package io.github.fengzaiyao.leetcode.力扣热题100.v1._08_二叉树;

import io.github.fengzaiyao.leetcode.model.TreeNode;

// https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/?envType=study-plan-v2&id=top-100-liked

public class _111_将有序数组转换为二叉搜索树 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return doBuild(nums, 0, nums.length - 1);
    }

    public TreeNode doBuild(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = doBuild(nums, left, mid - 1);
        node.right = doBuild(nums, mid + 1, right);
        return node;
    }
}
