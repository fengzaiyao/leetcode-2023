package io.github.fengzaiyao.leetcode.力扣热题100.v1._11_二分查找;

// https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/?envType=study-plan-v2&id=top-100-liked

import java.util.Arrays;

public class _111_在排序数组中查找元素的第一个和最后一个位置 {

    public static void main(String[] args) {
        int[] ans = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] searchRange(int[] nums, int target) {
        int l = searchRange(nums, target, true);
        int r = searchRange(nums, target, false);
        return new int[]{l, r};
    }

    public static int searchRange(int[] nums, int target, boolean isLeft) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                // 左边找,缩短右边边界
                if (isLeft) {
                    if (mid - 1 >= 0 && nums[mid] == nums[mid - 1]) {
                        r = mid - 1;
                    } else {
                        return mid;
                    }
                }
                // 右边找,缩短左边边界
                else {
                    if (mid + 1 <= nums.length - 1 && nums[mid] == nums[mid + 1]) {
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
