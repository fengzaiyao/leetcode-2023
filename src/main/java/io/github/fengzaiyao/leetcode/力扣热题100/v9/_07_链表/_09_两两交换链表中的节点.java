package io.github.fengzaiyao.leetcode.力扣热题100.v9._07_链表;

import io.github.fengzaiyao.leetcode.model.ListNode;
import io.github.fengzaiyao.leetcode.model.ListUtil;

// https://leetcode.cn/problems/swap-nodes-in-pairs/

public class _09_两两交换链表中的节点 {

    public static void main(String[] args) {
        ListNode listNodes = ListUtil.ListNodes(1, 2, 3, 4);
        ListUtil.printList(swapPairs(listNodes));
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}
