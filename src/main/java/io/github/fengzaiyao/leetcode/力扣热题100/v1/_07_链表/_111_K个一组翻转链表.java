package io.github.fengzaiyao.leetcode.力扣热题100.v1._07_链表;

import io.github.fengzaiyao.leetcode.model.ListNode;
import io.github.fengzaiyao.leetcode.model.ListUtil;

// https://leetcode.cn/problems/reverse-nodes-in-k-group/submissions/

public class _111_K个一组翻转链表 {

    public static void main(String[] args) {
        ListNode listNodes = ListUtil.ListNodes(1, 2, 3, 4, 5, 6, 7, 8);
        ListUtil.printList(reverseKGroup(listNodes, 3));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        for (int i = 0; i < k - 1 && temp != null; i++) {
            temp = temp.next;
        }
        // 不够长度的不需要反转,直接返回return
        if (temp == null) {
            return head;
        }
        ListNode newHead = temp.next;
        temp.next = null;
        ListNode node = reverseList(head);
        head.next = reverseKGroup(newHead, k);
        return node;
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
