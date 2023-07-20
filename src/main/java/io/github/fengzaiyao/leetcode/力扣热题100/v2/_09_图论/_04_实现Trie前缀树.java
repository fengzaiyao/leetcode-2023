package io.github.fengzaiyao.leetcode.力扣热题100.v2._09_图论;

// https://leetcode.cn/problems/implement-trie-prefix-tree/?envType=study-plan-v2&id=top-100-liked

public class _04_实现Trie前缀树 {

    class Trie {

        class Node {
            Node[] children = new Node[26];
            boolean wordEnd = false;
        }

        private Node root = new Node();

        public Trie() {
        }

        public void insert(String word) {
            Node temp = root;
            for (int i = 0; i <  word.length(); i++) {
                char ch = word.charAt(i);
                if (temp.children[ch - 'a'] == null) {
                    temp.children[ch - 'a'] = new Node();
                }
                temp = temp.children[ch - 'a'];
            }
            temp.wordEnd = true;
        }

        public boolean search(String word) {
            Node temp = root;
            for (int i = 0; i <  word.length(); i++) {
                char ch = word.charAt(i);
                if (temp.children[ch - 'a'] == null) {
                    return false;
                }
                temp = temp.children[ch - 'a'];
            }
            return temp.wordEnd;
        }

        public boolean startsWith(String prefix) {
            Node temp = root;
            for (int i = 0; i <  prefix.length(); i++) {
                char ch = prefix.charAt(i);
                if (temp.children[ch - 'a'] == null) {
                    return false;
                }
                temp = temp.children[ch - 'a'];
            }
            return true;
        }
    }
}
