package io.github.fengzaiyao.leetcode.力扣热题100.v8._11_二分查找;

// https://leetcode.cn/problems/search-in-rotated-sorted-array/?envType=study-plan-v2&id=top-100-liked

public class _04_搜索旋转排序数组 {

    public static void main(String[] args) {
        System.out.println(search(new int[]{3, 1}, 1));
    }

    public static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > nums[r]) {
                if (nums[l] <= target && target <= nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
