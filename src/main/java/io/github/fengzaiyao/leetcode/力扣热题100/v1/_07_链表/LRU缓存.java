package io.github.fengzaiyao.leetcode.力扣热题100.v1._07_链表;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/lru-cache/?envType=study-plan-v2&id=top-100-liked

public class LRU缓存 {

    class LRUCache {

        class CacheNode {
            public Integer key;
            public Integer val;
            public CacheNode pre;
            public CacheNode next;

            public CacheNode() {
            }

            public CacheNode(Integer key, Integer val) {
                this.key = key;
                this.val = val;
            }
        }

        private Integer capacity;
        private Integer currCapacity = 0;
        private CacheNode head = new CacheNode();
        private CacheNode tail = new CacheNode();
        private Map<Integer, CacheNode> map = new HashMap<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            CacheNode node = map.get(key);
            if (node != null) {
                moveToHead(node);
                return node.val;
            }
            return -1;
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
                ++currCapacity;
                if (currCapacity > capacity) {
                    CacheNode delNode = removeLast();
                    map.remove(delNode.key);
                    --currCapacity;
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
            remove(node);
            addToHead(node);
            return node;
        }

        private CacheNode remove(CacheNode node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            return node;
        }

        private CacheNode removeLast() {
            return remove(tail.pre);
        }
    }
}
