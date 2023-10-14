package io.github.fengzaiyao.leetcode.other;

import java.util.Arrays;

public class _01_快排 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 4, 7, 9, 6, 8, 5, 8};
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        int temp = arr[left];
        int l = left;
        int r = right;
        while (l < r) {
            while (l < r && arr[r] >= temp) {
                r--;
            }
            if (l < r) {
                arr[l++] = arr[r];
            }

            while (l < r && arr[l] < temp) {
                l++;
            }
            if (l < r) {
                arr[r--] = arr[l];
            }
        }
        arr[l] = temp;
        quickSort(arr, left, l - 1);
        quickSort(arr, l + 1, right);
    }
}
