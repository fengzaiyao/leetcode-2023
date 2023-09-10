package io.github.fengzaiyao.leetcode.力扣热题100.v7._05_普通数组;

import java.util.Arrays;

// https://leetcode.cn/problems/rotate-array/?envType=study-plan-v2&id=top-100-liked

public class _03_轮转数组 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
    }

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        swap(0, nums.length - 1, nums);
        swap(0, k - 1, nums);
        swap(k, nums.length - 1, nums);
    }

    private static void swap(int l, int r, int[] nums) {
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}
