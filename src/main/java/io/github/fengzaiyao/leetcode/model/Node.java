package io.github.fengzaiyao.leetcode.model;

public class Node {

    public Integer val;
    public Node next;
    public Node random;

    public Node(Integer val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}