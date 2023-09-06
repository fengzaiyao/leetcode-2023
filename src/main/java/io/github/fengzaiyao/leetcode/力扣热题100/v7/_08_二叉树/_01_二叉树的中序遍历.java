package io.github.fengzaiyao.leetcode.力扣热题100.v7._08_二叉树;

import io.github.fengzaiyao.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode.cn/problems/binary-tree-inorder-traversal/

public class _01_二叉树的中序遍历 {

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        List<Integer> ans = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                ans.add(node.val);
                root = node.right;
            }
        }
        return ans;
    }
}
