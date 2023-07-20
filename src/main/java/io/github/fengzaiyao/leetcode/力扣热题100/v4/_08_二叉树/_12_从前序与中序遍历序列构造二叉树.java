package io.github.fengzaiyao.leetcode.力扣热题100.v4._08_二叉树;

import io.github.fengzaiyao.leetcode.model.TreeNode;

import java.util.HashMap;

// https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

public class _12_从前序与中序遍历序列构造二叉树 {

    private HashMap<Integer, Integer> map = new HashMap<>();

    private Integer curIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return doBuildTree(preorder, 0, inorder.length - 1);
    }

    private TreeNode doBuildTree(int[] preorder, int l, int r) {
        if (l > r) {
            return null;
        }
        int val = preorder[curIndex++];
        TreeNode node = new TreeNode(val);
        Integer mid = map.get(val);
        node.left = doBuildTree(preorder, l, mid - 1);
        node.right = doBuildTree(preorder, mid + 1, r);
        return node;
    }
}
