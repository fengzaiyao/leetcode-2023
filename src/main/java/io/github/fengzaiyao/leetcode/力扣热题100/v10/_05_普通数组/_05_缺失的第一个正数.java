package io.github.fengzaiyao.leetcode.力扣热题100.v10._05_普通数组;

// 题目: https://leetcode.cn/problems/first-missing-positive/
// 题解: https://leetcode.cn/problems/first-missing-positive/solution/que-shi-de-di-yi-ge-zheng-shu-by-leetcode-solution/
public class _05_缺失的第一个正数 {

    public static void main(String[] args) {
//        System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1}));
//        System.out.println(firstMissingPositive(new int[]{0, 1, 2}));
        System.out.println(firstMissingPositive(new int[]{1}));
    }

    public static int firstMissingPositive(int[] nums) {
        boolean hasOne = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                hasOne = true;
            }
            if (nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = 1;
            }
        }
        if (!hasOne) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            nums[idx] = -Math.abs(nums[idx]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
