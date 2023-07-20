package io.github.fengzaiyao.leetcode.力扣热题100.v3._07_链表;

// https://www.nowcoder.com/practice/b58434e200a648c589ca2063f1faf58c?tpId=295&tqId=654&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj%3Ftab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D295

import io.github.fengzaiyao.leetcode.model.ListNode;
import io.github.fengzaiyao.leetcode.model.ListUtil;

public class _15_1111_链表内指定区间反转 {

    public static void main(String[] args) {
        ListNode listNodes = ListUtil.ListNodes(1, 2, 3, 4, 5);
        ListUtil.printList(reverseBetween(listNodes, 2, 4));
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode l = dummy;
        ListNode r = dummy;
        for (int i = 0; i < m - 1; i++) {
            l = l.next;
        }
        for (int i = 0; i < n; i++) {
            r = r.next;
        }
        // 截取要反转的区间
        ListNode l_start = l.next;
        l.next = null;
        ListNode r_start = r.next;
        r.next = null;
        // 连接断开的3段
        l.next = reverseList(l_start);
        l_start.next = r_start;
        return dummy.next;

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
