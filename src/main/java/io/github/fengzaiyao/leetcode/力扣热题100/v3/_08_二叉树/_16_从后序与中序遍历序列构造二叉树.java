package io.github.fengzaiyao.leetcode.力扣热题100.v3._08_二叉树;

import io.github.fengzaiyao.leetcode.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/submissions/

public class _16_从后序与中序遍历序列构造二叉树 {

    private Map<Integer, Integer> map = new HashMap<>();

    private int curIndex = -1;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        curIndex = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return doBuild(0, postorder.length - 1, postorder);
    }

    public TreeNode doBuild(int l, int r, int[] postorder) {
        if (l > r) {
            return null;
        }
        int val = postorder[curIndex--];
        Integer idx = map.get(val);
        TreeNode node = new TreeNode(val);
        node.right = doBuild(idx + 1, r, postorder);
        node.left = doBuild(l, idx - 1, postorder);
        return node;
    }
}
