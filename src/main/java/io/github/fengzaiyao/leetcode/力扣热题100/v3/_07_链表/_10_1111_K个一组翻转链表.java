package io.github.fengzaiyao.leetcode.力扣热题100.v3._07_链表;

import io.github.fengzaiyao.leetcode.model.ListNode;
import io.github.fengzaiyao.leetcode.model.ListUtil;

// https://leetcode.cn/problems/reverse-nodes-in-k-group/?envType=study-plan-v2&id=top-100-liked

public class _10_1111_K个一组翻转链表 {

    public static void main(String[] args) {
        ListNode listNodes = ListUtil.ListNodes(1, 2, 3, 4, 5, 6, 7);
        ListUtil.printList(reverseKGroup(listNodes, 3));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        // 切割前面k个元素
        ListNode fast = head;
        for (int i = 0; fast != null && i < k - 1; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return head;
        }
        ListNode next = fast.next;
        fast.next = null;
        // 连接下一个链表
        ListNode node = reverseList(head);
        head.next = reverseKGroup(next, k);
        return node;
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
