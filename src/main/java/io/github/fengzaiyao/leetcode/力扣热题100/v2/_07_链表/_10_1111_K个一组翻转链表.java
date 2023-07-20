package io.github.fengzaiyao.leetcode.力扣热题100.v2._07_链表;

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
        // 切割前 k 个元素
        ListNode t = head;
        for (int i = 0; i < k - 1 && t != null; i++) {
            t = t.next;
        }
        // 不满足 k 个,直接 return 当前的链表
        if (t == null) {
            return head;
        }
        // 切割下一段 前 k 个元素
        ListNode nHead = t.next;
        t.next = null;
        // 反转当前链表
        ListNode node = reverseList(head);
        // 连接当前链表
        head.next = reverseKGroup(nHead, k);
        return node;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}
