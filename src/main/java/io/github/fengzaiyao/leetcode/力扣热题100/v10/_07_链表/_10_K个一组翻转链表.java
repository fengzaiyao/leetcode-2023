package io.github.fengzaiyao.leetcode.力扣热题100.v10._07_链表;

import io.github.fengzaiyao.leetcode.model.ListNode;
import io.github.fengzaiyao.leetcode.model.ListUtil;

// https://leetcode.cn/problems/reverse-nodes-in-k-group/?envType=study-plan-v2&id=top-100-liked

public class _10_K个一组翻转链表 {

    public static void main(String[] args) {
        ListNode listNodes = ListUtil.ListNodes(1, 2, 3, 4, 5, 6, 7);
        ListUtil.printList(reverseKGroup(listNodes, 3));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        for (int i = 0; i < k - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            return head;
        }
        ListNode r = temp.next;
        temp.next = null;
        reverseList(head);
        head.next = reverseKGroup(r, k);
        return temp;
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
