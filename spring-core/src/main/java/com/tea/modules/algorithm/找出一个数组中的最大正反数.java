package com.tea.modules.algorithm;

import java.util.Arrays;

/**
 * PACKAGE_NAME.<br>
 * 找出一个数组中的最大正反数
 * in: [0,1,2,3,-3,5].<br>
 * out: 3 <br>
 *
 * @author xiejiemin
 * @create 2020/9/3
 */
public class 找出一个数组中的最大正反数 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, -3, 5};
        int zfMax = findZfMax(nums);
        System.out.println(zfMax);
    }

    private static int findZfMax(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        if (nums[left] > 0) {
            return 0;
        }
        while (left < right) {
            if (-nums[left] == nums[right]) {
                return nums[right];
            }
            if (-nums[left] > nums[right]) {
                left++;
            } else {
                right--;
            }
        }
        return 0;
    }
}
