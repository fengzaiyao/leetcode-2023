package io.github.fengzaiyao.leetcode.力扣热题100.v5._07_链表;

import io.github.fengzaiyao.leetcode.model.ListNode;
import io.github.fengzaiyao.leetcode.model.ListUtil;

// https://leetcode.cn/problems/reverse-nodes-in-k-group/?envType=study-plan-v2&id=top-100-liked

public class _10_K个一组翻转链表 {

    public static void main(String[] args) {
        ListNode listNodes = ListUtil.ListNodes(1, 2, 3, 4, 5, 6, 7);
        ListUtil.printList(reverseKGroup(listNodes, 3));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode fast = head;
        for (int i = 0; i < k - 1 && fast != null; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return head;
        }
        // 切割出下一条链表
        ListNode next = fast.next;
        fast.next = null;
        // 翻转当前链表
        ListNode newHead = reverseList(head);
        // 链接下一条链表
        head.next = reverseKGroup(next, k);
        return newHead;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return next;
    }
}
