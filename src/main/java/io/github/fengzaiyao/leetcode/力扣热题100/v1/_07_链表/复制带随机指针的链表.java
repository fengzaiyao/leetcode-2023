package io.github.fengzaiyao.leetcode.力扣热题100.v1._07_链表;

import io.github.fengzaiyao.leetcode.model.Node;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/copy-list-with-random-pointer/?envType=study-plan-v2&id=top-100-liked

public class 复制带随机指针的链表 {

    public Node copyRandomList(Node head) {
        Node dummy = new Node(-1);
        Node pre = dummy;
        Map<Node, Node> map = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            // 连成链表
            Node node = new Node(temp.val);
            pre.next = node;
            pre = pre.next;
            // 放入map
            map.put(temp, node);
            // 下一个
            temp = temp.next;
        }

        // 复制随机节点
        temp = head;
        while (temp != null) {
            Node currNode = map.get(temp);
            Node randomNode = map.get(temp.random);
            currNode.random = randomNode;
            temp = temp.next;
        }
        return dummy.next;
    }
}
