package io.github.fengzaiyao.leetcode.力扣热题100.v6._07_链表;

import java.util.HashMap;
import java.util.Map;

public class _14_LRU缓存 {

    class LRUCache {

        class CacheNode {
            int key;
            int val;
            CacheNode pre;
            CacheNode next;

            CacheNode() {
            }

            CacheNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        Map<Integer, CacheNode> map;
        int maxSize;
        CacheNode head = new CacheNode();
        CacheNode tail = new CacheNode();


        public LRUCache(int capacity) {
            map = new HashMap<>();
            maxSize = capacity;
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            CacheNode node = map.get(key);
            if (node == null) {
                return -1;
            }
            moveToHead(node);
            return node.val;
        }

        public void put(int key, int value) {
            CacheNode node = map.get(key);
            if (node != null) {
                node.val = value;
                moveToHead(node);
            } else {
                CacheNode newNode = new CacheNode(key, value);
                map.put(key, newNode);
                addToHead(newNode);
                if (map.size() > maxSize) {
                    CacheNode delNode = deleteTail();
                    map.remove(delNode.key);
                }
            }
        }

        private CacheNode addToHead(CacheNode node) {
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
            node.pre = head;
            return node;
        }

        private CacheNode moveToHead(CacheNode node) {
            removeNode(node);
            addToHead(node);
            return node;
        }

        private CacheNode removeNode(CacheNode node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            return node;
        }

        private CacheNode deleteTail() {
            return removeNode(tail.pre);
        }
    }
}
