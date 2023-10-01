package io.github.fengzaiyao.leetcode.力扣热题100.v8._07_链表;

import io.github.fengzaiyao.leetcode.model.ListNode;

// https://leetcode.cn/problems/intersection-of-two-linked-lists/?envType=study-plan-v2&id=top-100-liked

public class _01_相交链表 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tA = headA;
        ListNode tB = headB;
        while (headA != headB) {
            headA = headA == null ? tB : headA.next;
            headB = headB == null ? tA : headB.next;
        }
        return headA;
    }
}
