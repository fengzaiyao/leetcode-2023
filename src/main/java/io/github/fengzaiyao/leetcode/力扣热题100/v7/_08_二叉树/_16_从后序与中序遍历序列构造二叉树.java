package io.github.fengzaiyao.leetcode.力扣热题100.v7._08_二叉树;

import io.github.fengzaiyao.leetcode.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/submissions/

public class _16_从后序与中序遍历序列构造二叉树 {

    private int idx = 0;
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        idx = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return doBuildTree(postorder, 0, postorder.length - 1);
    }

    private TreeNode doBuildTree(int[] postorder, int l, int r) {
        if (l > r) {
            return null;
        }
        int val = postorder[idx--];
        Integer idx = map.get(val);
        TreeNode node = new TreeNode(val);
        node.right = doBuildTree(postorder, idx + 1, r);
        node.left = doBuildTree(postorder, l, idx - 1);
        return node;
    }
}
