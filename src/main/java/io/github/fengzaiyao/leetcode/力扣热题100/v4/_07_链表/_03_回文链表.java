package io.github.fengzaiyao.leetcode.力扣热题100.v4._07_链表;

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
        ListNode mid = findMid(head);
        ListNode next = mid.next;
        mid.next = null;
        next = reverseList(next);
        while (head != null && next != null) {
            if (head.val != next.val) {
                return false;
            }
            head = head.next;
            next = next.next;
        }
        return true;
    }

    public static ListNode findMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
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
