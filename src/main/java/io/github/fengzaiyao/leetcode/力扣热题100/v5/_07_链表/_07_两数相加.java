package io.github.fengzaiyao.leetcode.力扣热题100.v5._07_链表;

import io.github.fengzaiyao.leetcode.model.ListNode;

// https://leetcode.cn/problems/add-two-numbers/?envType=study-plan-v2&id=top-100-liked

public class _07_两数相加 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        int remain = 0;
        while (l1 != null || l2 != null) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int num = (v1 + v2 + remain) / 10;
            remain = (v1 + v2 + remain) % 10;
            pre.next = new ListNode(num);
            pre = pre.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (remain != 0) {
            pre.next = new ListNode(remain);
        }
        return dummy.next;
    }
}
