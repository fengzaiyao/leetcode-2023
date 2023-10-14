package io.github.fengzaiyao.leetcode.力扣热题100.v9._11_二分查找;

// https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/?envType=study-plan-v2&id=top-100-liked

public class _05_寻找旋转排序数组中的最小值 {

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(findMin(new int[]{11, 13, 15, 17}));
        System.out.println(findMin(new int[]{3, 1, 2}));
    }

    public static int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }

}
