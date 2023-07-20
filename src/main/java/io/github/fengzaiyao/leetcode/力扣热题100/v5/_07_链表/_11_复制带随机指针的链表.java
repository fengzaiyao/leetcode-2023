package io.github.fengzaiyao.leetcode.力扣热题100.v5._07_链表;

import io.github.fengzaiyao.leetcode.model.Node;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/copy-list-with-random-pointer/?envType=study-plan-v2&id=top-100-liked

public class _11_复制带随机指针的链表 {

    public Node copyRandomList(Node head) {
        // key = oldNode、val = newNode
        Map<Node, Node> map = new HashMap<>();
        Node dummy = new Node(-1);
        Node pre = dummy;
        Node tmp = head;
        while (tmp != null) {
            Node nNode = new Node(tmp.val);
            map.put(tmp, nNode);
            pre.next = nNode;
            pre = pre.next;
            tmp = tmp.next;
        }
        tmp = head;
        while (tmp != null) {
            Node nNode = map.get(tmp);
            nNode.random = map.get(tmp.random);
            tmp = tmp.next;
        }
        return dummy.next;
    }
}
