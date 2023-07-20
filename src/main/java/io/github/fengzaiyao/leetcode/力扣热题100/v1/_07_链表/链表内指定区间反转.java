package io.github.fengzaiyao.leetcode.力扣热题100.v1._07_链表;

// https://www.nowcoder.com/practice/b58434e200a648c589ca2063f1faf58c?tpId=295&tqId=654&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj%3Ftab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D295

import io.github.fengzaiyao.leetcode.model.ListNode;
import io.github.fengzaiyao.leetcode.model.ListUtil;

public class 链表内指定区间反转 {

    public static void main(String[] args) {
        链表内指定区间反转 test = new 链表内指定区间反转();
        ListNode listNodes = ListUtil.ListNodes(1, 2, 3, 4, 5);
        ListUtil.printList(test.reverseBetween(listNodes, 2, 4));
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode left = dummy;
        ListNode right = dummy;
        // 寻找要断开的前两节点
        for (int i = 0; i < m - 1; i++) {
            left = left.next;
        }
        for (int i = 0; i < n; i++) {
            right = right.next;
        }
        ListNode l_start = left.next;
        ListNode r_start = right.next;
        // 断开链表
        left.next = null;
        right.next = null;
        // 连接链表
        left.next = reverseList(l_start);
        l_start.next = r_start;
        return dummy.next;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}
