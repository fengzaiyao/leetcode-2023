package io.github.fengzaiyao.leetcode.力扣热题100.v1._09_图论;

// https://leetcode.cn/problems/implement-trie-prefix-tree/?envType=study-plan-v2&id=top-100-liked

public class 实现Trie前缀树 {

    class Trie {

        class TrieNode{
            public TrieNode[] trieNodes = new TrieNode[26];
            public boolean isEnd = false;
        }

        private TrieNode root = new TrieNode();

        public Trie() {
        }

        public void insert(String word) {
            TrieNode temp = root;
            char[] chars = word.toCharArray();
            int len = chars.length;
            for (int i = 0; i < len; i++) {
                int idx = chars[i] - 'a';
                if (temp.trieNodes[idx] == null) {
                    temp.trieNodes[idx] = new TrieNode();
                }
                temp = temp.trieNodes[idx];
            }
            temp.isEnd = true;
        }

        public boolean search(String word) {
            TrieNode temp = root;
            char[] chars = word.toCharArray();
            int len = chars.length;
            for (int i = 0; i < len; i++) {
                int idx = chars[i] - 'a';
                if (temp.trieNodes[idx] == null) {
                    return false;
                }
                temp = temp.trieNodes[idx];
            }
            return temp.isEnd;
        }

        public boolean startsWith(String prefix) {
            TrieNode temp = root;
            char[] chars = prefix.toCharArray();
            int len = chars.length;
            for (int i = 0; i < len; i++) {
                int idx = chars[i] - 'a';
                if (temp.trieNodes[idx] == null) {
                    return false;
                }
                temp = temp.trieNodes[idx];
            }
            return true;
        }
    }
}
