package io.github.fengzaiyao.leetcode.力扣热题100.v4._08_二叉树;

import io.github.fengzaiyao.leetcode.model.TreeNode;

import java.util.HashMap;

// https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/submissions/

public class _16_从后序与中序遍历序列构造二叉树 {

    private HashMap<Integer, Integer> map = new HashMap<>();

    private int curIndex = -1;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        curIndex = inorder.length - 1;
        return doBuildTree(postorder, 0, inorder.length - 1);
    }

    private TreeNode doBuildTree(int[] postorder, int l, int r) {
        if (l > r) {
            return null;
        }
        int val = postorder[curIndex--];
        Integer mid = map.get(val);
        TreeNode node = new TreeNode(val);
        node.right = doBuildTree(postorder, mid + 1, r);
        node.left = doBuildTree(postorder, l, mid - 1);
        return node;
    }
}
