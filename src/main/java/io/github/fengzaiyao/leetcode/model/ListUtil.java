package io.github.fengzaiyao.leetcode.model;

public class ListUtil {

    public static ListNode ListNodes(int... nums) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        for (int num : nums) {
            pre.next = new ListNode(num);
            pre = pre.next;
        }
        return dummy.next;
    }

    public static void printList(ListNode head) {
        ListNode curIndex = head;
        while (curIndex != null) {
            System.out.print(curIndex + " ");
            curIndex = curIndex.next;
        }
        System.out.println();
    }
}
