package io.github.fengzaiyao.leetcode.力扣热题100.v8._07_链表;

import io.github.fengzaiyao.leetcode.model.ListNode;
import io.github.fengzaiyao.leetcode.model.ListUtil;

// https://leetcode.cn/problems/palindrome-linked-list/submissions/

public class _03_回文链表 {

    public static void main(String[] args) {
        ListNode head = ListUtil.ListNodes(1, 0, 0);
        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // 寻找中点
        ListNode mid = findMid(head);
        ListNode r = mid.next;
        // 断开中点
        mid.next = null;
        // 翻转链表
        r = reverseList(r);
        // 比较
        while (r != null && head != null) {
            if (r.val != head.val) {
                return false;
            }
            r = r.next;
            head = head.next;
        }
        return true;
    }

    public static ListNode findMid(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode slow = node;
        ListNode fast = node.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
