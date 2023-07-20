package io.github.fengzaiyao.leetcode.力扣热题100.v1._07_链表;

import io.github.fengzaiyao.leetcode.model.ListNode;

// https://leetcode.cn/problems/merge-k-sorted-lists/?envType=study-plan-v2&id=top-100-liked

public class 合并K个升序链表 {

    public static void main(String[] args) {
        合并K个升序链表 test = new 合并K个升序链表();
        ListNode node = test.mergeKLists(new ListNode[]{});
    }


    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        return doMergeKLists(0, lists.length - 1, lists);
    }

    public ListNode doMergeKLists(int left, int right, ListNode[] lists) {
        if (left >= right) {
            return lists[left];
        }
        int mid = (left + right) / 2;
        ListNode l1 = doMergeKLists(left, mid, lists);
        ListNode l2 = doMergeKLists(mid + 1, right, lists);
        return mergeTwoLists(l1, l2);
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
