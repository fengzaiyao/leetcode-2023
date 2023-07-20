package io.github.fengzaiyao.leetcode.力扣热题100.v1._05_普通数组;

import java.util.Arrays;

// https://leetcode.cn/problems/rotate-array/?envType=study-plan-v2&id=top-100-liked

public class _111_轮转数组 {

    public static void main(String[] args) {
        _111_轮转数组 test = new _111_轮转数组();
        int[] arr = new int[]{1, 2, 3, 4, 5};
        test.rotate(arr, 2);
        System.out.println(Arrays.toString(arr));
    }

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
    }
}
