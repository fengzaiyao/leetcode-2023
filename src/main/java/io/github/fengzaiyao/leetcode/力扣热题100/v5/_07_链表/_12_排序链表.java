package io.github.fengzaiyao.leetcode.力扣热题100.v5._07_链表;

// https://leetcode.cn/problems/sort-list/?envType=study-plan-v2&id=top-100-liked

import io.github.fengzaiyao.leetcode.model.ListNode;

public class _12_排序链表 {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 找到中点并将链表切割成两段
        ListNode mid = findMid(head);
        ListNode l_start = mid.next;
        mid.next = null;
        // 最小切割成一个元素
        ListNode l = sortList(head);
        ListNode r = sortList(l_start);
        // 合并两个有序链表
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
