package io.github.fengzaiyao.leetcode.力扣热题100.v9._07_链表;

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
        // 断开链表
        temp.next = null;
        // 翻转链表
        reverseList(head);
        // 下次递归
        head.next = reverseKGroup(r, k);
        return temp;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
