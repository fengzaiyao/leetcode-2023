package io.github.fengzaiyao.leetcode.力扣热题100.v1._08_二叉树;

import io.github.fengzaiyao.leetcode.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

public class 从前序与中序遍历序列构造二叉树 {

    private Map<Integer, Integer> map = new HashMap<>();

    private Integer curIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return doBuildTree(preorder, 0, inorder.length - 1);
    }

    public TreeNode doBuildTree(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }
        int val = preorder[curIndex++];
        TreeNode node = new TreeNode(val);
        Integer idx = map.get(val);
        node.left = doBuildTree(preorder, left, idx - 1);
        node.left = doBuildTree(preorder, idx + 1, right);
        return node;
    }
}
