package io.github.fengzaiyao.leetcode.力扣热题100.v8._08_二叉树;

import io.github.fengzaiyao.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.cn/problems/binary-tree-level-order-traversal/

public class _06_二叉树的层序遍历 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            List<Integer> items = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollFirst();
                items.add(node.val);
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
            result.add(items);
        }
        return result;
    }
}
