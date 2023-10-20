package io.github.fengzaiyao.leetcode.力扣热题100.v10._07_链表;

// https://leetcode.cn/problems/sort-list/?envType=study-plan-v2&id=top-100-liked

import io.github.fengzaiyao.leetcode.model.ListNode;

public class _12_排序链表 {

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMid(head);
        ListNode newHead = mid.next;
        mid.next = null;
        ListNode l = sortList(head);
        ListNode r = sortList(newHead);
        return mergeTwoLists(l, r);
    }

    public static ListNode findMid(ListNode head) {
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

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
