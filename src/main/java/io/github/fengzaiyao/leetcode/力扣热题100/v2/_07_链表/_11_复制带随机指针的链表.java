package io.github.fengzaiyao.leetcode.力扣热题100.v2._07_链表;

import io.github.fengzaiyao.leetcode.model.Node;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/copy-list-with-random-pointer/?envType=study-plan-v2&id=top-100-liked

public class _11_复制带随机指针的链表 {

    public Node copyRandomList(Node head) {
        Node dummy = new Node(-1);
        Node pre = dummy;
        Map<Node, Node> map = new HashMap<>();
        // 复制普通节点
        Node temp = head;
        while (temp != null) {
            Node newNode = new Node(temp.val);
            map.put(temp, newNode);
            pre.next = newNode;
            pre = pre.next;
            temp = temp.next;
        }
        // 复制随机节点
        temp = head;
        while (temp != null) {
            Node node = map.get(temp);
            node.random = map.get(temp.random);
            temp = temp.next;
        }
        return dummy.next;
    }
}
