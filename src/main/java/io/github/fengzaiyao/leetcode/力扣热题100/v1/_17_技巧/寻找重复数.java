package io.github.fengzaiyao.leetcode.力扣热题100.v1._17_技巧;

// https://leetcode.cn/problems/find-the-duplicate-number/

public class 寻找重复数 {

    public int findDuplicate(int[] nums) {
        int l = 1;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            // [1,2,3,3,4,5]
            if (count > mid) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
