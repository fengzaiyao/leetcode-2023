package io.github.fengzaiyao.leetcode.力扣热题100.v7._07_链表;

import io.github.fengzaiyao.leetcode.model.ListNode;

// https://leetcode.cn/problems/intersection-of-two-linked-lists/?envType=study-plan-v2&id=top-100-liked

public class _01_相交链表 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tmpA = headA;
        ListNode tmpB = headB;
        while (headA != headB) {
            headA = headA == null ? tmpB : headA.next;
            headB = headB == null ? tmpA : headB.next;
        }
        return headA;
    }
}
