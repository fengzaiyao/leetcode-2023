package io.github.fengzaiyao.leetcode.力扣热题100.v9._07_链表;

// https://leetcode.cn/problems/merge-two-sorted-lists/?envType=study-plan-v2&id=top-100-liked

import io.github.fengzaiyao.leetcode.model.ListNode;

public class _06_合并两个有序链表 {

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
