package io.github.fengzaiyao.leetcode.力扣热题100.v6._08_二叉树;

import io.github.fengzaiyao.leetcode.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/submissions/

public class _16_从后序与中序遍历序列构造二叉树 {

    private Map<Integer, Integer> map = new HashMap<>();

    private int idx = -1;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        idx = postorder.length - 1;
        return doBuildTree(postorder, 0, postorder.length - 1);
    }

    private TreeNode doBuildTree(int[] preorder, int l, int r) {
        if (l > r) {
            return null;
        }
        int num = preorder[idx--];
        TreeNode node = new TreeNode(num);
        Integer index = map.get(num);
        node.right = doBuildTree(preorder, index + 1, r);
        node.left = doBuildTree(preorder, l, index - 1);
        return node;
    }
}
