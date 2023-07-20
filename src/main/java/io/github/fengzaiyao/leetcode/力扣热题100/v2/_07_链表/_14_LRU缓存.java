package io.github.fengzaiyao.leetcode.力扣热题100.v2._07_链表;

import java.util.HashMap;
import java.util.Map;

public class _14_LRU缓存 {

    class LRUCache {

        class Node {
            int key;
            int val;
            Node next;
            Node pre;

            public Node() {
            }

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        int curCapacity;
        int capacity;
        Node head = new Node();
        Node tail = new Node();

        Map<Integer, Node> map;

        public LRUCache(int capacity) {
            this.head.next = tail;
            this.tail.pre = head;
            this.capacity = capacity;
            this.map = new HashMap<>();
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null) {
                return -1;
            }
            moveToHead(node);
            return node.val;
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if (node != null) {
                node.val = value;
                moveToHead(node);
            } else {
                Node newNode = new Node(key, value);
                map.put(key, newNode);
                addToHead(newNode);
                curCapacity++;
                if (curCapacity > capacity) {
                    Node removeNode = removeLast();
                    map.remove(removeNode.key);
                }
            }
        }

        public void moveToHead(Node node) {
            removeNode(node);
            addToHead(node);
        }

        public void addToHead(Node node) {
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
            node.pre = head;
        }

        public Node removeNode(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            return node;
        }

        public Node removeLast() {
            return removeNode(tail.pre);
        }
    }
}
