package io.github.fengzaiyao.leetcode.力扣热题100.v1._04_子串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.cn/problems/sliding-window-maximum/?envType=study-plan-v2&id=top-100-liked

public class 滑动窗口最大值 {

    public static void main(String[] args) {
        int[] arr = maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> retList = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.addLast(i);
            if (i - queue.peekFirst() + 1 > k) {
                queue.pollFirst();
            }
            if (i + 1 >= k) {
                retList.add(nums[queue.peekFirst()]);
            }
        }
        int ans[] = new int[retList.size()];
        for (int i = 0; i < retList.size(); i++) {
            ans[i] = retList.get(i);
        }
        return ans;
    }

}
