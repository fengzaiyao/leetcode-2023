package io.github.fengzaiyao.leetcode.力扣热题100.v10._07_链表;

import io.github.fengzaiyao.leetcode.model.ListNode;

// https://leetcode.cn/problems/linked-list-cycle-ii/?envType=study-plan-v2&id=top-100-liked

public class _05_环形链表II {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

}
