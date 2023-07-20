package io.github.fengzaiyao.leetcode.力扣热题100.v2._07_链表;

import io.github.fengzaiyao.leetcode.model.ListNode;
import io.github.fengzaiyao.leetcode.model.ListUtil;

// https://leetcode.cn/problems/merge-k-sorted-lists/?envType=study-plan-v2&id=top-100-liked

public class _13_合并K个升序链表 {

    public static void main(String[] args) {
        ListUtil.printList(mergeKLists(new ListNode[]{}));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        return doMergeKLists(lists, 0, lists.length - 1);
    }

    public static ListNode doMergeKLists(ListNode[] lists, int left, int right) {
        if (left >= right) {
            return lists[left];
        }
        int mid = (left + right) / 2;
        ListNode l = doMergeKLists(lists, left, mid);
        ListNode r = doMergeKLists(lists, mid + 1, right);
        return mergeTwoList(l, r);
    }

    private static ListNode mergeTwoList(ListNode l1, ListNode l2) {
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
