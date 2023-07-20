package io.github.fengzaiyao.leetcode.力扣热题100.v3._08_二叉树;

import io.github.fengzaiyao.leetcode.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

public class _12_从前序与中序遍历序列构造二叉树 {

    private Map<Integer, Integer> map = new HashMap<>();

    private int curIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 记得是中序遍历的值
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return doBuild(0, preorder.length - 1, preorder);
    }

    public TreeNode doBuild(int l, int r, int[] preorder) {
        if (l > r) {
            return null;
        }
        int val = preorder[curIndex++];
        Integer idx = map.get(val);
        TreeNode node = new TreeNode(val);
        node.left = doBuild(l, idx - 1, preorder);
        node.right = doBuild(idx + 1, r, preorder);
        return node;
    }
}
