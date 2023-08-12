package io.github.fengzaiyao.leetcode.力扣热题100.v6._08_二叉树;

import io.github.fengzaiyao.leetcode.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

public class _12_从前序与中序遍历序列构造二叉树 {

    private Map<Integer, Integer> map = new HashMap<>();

    private int idx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return doBuildTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode doBuildTree(int[] preorder, int l, int r) {
        if (l > r) {
            return null;
        }
        int num = preorder[idx++];
        TreeNode node = new TreeNode(num);
        Integer index = map.get(num);
        node.left = doBuildTree(preorder, l, index - 1);
        node.right = doBuildTree(preorder, index + 1, r);
        return node;
    }
}
