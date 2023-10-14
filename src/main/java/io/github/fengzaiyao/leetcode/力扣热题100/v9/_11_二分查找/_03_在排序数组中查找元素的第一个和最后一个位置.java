package io.github.fengzaiyao.leetcode.力扣热题100.v9._11_二分查找;

// https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/?envType=study-plan-v2&id=top-100-liked

import java.util.Arrays;

public class _03_在排序数组中查找元素的第一个和最后一个位置 {

    public static void main(String[] args) {
        int[] ans = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        // int[] ans = searchRange(new int[]{2, 2}, 2);
        System.out.println(Arrays.toString(ans));
        System.out.println(Arrays.toString(ans));
    }

    public static int[] searchRange(int[] nums, int target) {
        int l = doSearch(nums, target, true);
        int r = doSearch(nums, target, false);
        return new int[]{l, r};
    }

    public static int doSearch(int[] nums, int target, boolean searchLeft) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                if (searchLeft) {
                    if (mid - 1 >= 0 && nums[mid - 1] == nums[mid]) {
                        r = mid - 1;
                    } else {
                        return mid;
                    }
                } else {
                    if (mid + 1 < nums.length && nums[mid + 1] == nums[mid]) {
                        l = mid + 1;
                    } else {
                        return mid;
                    }
                }
            } else if (nums[mid] > target) {
                r = mid - 1;

            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
