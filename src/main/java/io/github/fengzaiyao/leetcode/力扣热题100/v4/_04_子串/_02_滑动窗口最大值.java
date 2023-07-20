package io.github.fengzaiyao.leetcode.力扣热题100.v4._04_子串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.cn/problems/sliding-window-maximum/?envType=study-plan-v2&id=top-100-liked

public class _02_滑动窗口最大值 {

    public static void main(String[] args) {
        int[] arr = maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 单调递减
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.add(i);
            if (i - queue.peekFirst() + 1 > k) {
                queue.pollFirst();
            }
            if (i + 1 >= k) {
                ans.add(nums[queue.peekFirst()]);
            }
        }
        int[] ret = new int[ans.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = ans.get(i);
        }
        return ret;
    }

}
