package io.github.fengzaiyao.leetcode.力扣热题100.v8._07_链表;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/lru-cache/?envType=study-plan-v2&envId=top-100-liked

public class _14_LRU缓存 {

    class LRUCache {

        class CacheNode {
            int key;
            int val;
            CacheNode pre;
            CacheNode next;

            CacheNode(int key, int val) {
                this.key = key;
                this.val = val;
            }

            CacheNode() {
            }
        }

        private int MAX = -1;
        private Map<Integer, CacheNode> map = new HashMap<>();
        private CacheNode head = new CacheNode();
        private CacheNode tail = new CacheNode();

        public LRUCache(int capacity) {
            MAX = capacity;
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            CacheNode cacheNode = map.get(key);
            if (cacheNode == null) {
                return -1;
            } else {
                this.moveToHead(cacheNode);
                return cacheNode.val;
            }
        }

        public void put(int key, int value) {
            CacheNode cache = map.get(key);
            if (cache != null) {
                cache.val = value;
                this.moveToHead(cache);
            } else {
                CacheNode newNode = new CacheNode(key, value);
                map.put(key, newNode);
                this.addToHead(newNode);
                // 是否超过最大容量、移除map、移除链表尾部元素
                if (map.size() > MAX) {
                    CacheNode removeNode = this.removeNode(tail.pre);
                    map.remove(removeNode.key);
                }
            }
        }

        private CacheNode removeNode(CacheNode node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            return node;
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
    }
}
