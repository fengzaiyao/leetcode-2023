package io.github.fengzaiyao.leetcode.力扣热题100.v4._07_链表;

import io.github.fengzaiyao.leetcode.model.Node;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/copy-list-with-random-pointer/?envType=study-plan-v2&id=top-100-liked

public class _11_复制带随机指针的链表 {

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node dummy = new Node(-1);
        Node pre = dummy;
        Node temp = head;
        // 复制主体
        while (temp != null) {
            Node next = temp.next;
            Node newNode = new Node(temp.val);
            map.put(temp, newNode);
            pre.next = newNode;
            pre = pre.next;
            temp = next;
        }
        // 复制Random
        while (head != null) {
            Node node = map.get(head);
            node.random = map.get(head.random);
            head = head.next;
        }
        return dummy.next;
    }
}
