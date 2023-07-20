package io.github.fengzaiyao.leetcode.力扣热题100.v2._08_二叉树;

import io.github.fengzaiyao.leetcode.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/submissions/

public class _16_从后序与中序遍历序列构造二叉树 {

    private int curIndex;

    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        curIndex = postorder.length - 1;
        return doBuildTree(postorder, 0, inorder.length - 1);
    }

    public TreeNode doBuildTree(int[] postorder, int left, int right) {
        if (left > right) {
            return null;
        }
        int val = postorder[curIndex--];
        TreeNode node = new TreeNode(val);
        Integer idx = map.get(val);
        // 这里的 node.right 和 node.left 上下顺序绝对不能出错
        node.right = doBuildTree(postorder, idx + 1, right);
        node.left = doBuildTree(postorder, left, idx - 1);
        return node;
    }
}
