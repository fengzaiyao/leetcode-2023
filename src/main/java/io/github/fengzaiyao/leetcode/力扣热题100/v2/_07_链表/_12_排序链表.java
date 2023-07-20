package io.github.fengzaiyao.leetcode.力扣热题100.v2._07_链表;

// https://leetcode.cn/problems/sort-list/?envType=study-plan-v2&id=top-100-liked

import io.github.fengzaiyao.leetcode.model.ListNode;

public class _12_排序链表 {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 找到中点
        ListNode mid = findMid(head);
        // 将链表分为2条
        ListNode rHead = mid.next;
        mid.next = null;
        // 递归
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(rHead);
        // 合并两条链表
        return mergeTwoList(l1, l2);
    }

    private ListNode findMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoList(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoList(l1, l2.next);
            return l2;
        }
    }
}
