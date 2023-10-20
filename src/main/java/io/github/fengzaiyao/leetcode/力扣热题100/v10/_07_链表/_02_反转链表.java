package io.github.fengzaiyao.leetcode.力扣热题100.v10._07_链表;

import io.github.fengzaiyao.leetcode.model.ListNode;

// https://leetcode.cn/problems/reverse-linked-list/

public class _02_反转链表 {

//    public ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode pre = null;
//        while (head != null) {
//            ListNode next = head.next;
//            head.next = pre;
//            pre = head;
//            head = next;
//        }
//        return pre;
//    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return next;
    }
}
