package io.github.fengzaiyao.leetcode.力扣热题100.v3._07_链表;

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
        return doMergeKLists(0, lists.length - 1, lists);
    }

    public static ListNode doMergeKLists(int l, int r, ListNode[] lists) {
        if (l >= r) {
            return lists[l];
        }
        int mid = (l + r) / 2;
        ListNode l1 = doMergeKLists(l, mid, lists);
        ListNode l2 = doMergeKLists(mid + 1, r, lists);
        return mergeTwoLists(l1, l2);
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
