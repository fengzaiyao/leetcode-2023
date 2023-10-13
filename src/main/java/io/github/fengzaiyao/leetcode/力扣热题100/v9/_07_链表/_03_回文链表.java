package io.github.fengzaiyao.leetcode.力扣热题100.v9._07_链表;

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
        mid.next = null;
        // 翻转链表
        r = reverseList(r);
        while (head != null && r != null) {
            if (head.val != r.val) {
                return false;
            }
            head = head.next;
            r = r.next;
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
